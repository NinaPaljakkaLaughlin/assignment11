package com.example.assignment11.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

        DataProvider<Team> data = new DataProvider<>();
        List<Team> teams = data.getData(Team.class);
        teamRepo = new TeamRepository();
        //add the teams from hardcoded data to teamRepo
        for (Team team : teams) {
            teamRepo.add(team);
        }

        //display the list of teams
        List<String> teamNames = new ArrayList<>();
        for (Team team : teamRepo.getAll()) {
            teamNames.add(team.getTeamName());
        }

        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, teamNames);
        listView.setAdapter(adapter);

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
               for (Team team : filtered) {
                   filteredNames.add(team.getTeamName());
               }

               adapter.clear();
               adapter.addAll(filteredNames);
               adapter.notifyDataSetChanged();
           }
        });
        return view;
    }
}