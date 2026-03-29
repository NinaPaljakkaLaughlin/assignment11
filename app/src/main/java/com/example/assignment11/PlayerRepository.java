package com.example.assignment11;

import java.util.*;
//class PlayerRepository manages list of soccer players

public class PlayerRepository extends Repository<Player>{

    //error checking for empty team entry
    public List<Player> filterByTeam(String team) {
        if (team == null) {
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

}