package domain;

public class Player {
    int playerID;
    String playerName;
    int yearOfBirth;
    int gamesCount;

    /* CLASS CONSTRUCTOR */
    public Player(String playerName, int yearOfBirth) {
        this.setPlayerName(playerName);
        this.setYearOfBirth(yearOfBirth);
        playerID = 1;
        this.setGamesCount(5);
    }
    public Player(int playerID,String playerName, int yearOfBirth, int gamesCount) {
        this.setPlayerName(playerName);
        this.setYearOfBirth(yearOfBirth);
        this.playerID = playerID;
        this.setGamesCount(gamesCount);
    }
    @Override
    public String toString()
    {
        return String.format("%s%d%s%s%s%d%s%d","PlayerID: ",this.playerID," PlayerName: ",this.playerName,"Year of birth: ",this.yearOfBirth,"Games left: ", this.gamesCount);

    }
    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
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









