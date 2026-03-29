package com.example.assignment11;

import java.util.*;

//Team class defines a single team and methods associated:
    // set/get name/country/league, iterators for name and id
public abstract class Team implements SoccerEntity {
    //attributes
    private static int counter = 1; //track all team ids
    private int teamId; //track this team id
    private String name;
    private String country;
    private String league;
    public Team(String name, String country, String league) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (country == null || country.isBlank()) {
            throw new IllegalArgumentException("Country cannot be empty");
        }
        if (league == null || league.isBlank()) {
            throw new IllegalArgumentException("League cannot be empty");
        }
        this.teamId = counter++; //always add to the static counter when a new team is created
        this.name = name;
        this.country = country;
        this.league = league;
    }

    //setters and getters for name, country, league
    public int getTeamID() {return teamId;}
    public String getTeamName() {return name;}
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }
    public String getCountry() {return country;}
    public void setCountry(String country) {
        if (country == null || country.isBlank()) {
            throw new IllegalArgumentException("Country cannot be empty");
        }
        this.country = country;
    }
    public String getLeague() {return league;}
    public void setLeague(String league) {
        if (league == null || league.isBlank()) {
            throw new IllegalArgumentException("League cannot be empty");
        }
        this.league = league;
    }

    //define iterators and apply error checking for fields
    @Override
    public Iterator<String> getID() {return Arrays.asList(String.valueOf(teamId)).iterator();}
    @Override
    public Iterator<String> getName() {return Arrays.asList(name).iterator();}

}
