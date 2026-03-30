package com.example.assignment11;
import java.util.*;

public class MatchRepository extends Repository<Match> {
    //error checking for empty team entry
    public List<Match> filterByHomeTeam(String team) {
        if (team == null || team.isBlank()) {
            throw new IllegalArgumentException("Team cannot be empty");
        }

        //use stream and lambda expression to get and compare matches and home teams
        return getAll().stream()
                .filter(match -> match.getHomeTeam().equalsIgnoreCase(team))
                .sorted(Comparator.comparing(match -> match.getHomeTeam().toLowerCase())).toList();

        }

    //error checking for empty team entry
    public List<Match> filterByAwayTeam(String team) {
        if (team == null || team.isBlank()) {
            throw new IllegalArgumentException("Team cannot be empty");
        }
        //create a new list for the filtered league
        List<Match> filteredMatchesByTeam = new ArrayList<>();

        //use stream and lambda expression to get and compare matches and home teams
        return getAll().stream()
                .filter(match -> match.getAwayTeam().equalsIgnoreCase(team))
                .sorted(Comparator.comparing(match -> match.getAwayTeam().toLowerCase())).toList();

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
