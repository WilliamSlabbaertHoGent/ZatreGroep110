package controller;

import java.util.ArrayList;
import java.util.List;

import domain.Game;
import domain.Player;
import domain.PlayerRepository;
import exceptions.NoRegisteredPlayerException;

public class DomainController {
    private Player player;
    private final PlayerRepository playerRepository;
    private final Game game;

    public DomainController() {
        this.playerRepository = new PlayerRepository();
        this.game = new Game();
    }

    /*** UC1 ***/
    public void registerPlayer(String playerName, int gamesCount) {
        this.player = new Player(playerName, gamesCount);
        this.playerRepository.registerPlayer(player);
    }

    public boolean playerIsRegistered()
    {
        return this.player != null;
    }
    public List<String> showRegisteredPlayer() {
        if (this.player == null) {
            throw new NoRegisteredPlayerException("No player has been registered");
        }

        List<String> playerInfo = new ArrayList<>();
        playerInfo.add(
                String.format("Player name: %s", this.player.getPlayerName())
        );
        playerInfo.add(
                String.format("Games left: %d", this.player.getGamesCount())
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
        return this.game.getAllSelectedPlayers();
    }

    public boolean hasMaxPlayers() {
        return game.hasMaxPlayers();
    }
}
