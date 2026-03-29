package com.example.assignment11;

import java.util.*;

//common interface for team, player, and match classes
public interface SoccerEntity {
    //implement custom iterators for collections of these entities
        //iterators for individual items (a team, a match, a player)
    Iterator<String> getID();
    Iterator<String> getName();

        //iterators for list of teams, players, matches
    Iterator<Team> TeamIterator();
    Iterator<Player> PlayerIterator();
    Iterator<Match> MatchIterator();
}
