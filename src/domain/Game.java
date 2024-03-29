package domain;

import exceptions.PlayerNotFoundException;
import exceptions.PlayerSelectedException;
import resources.Language;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static domain.ConstantInterface.EXCEPTION_RESOURCE;
import static domain.ConstantInterface.MAX_PLAYERS;

public class Game {
    public List<Player> players;
    private GameBord gameBord;
    private GameInventory gameInventory;
    private Player winner;
    private Player activePlayer;
    private boolean firstTurn = true; // TK - TO DETERMINE TILES DRAWN
    private boolean firstStone = true;

    public Game() {
        players = new ArrayList<>();
        gameBord = new GameBord();
        gameInventory = new GameInventory();
    }

    public void addPlayer(Player player) {
        if (this.isValid(player)) {
            this.players.add(player);
        }
    }


    public List<Player> getPlayersShuffle() {
        shufflePlayers(); //Shuffle before handing it over to Gamescreen
        return players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<List<String>> getAllSelectedPlayers() {
        List<List<String>> playerInfo = new ArrayList<>();
        for (Player player : this.players) {
            List<String> singlePlayerInfo = new ArrayList<>();
            singlePlayerInfo.add(player.toString());
            playerInfo.add(singlePlayerInfo);
        }

        return playerInfo;
    }

    private boolean isValid(Player player) {
        if (player == null) {
            throw new PlayerNotFoundException(
                    Language.getInstance().getResourceBundle(EXCEPTION_RESOURCE).getString("exception.playerNotFound")
            );
        }

        // Does not work, every player that comes out of the database gets seen as a new player
//        if (this.players.contains(player)) {
//            throw new PlayerSelectedException(String.format("Player with player name '%s' and year of birth '%d' has already been selected.", player.getPlayerName(), player.getYearOfBirth()));
//        }

        for (Player selectedPlayer : this.players) {
            if (selectedPlayer.getPlayerName().equals(player.getPlayerName()) && selectedPlayer.getYearOfBirth() == player.getYearOfBirth()) {
                throw new PlayerSelectedException(
                        Language.getInstance().getResourceBundle(EXCEPTION_RESOURCE).getString("exception.playerAlreadySelected")
                );
            }
        }

        if (this.hasMaxPlayers()) {
            throw new PlayerSelectedException(
                    Language.getInstance().getString(EXCEPTION_RESOURCE, "exception.tooManyPlayers", MAX_PLAYERS)
            );
        }

        if (!player.hasEnoughGames()) {
            throw new PlayerSelectedException(
                    Language.getInstance().getResourceBundle(EXCEPTION_RESOURCE).getString("exception.notEnoughGames")
            );
        }

        return true;
    }

    public boolean hasMaxPlayers() {
        return this.players.size() == ConstantInterface.MAX_PLAYERS;
    }

    /*** UC3 ***/
    public void shufflePlayers() {
        Collections.shuffle(this.players);
    }

    public void setActivePlayer() {
        activePlayer = players.get(0);
    }

    public void setNextPlayer() {
        if (gameInventory.getTiles().size() == 0) {
            determineWinner();
        }

        var tempList = this.getPlayers();
        var tempPlayer = this.getActivePlayer();

        gameBord.calculateScores();
        getActivePlayer().addScore(gameBord.getAmountTenScoresCurrentRound(), gameBord.getAmountElevenScoresCurrentRound(), gameBord.getAmountTwelveScoresCurrentRound(), gameBord.getAmountDoubleScores());

        var index = 0;

        for (int i = 0; i < tempList.size(); i++)
            if (tempList.get(i).getPlayerName() == tempPlayer.getPlayerName()) {
                index = i;
            }

        if (index == tempList.size() - 1) {
            index = 0;
        } else {
            index++;
        }
        this.setActivePlayer(tempList.get(index));

        if (firstTurn) {
            firstTurn = false;
        }

        gameBord.resetRound();
    }

    public Player getActivePlayer() {
        return this.activePlayer;
    }

    public void setActivePlayer(Player player) {
        activePlayer = player;
    }

    public GameInventory getGameInventory() {
        return this.gameInventory;
    }

    public GameBord getGameBord() {
        return gameBord;
    }

    public Player getWinner() {
        return this.winner;
    }

    public void determineWinner() {
        int highscore = 0;
        for (Player player : players) {
            if (player.getScoreBoard().getTotalScore() > highscore) {
                highscore = player.getScoreBoard().getTotalScore();
                winner = player;
            }
        }
    }

    public void setFieldValue(int row, int column, int value) {
        try {
            gameBord.setFieldValue(row, column, value, firstTurn, firstStone);
            for (Tile tile : gameInventory.getTiles()) {
                if (tile.getValue() == value) {
                    gameInventory.getTiles().remove(tile);
                    break;
                }
            }

            if (firstStone) {
                firstStone = false;
            }
        } catch (RuntimeException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}
