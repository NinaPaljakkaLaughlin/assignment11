package com.example.assignment11;

import java.util.*;
//class PlayerRepository manages list of soccer players

public class PlayerRepository extends Repository<Player> {

    //error checking for empty team entry
    public List<Player> filterByTeam(String team) {
        if (team == null || team.isBlank()) {
            throw new IllegalArgumentException("League cannot be empty");
        }
        //create a new list for the filtered players based on their team
        List<Player> filteredPlayersByTeam = new ArrayList<>();

        //use getAll from Repository to loop through player teams and add to new list
        for (Player player : getAll()) {
            if (player.getTeam().equalsIgnoreCase(team)) {
                filteredPlayersByTeam.add(player);
            }
        }
        return filteredPlayersByTeam;
    }
    //define the iterator for managing all players
    public Iterator<Player> PlayerIterator() {
        //get the list of the players
        List<Player> players = getAll();

        return new Iterator<Player>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < players.size();
            }
            @Override
            public Player next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return players.get(index++);
            }
        };
    }
}