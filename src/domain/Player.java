package domain;

import java.time.Year;
import java.util.List;

public class Player {
    /*** UC1 ***/
    private String playerName;
    private int yearOfBirth;
    private int gamesCount;
    private List<Stone> stoneInventory;

    /* CLASS CONSTRUCTOR */
    public Player(String playerName, int yearOfBirth) {
        this.setPlayerName(playerName);
        this.setYearOfBirth(yearOfBirth);
        this.setGamesCount(ConstantInterface.GAMES_COUNT_START_VALUE);
    }

    public Player(String playerName, int yearOfBirth, int gamesCount) {
        this.setPlayerName(playerName);
        this.setYearOfBirth(yearOfBirth);
        this.setGamesCount(gamesCount);
    }

    public String getPlayerName() {
        return playerName;
    }

    private void setPlayerName(String playerName) {
        if (playerName == null || playerName.isEmpty()) {
            throw new IllegalArgumentException("Player name is required.");
        }

        if (playerName.length() < 5) {
            throw new IllegalArgumentException(String.format("Player name must be longer than %d characters long.", ConstantInterface.MIN_PLAYER_NAME_CHARACTERS));
        }

        if (!playerName.matches("[a-zA-Z0-9]{5,15}"))
        {
            throw new IllegalArgumentException("Player name must contain alphanumeric characters only.");
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

        if (!String.valueOf(yearOfBirth).matches("(19[5-9]\\d|20[0-1]\\d|2020)")) {
            throw new IllegalArgumentException("Please enter a value between 1950 and 2020.");
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

    @Override
    public String toString() {
        return String.format(
                "Player { %n" +
                "playerName: %s %n" +
                "YearOfBirth: %d %n" +
                "gamesCount: %d %n }",
                this.getPlayerName(),
                this.getYearOfBirth(),
                this.getGamesCount()
        );
    }
}









