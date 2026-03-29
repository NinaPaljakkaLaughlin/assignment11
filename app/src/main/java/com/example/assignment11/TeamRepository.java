package com.example.assignment11;
import java.util.*;

//class TeamRepository manages list of soccer teams
public class TeamRepository extends Repository<Team> {
    //error checking for empty league entry
    public List<Team> filterByLeague(String league) {
        if (league == null) {
            throw new IllegalArgumentException("League cannot be empty");
        }
        //create a new list for the filtered league
        List<Team> filteredTeamsByLeague = new ArrayList<>();

        //use getAll from Repository to loop through teams leagues and add to new list
        for (Team team : getAll()) {
            if (team.getLeague().equalsIgnoreCase(league)) {
                filteredTeamsByLeague.add(team);
            }
        }

        return filteredTeamsByLeague;
    }
    //define the iterator for managing all teams, gets one team at a time
    public Iterator<Team> TeamIterator() {
        //get the list of the teams
        List<Team> teams = getAll();

        return new Iterator<Team>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < teams.size();
            }
            @Override
            public Team next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return teams.get(index++);
            }
        };
    }

}
