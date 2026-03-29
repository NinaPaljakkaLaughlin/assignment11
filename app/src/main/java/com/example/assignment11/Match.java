package com.example.assignment11;
import java.util.*;
//Match class defines a single match and methods associated:

public abstract class Match implements SoccerEntity {
// set/get homeTeam/awayTeam/score, iterators for name and id

    //attributes
    private static int counter; //track all match ids
    private int matchId; //track this match id
    private String homeTeam;
    private String awayTeam;
    private String score;
    private MatchRepository matchRepository;
    public Match(String homeTeam, String awayTeam, String score) {
        if (homeTeam == null) {
            throw new IllegalArgumentException("Home Team cannot be empty");
        }
        if (awayTeam == null) {
            throw new IllegalArgumentException("Away Team cannot be empty");
        }
        if (score == null) {
            throw new IllegalArgumentException("Score cannot be empty");
        }
        this.matchId = counter++; //always add to the static counter when a new match is created
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.score = score;
        this.matchRepository = new MatchRepository();
    }

    //setters and getters for id, home team, away team, score
    public int getMatchID() {
        return matchId;

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        if (homeTeam == null) {
            throw new IllegalArgumentException("Home team cannot be empty");
        }
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }
    public void setAwayTeam(String awayTeam) {
        if (awayTeam == null) {
            throw new IllegalArgumentException("Away team cannot be empty");
        }
        this.awayTeam = awayTeam;
    }
    public String getScore() {
        return score;
    }
    public void setScore(String score) {
        if (score == null) {
            throw new IllegalArgumentException("Score cannot be empty");
        }
        this.score = score;
    }
    public MatchRepository getMatchRepository() {
        return matchRepository;
    }

    //define iterators and apply error checking for fields
    @Override
    public Iterator<String> getID() {
        return Arrays.asList(String.valueOf(matchId)).iterator();
    }
    @Override
    public Iterator<String> getName() {
        return Arrays.asList(homeTeam).iterator();
    }

    //iterator over all teams
    @Override
    public Iterator<Match> MatchIterator() {
        return matchRepository.getAll().iterator();
    }

}
