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
import com.example.assignment11.Player;
import com.example.assignment11.PlayerRepository;
import com.example.assignment11.R;
import com.example.assignment11.Team;
import com.example.assignment11.TeamRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class PlayerFragment extends Fragment {
    private PlayerRepository playerRepo;
    private ArrayAdapter<String> adapter;
    //connect to hardcoded data DataProvider

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_player, container, false);

        EditText searchBar = view.findViewById(R.id.searchBar);
        ListView listView = view.findViewById(R.id.listView);
        EditText teamInput = view.findViewById(R.id.teamInput);
        Button btnFilterTeam = view.findViewById(R.id.btnFilterTeam);

        DataProvider<Player> data = new DataProvider<>();
        List<Player> players = data.getData(Player.class);
        playerRepo = new PlayerRepository();
        //add the teams from hardcoded data to playerRepo
        for (Player player : players) {
            playerRepo.add(player);
        }

        //display the list of players
        List<String> playerNames = new ArrayList<>();
        Iterator<Player> iterator = playerRepo.PlayerIterator();

        while (iterator.hasNext()) {
            Player player = iterator.next();
            playerNames.add(player.getName().next());
        }

        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, playerNames);
        listView.setAdapter(adapter);

        //adding the button for filtering players based on their team
        btnFilterTeam.setOnClickListener(v-> {
            String team = teamInput.getText().toString().toLowerCase().trim();
            if (team.isBlank()) {
                throw new IllegalArgumentException("Team cannot be empty");
            }
            else {
                List<Player> filteredByTeam = playerRepo.filterByTeam(team);
                List<String> playersFiltered = new ArrayList<>();
                for (Player player : filteredByTeam) {
                    playersFiltered.add(player.getName().next());
                }
                adapter.clear();
                adapter.addAll(playersFiltered);
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

                List<Player> filtered = playerRepo.filter(
                        //this is lambda structure
                        player -> player.getPlayerName().toLowerCase().contains(query)
                );

                List<String> filteredNames = new ArrayList<>();
                for (Player player : filtered) {
                    filteredNames.add(player.getPlayerName());
                }

                adapter.clear();
                adapter.addAll(filteredNames);
                adapter.notifyDataSetChanged();
            }
        });
        return view;
    }
}