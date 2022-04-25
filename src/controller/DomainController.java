package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Game;
import domain.Player;
import domain.PlayerRepository;
import exceptions.NoRegisteredPlayerException;
import resources.Language;
import static domain.ConstantInterface.*;

public class DomainController {
    private Player player;
    private final PlayerRepository playerRepository;
    private Game game;

    public DomainController() {
        this.playerRepository = new PlayerRepository();
    }
    public void setGame(Game game){
        this.game = game;
    }

    /*** UC1 ***/
    public void registerPlayer(String playerName, int yearOfBirth) {
        this.player = new Player(playerName, yearOfBirth);
        this.playerRepository.registerPlayer(player);
    }

    public boolean playerIsRegistered()
    {
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
        for (Player player: game.getPlayers()) {
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
}
