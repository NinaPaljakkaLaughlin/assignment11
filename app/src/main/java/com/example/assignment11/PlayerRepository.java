package com.example.assignment11;

import java.util.*;
//class PlayerRepository manages list of soccer players

public class PlayerRepository extends Repository<Player> {

    //error checking for empty team entry
    public List<Player> filterByTeam(String team) {
        if (team == null || team.isBlank()) {
            throw new IllegalArgumentException("League cannot be empty");
        }

        //use stream and lambda expression to get and compare players, team
        return getAll().stream()
                .filter(player -> player.getTeam().equalsIgnoreCase(team))
                .sorted(Comparator.comparing(player -> player.getTeam().toLowerCase())).toList();
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