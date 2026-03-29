package com.example.assignment11;
import java.util.*;
//Player class defines a single player and methods associated:
    // set/get name/position/team, iterators for name and id
public class Player implements SoccerEntity {
    private static int counter = 1; //static counter for all player IDs
    private int id; //track this player id
    private String name;
    private String position;
    private String team;

    //constructor
    public Player(String name, String position, String team) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (position == null || position.isBlank()) {
            throw new IllegalArgumentException("Position cannot be empty");
        }
        if (team == null || team.isBlank()) {
            throw new IllegalArgumentException("Team cannot be empty");
        }
        this.id = counter++; //always add to the static counter when a new player is created
        this.name = name;
        this.position = position;
        this.team = team;
    }
        //setters and getters for id, name, position, team
        public int getPlayerID() {return id;}
        public String getPlayerName() {return name;}
        public void setName(String name) {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Name cannot be empty");
            }
            this.name = name;
        }
        public String getPosition() {return position;}
        public void setPosition(String position) {
            if (position == null || position.isBlank()) {
                throw new IllegalArgumentException("Country cannot be empty");
            }
            this.position = position;
        }
        public String getTeam() {return team;}
        public void setTeam(String team) {
            if (team == null || team.isBlank()) {
                throw new IllegalArgumentException("League cannot be empty");
            }
            this.team = team;
        }

        //define iterators and apply error checking for fields
        @Override
        public Iterator<String> getID() {
            return Arrays.asList(String.valueOf(id)).iterator();
        }
        @Override
        public Iterator<String> getName() {
            return Arrays.asList(name).iterator();
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
