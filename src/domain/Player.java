package domain;

public class Player {
    String playerName;
    int yearOfBirth;
    int gamesCount;

    /* CLASS CONSTRUCTOR */
    public Player(String playerName, int yearOfBirth) {
        this.setPlayerName(playerName);
        this.setYearOfBirth(yearOfBirth);
        this.setGamesCount(5);
    }
    public Player(String playerName, int yearOfBirth, int gamesCount) {
        this.setPlayerName(playerName);
        this.setYearOfBirth(yearOfBirth);
        this.setGamesCount(5);
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
        this.playerName = playerName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getGamesCount() {
        return gamesCount;
    }

    public void setGamesCount(int gamesCount) {
        this.gamesCount = gamesCount;
    }

}









