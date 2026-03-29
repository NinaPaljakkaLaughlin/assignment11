package com.example.assignment11;
import java.util.*;
//DataProvider creates teams, players, and matches
//serves as hardcoded data for the application
    //implement different methods to retrieve teams, players, and matches
    //use generics to make the utility reusable
public class DataProvider<T> {
    public List<T> getData(Class<T> type) {
        List<T> myData = new ArrayList<>();

        if (type == Team.class) {
            myData.add(type.cast(new Team("FC Barcelona", "Spain", "La Liga")));
            myData.add(type.cast(new Team("Manchester United", "England", "Premier League")));
            myData.add(type.cast(new Team("Bayern Munich", "Germany", "Bundesliga")));
            myData.add(type.cast(new Team("Juventus", "Italy", "Series A")));
            myData.add(type.cast(new Team("Paris Saint-Germain", "France", "Ligue 1")));
            myData.add(type.cast(new Team("Ajax Amsterdam", "Netherlands", "Eredivisie")));
            myData.add(type.cast(new Team("River Plate", "Argentina", "Primera División")));
            myData.add(type.cast(new Team("Flamengo", "Brazil", "Brasileirão")));


        }
        else if (type == Player.class) {
            myData.add(type.cast(new Player("Lionel Messi", "Forward", "FC Barcelona")));
            myData.add(type.cast(new Player("Cristiano Ronaldo", "Forward", "Juventus")));
            myData.add(type.cast(new Player("Robert Lewandowski", "Forward", "Bayern Munich")));
            myData.add(type.cast(new Player("Kevin De Bruyne", "Midfielder", "Manchester City")));
            myData.add(type.cast(new Player("Virgil van Dijk", "Defender", "Liverpool")));
            myData.add(type.cast(new Player("Manuel Neuer", "Goalkeeper", "Bayern Munich")));
            myData.add(type.cast(new Player("Kylian Mbappé", "Forward", "Paris Saint-Germain")));
            myData.add(type.cast(new Player("Erling Haaland", "Forward", "Borussia Dortmund")));
            myData.add(type.cast(new Player("Bruno Fernandes", "Midfielder", "Manchester United")));
            myData.add(type.cast(new Player("Joshua Kimmich", "Midfielder", "Bayern Munich")));
            myData.add(type.cast(new Player("Jan Oblak", "Goalkeeper", "Atletico Madrid")));
            myData.add(type.cast(new Player("Neymar Jr.", "Forward", "Paris Saint-Germain")));



        }
        else if (type == Match.class) {
            myData.add(type.cast(new Match("FC Barcelona", "Real Madrid", "2-1")));
            myData.add(type.cast(new Match("Manchester United", "Liverpool", "0-3")));
            myData.add(type.cast(new Match("Bayern Munich", "Borussia Dortmund", "4-2")));
            myData.add(type.cast(new Match("Juventus", "AC Milan", "1-1")));
            myData.add(type.cast(new Match("Paris Saint-Germain", "Lyon", "3-0")));
            myData.add(type.cast(new Match("FC Barcelona", "Bayern Munich", "0-3")));
            myData.add(type.cast(new Match("Manchester City", "Paris Saint-Germain", "2-1")));
            myData.add(type.cast(new Match("Liverpool", "Ajax Amsterdam", "1-0")));

        }
        return myData;
    }
}
