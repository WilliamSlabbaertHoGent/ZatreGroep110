package domain;

import exceptions.PlayerExistsException;
import persistence.PlayerMapper;

public class PlayerRepository {
    private final PlayerMapper playerMapper;

    public PlayerRepository() {
        this.playerMapper = new PlayerMapper();
    }

    /*** UC1 ***/
    public void registerPlayer(Player player) {
        if (this.playerExists(player.getPlayerName(), player.getYearOfBirth())) {
            throw new PlayerExistsException(String.format(
                    "A player with player name '%s' and year of birth '%d' already exists",
                    player.getPlayerName(),
                    player.getYearOfBirth()
            ));
        }

        this.playerMapper.registerPlayer(player);
    }

    private boolean playerExists(String playerName, int yearOfBirth) {
        return this.playerMapper.getPlayer(playerName, yearOfBirth) != null;
    }

    /*** UC2 ***/
    public Player getPlayer(String playerName, int yearOfBirth) {
        return this.playerMapper.getPlayer(playerName, yearOfBirth);
    }

}
