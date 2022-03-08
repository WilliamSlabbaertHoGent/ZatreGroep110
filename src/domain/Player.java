package domain;

import java.time.Year;
import java.util.Calendar;

public class Player {
    String playerName;
    int yearOfBirth;
    int gamesCount;

    /* CLASS CONSTRUCTOR */
    public Player(){
        this.setGamesCount(5);
    }

    public Player(String playerName, int yearOfBirth) {
        this.setPlayerName(playerName);
        this.setYearOfBirth(yearOfBirth);
        this.setGamesCount(5);
    }
    public Player(String playerName, int yearOfBirth, int gamesCount) {
        this.setPlayerName(playerName);
        this.setYearOfBirth(yearOfBirth);
        this.setGamesCount(gamesCount);
    }
    @Override
    public String toString()
    {
        return String.format("%s%s%s%d%s%d"," PlayerName: ",this.playerName," Year of birth: ",this.yearOfBirth,"Games left: ", this.gamesCount);

    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        if (playerName == null || playerName.isEmpty()) {
            throw new IllegalArgumentException("PlayerName is required");
        }

        if (playerName.length() < 5) {
            throw new IllegalArgumentException("PlayerName must be minimum 5 characters long");
        }

        this.playerName = playerName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        int currentYear = Year.now().getValue();

        if (currentYear - yearOfBirth < 6) {
            throw new IllegalArgumentException("You must be 6 years old to register");
        }

        this.yearOfBirth = yearOfBirth;
    }

    public int getGamesCount() {
        return gamesCount;
    }

    public void setGamesCount(int gamesCount) {
        this.gamesCount = gamesCount;
    }

}









