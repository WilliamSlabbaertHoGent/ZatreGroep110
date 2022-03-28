package domain;

import exceptions.PlayerNotFoundException;
import exceptions.PlayerSelectedException;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private GameBord gameBord;
    private Stone totalStones;
    private List<Turn> turns;
    private Player winner;

    public Game() {
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.isValid(player)) {
            this.players.add(player);
        }
    }


    public List<List<String>> getAllSelectedPlayers() {
        List<List<String>> playerInfo = new ArrayList<>();
        for (Player player: this.players) {
            List<String> singlePlayerInfo = new ArrayList<>();
            singlePlayerInfo.add(player.toString());
            playerInfo.add(singlePlayerInfo);
        }

        return playerInfo;
    }

    private boolean isValid(Player player) {
        if (player == null) {
            throw new PlayerNotFoundException("Player was not found.");
        }

        // Does not work, every player that comes out of the database gets seen as a new player
//        if (this.players.contains(player)) {
//            throw new PlayerSelectedException(String.format("Player with player name '%s' and year of birth '%d' has already been selected.", player.getPlayerName(), player.getYearOfBirth()));
//        }

        for (Player selectedPlayer: this.players) {
            if (selectedPlayer.getPlayerName().equals(player.getPlayerName()) && selectedPlayer.getYearOfBirth() == player.getYearOfBirth()) {
                throw new PlayerSelectedException(String.format("Player with player name '%s' and year of birth '%d' has already been selected.", player.getPlayerName(), player.getYearOfBirth()));
            }
        }

        if (this.hasMaxPlayers()) {
            throw new PlayerSelectedException("Four players have already been selected.");
        }

        if (!player.hasEnoughGames()) {
            throw new PlayerSelectedException("Player does not have enough games.");
        }

        return true;
    }

    public boolean hasMaxPlayers() {
        return this.players.size() == ConstantInterface.MAX_PLAYERS;
    }
}
