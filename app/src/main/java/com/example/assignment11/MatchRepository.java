package com.example.assignment11;
import java.util.*;

public class MatchRepository extends Repository<Match> {
    //error checking for empty league entry
    public List<Match> filterByTeam(String team) {
        if (team == null || team.isBlank()) {
            throw new IllegalArgumentException("Team cannot be empty");
        }
        //create a new list for the filtered league
        List<Match> filteredMatchesByTeam = new ArrayList<>();

        //use getAll from Repository to loop through match teams and add to new list
        for (Match match : getAll()) {
            if (match.getHomeTeam().equalsIgnoreCase(team)) {
                filteredMatchesByTeam.add(match);
            }
        }
        return filteredMatchesByTeam;
    }
    public Iterator<Match> MatchIterator() {
        //get the list of the matches (home-games)
        List<Match> matches = getAll();

        return new Iterator<Match>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < matches.size();
            }
            @Override
            public Match next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return matches.get(index++);
            }
        };
    }
}
