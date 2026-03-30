package com.example.assignment11.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.assignment11.DataProvider;
import com.example.assignment11.R;
import com.example.assignment11.Team;
import com.example.assignment11.TeamRepository;

import java.util.*;

public class TeamFragment extends Fragment {
    private TeamRepository teamRepo;
    private ArrayAdapter<String> adapter;
    //connect to hardcoded data DataProvider

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_team, container, false);

        EditText searchBar = view.findViewById(R.id.searchBar);
        ListView listView = view.findViewById(R.id.listView);
        EditText leagueInput = view.findViewById(R.id.leagueInput);
        Button btnFilterLeague = view.findViewById(R.id.btnFilterLeague);

        DataProvider<Team> data = new DataProvider<>();
        List<Team> teams = data.getData(Team.class);
        teamRepo = new TeamRepository();
        //add the teams from hardcoded data to teamRepo
        for (Team team : teams) {
            teamRepo.add(team);
        }

        //display the list of teams
        List<String> teamNames = new ArrayList<>();
        Iterator<Team> iterator = teamRepo.TeamIterator();

        while (iterator.hasNext()) {
            Team team = iterator.next();
            teamNames.add(team.getTeamName());
        }

        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, teamNames);
        listView.setAdapter(adapter);

        //adding the button for filtering teams based on their League
        btnFilterLeague.setOnClickListener(v-> {
            String league = leagueInput.getText().toString().toLowerCase().trim();
            if (league.isBlank()) {
                throw new IllegalArgumentException("League cannot be empty");
            }
            else {
                List<Team> filteredByLeague = teamRepo.filterByLeague(league);
                List<String> teamsFiltered = new ArrayList<>();
                for (Team team : filteredByLeague) {
                    teamsFiltered.add(team.getTeamName());
                }
                adapter.clear();
                adapter.addAll(teamsFiltered);
            }
        });

        //use lambda in the search bar functionality
        searchBar.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
           @Override
           public void afterTextChanged(Editable s) {}
           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {
               String query = s.toString().toLowerCase();

               List<Team> filtered = teamRepo.filter(
                       //this is lambda structure
                       team -> team.getTeamName().toLowerCase().contains(query)
               );

               List<String> filteredNames = new ArrayList<>();
               Iterator<Team> iterator = teamRepo.TeamIterator();

               while (iterator.hasNext()) {
                   Team team = iterator.next();
                   if (team.getTeamName().toLowerCase().contains(query)) {
                       filteredNames.add(team.getTeamName());
                   }
               }

               adapter.clear();
               adapter.addAll(filteredNames);
               adapter.notifyDataSetChanged();
           }
        });
        return view;
    }
}