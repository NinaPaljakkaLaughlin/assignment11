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
import com.example.assignment11.Match;
import com.example.assignment11.MatchRepository;
import com.example.assignment11.Player;
import com.example.assignment11.R;


import java.util.ArrayList;
import java.util.List;


public class MatchFragment extends Fragment {
    private MatchRepository matchRepo;
    private ArrayAdapter<String> adapter;
    //connect to hardcoded data DataProvider

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_match, container, false);

        EditText searchBar = view.findViewById(R.id.searchBar);
        ListView listView = view.findViewById(R.id.listView);

        DataProvider<Match> data = new DataProvider<>();
        List<Match> matches = data.getData(Match.class);
        matchRepo = new MatchRepository();
        //add the teams from hardcoded data to matchRepo
        for (Match match : matches) {
            matchRepo.add(match);
        }

        //display the list of matches
        List<String> matchNames = new ArrayList<>();
        for (Match match : matchRepo.getAll()) {
            matchNames.add(match.getName().next());
        }

        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, matchNames);
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

                List<Match> filtered = matchRepo.filter(
                        //this is lambda structure
                        match -> match.getName().next().contains(query)
                );

                List<String> filteredNames = new ArrayList<>();
                for (Match match: filtered) {
                    filteredNames.add(match.getName().next());
                }

                adapter.clear();
                adapter.addAll(filteredNames);
                adapter.notifyDataSetChanged();
            }
        });
        return view;
    }
}