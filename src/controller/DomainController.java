package controller;

import domain.Game;
import domain.Player;
import domain.PlayerRepository;
import domain.Tile;
import exceptions.NoRegisteredPlayerException;
import resources.Language;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static domain.ConstantInterface.EXCEPTION_RESOURCE;
import static domain.ConstantInterface.LABEL_RESOURCE;

public class DomainController {
    private final PlayerRepository playerRepository;
    private Player player;
    private Game game;

    public DomainController() {

        this.playerRepository = new PlayerRepository();
        this.game = new Game();
    }

    /*** UC1 ***/
    public void registerPlayer(String playerName, int yearOfBirth) {
        this.player = new Player(playerName, yearOfBirth);
        this.playerRepository.registerPlayer(player);
    }

    public boolean playerIsRegistered() {
        return this.player != null;
    }

    public List<String> showRegisteredPlayer() {
        if (!this.playerIsRegistered()) {
            throw new NoRegisteredPlayerException(
                    Language.getInstance().getResourceBundle(EXCEPTION_RESOURCE).getString("exception.noPlayerHasBeenRegistered")
            );
        }

        List<String> playerInfo = new ArrayList<>();
        playerInfo.add(
                String.format(
                        "%s: %s",
                        Language.getInstance().getResourceBundle(LABEL_RESOURCE).getString("label.playerName"),
                        this.player.getPlayerName()
                )
        );
        playerInfo.add(
                String.format(
                        "%s: %d",
                        Language.getInstance().getResourceBundle(LABEL_RESOURCE).getString("label.gamesCount"),
                        this.player.getGamesCount()
                )
        );

        return playerInfo;
    }

    /*** UC2 ***/
    public void selectPlayer(String playerName, int yearOfBirth) {
        if (playerName == null || playerName.isBlank()) {
            throw new IllegalArgumentException("Player name is required");
        }
        this.game.addPlayer(this.playerRepository.getPlayer(playerName, yearOfBirth));
    }

    public List<List<String>> getAllSelectedPlayers() {
        // this.shufflePlayers(); TK: TEST SHUFFLE METHOD//
        return this.game.getAllSelectedPlayers();
    }

    public boolean hasMaxPlayers() {
        return game.hasMaxPlayers();
    }

    /*** UC3 ***/
    public void decreaseGamesCountForPlayers() {
        for (Player player : game.getPlayers()) {
            this.playerRepository.decreaseGamesCount(player);
        }
    }

    public void increaseGamesCount(Player player) throws SQLException {
        this.playerRepository.increaseGamesCount(player);
    }

    public void shufflePlayers() {
        this.game.shufflePlayers();
    }

    public void setActivePlayer() {
        this.game.setActivePlayer();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void startNewGame() {
        game = new Game();
    }


    public void setupGame() {
        decreaseGamesCountForPlayers();
        shufflePlayers();
        setActivePlayer();
    }

    public List<Tile> RandomTilesShuffle(List<Tile> playerInventory, int amount) {
        List<Tile> list = this.getGame().getGameInventory().getTiles();
        list.addAll(playerInventory);
        playerInventory = new ArrayList<Tile>() {
        };
        Random random = new Random();
        for (int i = 0; i < amount; i++) {
            int int_random = random.nextInt(list.size() - 1);
            playerInventory.add(list.get(int_random));
            list.remove(list.get(int_random));
        }
        return playerInventory;
    }


    /**
     * UC4
     **/
    public void setFieldValue(int row, int column, int value) {
        game.setFieldValue(row, column, value);
    }
}
