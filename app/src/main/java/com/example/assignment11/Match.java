package com.example.assignment11;
import java.util.*;
//Match class defines a single match and methods associated:
// set/get homeTeam/awayTeam/score, iterators for name and id

public class Match implements SoccerEntity {
    //attributes
    private static int counter = 1; //track all match ids
    private int matchId; //track this match id
    private String homeTeam;
    private String awayTeam;
    private String score;
    public Match(String homeTeam, String awayTeam, String score) {
        if (homeTeam == null || homeTeam.isBlank()) {
            throw new IllegalArgumentException("Home Team cannot be empty");
        }
        if (awayTeam == null || awayTeam.isBlank()) {
            throw new IllegalArgumentException("Away Team cannot be empty");
        }
        if (score == null || score.isBlank()) {
            throw new IllegalArgumentException("Score cannot be empty");
        }
        this.matchId = counter++; //always add to the static counter when a new match is created
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.score = score;
    }

    //setters and getters for id, home team, away team, score
    public int getMatchID() {return matchId;}
    public String getHomeTeam() {return homeTeam;}
    public void setHomeTeam(String homeTeam) {
        if (homeTeam == null || homeTeam.isBlank()) {
            throw new IllegalArgumentException("Home team cannot be empty");
        }
        this.homeTeam = homeTeam;
    }
    public String getAwayTeam() {return awayTeam;}
    public void setAwayTeam(String awayTeam) {
        if (awayTeam == null || awayTeam.isBlank()) {
            throw new IllegalArgumentException("Away team cannot be empty");
        }
        this.awayTeam = awayTeam;
    }
    public String getScore() {return score;}
    public void setScore(String score) {
        if (score == null || score.isBlank()) {
            throw new IllegalArgumentException("Score cannot be empty");
        }
        this.score = score;
    }

    //define iterators and apply error checking for fields
    @Override
    public Iterator<String> getID() {
        return Arrays.asList(String.valueOf(matchId)).iterator();
    }
    @Override
    public Iterator<String> getName() {
        return Arrays.asList("Home: " + homeTeam + " - Away: " + awayTeam).iterator();
    }

    //overrides for iterators defined in SoccerEntity
    //these must be defined here since SoccerEntity is implemented
    @Override
    public Iterator<Team> TeamIterator() {
        return Collections.emptyIterator();
    }

    @Override
    public Iterator<Player> PlayerIterator() {
        return Collections.emptyIterator();
    }

    @Override
    public Iterator<Match> MatchIterator() {
        return Collections.emptyIterator();
    }

}
