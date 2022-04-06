package domain;

import resources.Language;

import java.time.Year;
import java.util.List;

import static domain.ConstantInterface.*;

public class Player {
    /*** UC1 ***/
    private String playerName;
    private int yearOfBirth;
    private int gamesCount;
    private List<Stone> stoneInventory;

    /* CLASS CONSTRUCTOR */
    public Player(String playerName, int yearOfBirth) {
        this(playerName, yearOfBirth, GAMES_COUNT_START_VALUE);
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
        if (playerName == null || playerName.isBlank()) {
            throw new IllegalArgumentException(
                    Language.getInstance().getResourceBundle(EXCEPTION_RESOURCE).getString("exception.playerNameRequired")
            );
        }

        if (!playerName.matches("[a-zA-Z0-9]{1,15}"))
        {
            throw new IllegalArgumentException(
                    Language.getInstance().getResourceBundle(EXCEPTION_RESOURCE).getString("exception.numericOnly")
            );
        }

        if (playerName.length() < 5) {
            throw new IllegalArgumentException(
                    Language.getInstance().getResourceBundle(EXCEPTION_RESOURCE).getString("exception.playerNameTooShort")
            );
        }

        this.playerName = playerName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    private void setYearOfBirth(int yearOfBirth) {
        int currentYear = Year.now().getValue();

        if (yearOfBirth == 0) {
            throw new IllegalArgumentException(
                    Language.getInstance().getResourceBundle(EXCEPTION_RESOURCE).getString("exception.yearOfBirthRequired")
            );
        }

        if (!String.valueOf(yearOfBirth).matches("(19[5-9]\\d|20[0-1]\\d|2020)")) {
            throw new IllegalArgumentException(
                    Language.getInstance().getResourceBundle(EXCEPTION_RESOURCE).getString("exception.invalidYearOfBirth")
            );
        }

        if (currentYear - yearOfBirth < MIN_AGE) {
            throw new IllegalArgumentException(
                    Language.getInstance().getResourceBundle(EXCEPTION_RESOURCE).getString("exception.tooYoung")
            );
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
                "%s: %s (%s:%d, %s:%d)",
                Language.getInstance().getResourceBundle(LABEL_RESOURCE).getString("label.playerName"),
                this.getPlayerName(),
                Language.getInstance().getResourceBundle(LABEL_RESOURCE).getString("label.yearOfBirth"),
                this.getYearOfBirth(),
                Language.getInstance().getResourceBundle(LABEL_RESOURCE).getString("label.gamesCount"),
                this.getGamesCount()
        );
    }
}









