package controller;

import java.util.ArrayList;
import java.util.List;
import domain.Player;
import domain.PlayerRepository;
import exceptions.NoRegisteredPlayerException;

public class DomainController {
    Player player;
    PlayerRepository playerRepository;

    public DomainController() {
        this.player = null;
        this.playerRepository = new PlayerRepository();
    }

    /*** UC1 ***/
    public void registerPlayer(String playerName, int gamesCount) {
        this.playerRepository.registerPlayer(playerName, gamesCount);
        this.player = new Player(playerName, gamesCount);
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
}
