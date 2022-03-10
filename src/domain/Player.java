package domain;

import java.time.Year;
import java.util.Calendar;

public class Player {
    /*** UC1 ***/
    String playerName;
    int yearOfBirth;
    int gamesCount;

    /* CLASS CONSTRUCTOR */
    public Player(String playerName, int yearOfBirth) {
        this.setPlayerName(playerName);
        this.setYearOfBirth(yearOfBirth);
        this.setGamesCount(ConstantInterface.GAMES_COUNT_START_VALUE);
    }

    public String getPlayerName() {
        return playerName;
    }

    private void setPlayerName(String playerName) {
        if (playerName == null || playerName.isEmpty()) {
            throw new IllegalArgumentException("PlayerName is required");
        }

        if (playerName.length() < 5) {
            throw new IllegalArgumentException(String.format("Your player name must be longer than %d characters long", ConstantInterface.MIN_PLAYER_NAME_CHARACTERS));
        }

        this.playerName = playerName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    private void setYearOfBirth(int yearOfBirth) {
        int currentYear = Year.now().getValue();

        if (currentYear - yearOfBirth < ConstantInterface.MIN_AGE) {
            throw new IllegalArgumentException(String.format("You must be older than %d years old to register.", ConstantInterface.MIN_AGE));
        }

        this.yearOfBirth = yearOfBirth;
    }

    public int getGamesCount() {
        return gamesCount;
    }

    private void setGamesCount(int gamesCount) {
        this.gamesCount = gamesCount;
    }

    /*** UC2 ***/
    public boolean hasEnoughGames() {
        return this.gamesCount > 0;
    }
}









