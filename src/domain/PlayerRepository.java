package domain;

import exceptions.PlayerExistsException;
import persistence.PlayerMapper;
import resources.Language;

import java.sql.SQLException;

import static domain.ConstantInterface.*;

public class PlayerRepository {
    private final PlayerMapper playerMapper;

    public PlayerRepository() {
        this.playerMapper = new PlayerMapper();
    }

    /*** UC1 ***/
    public void registerPlayer(Player player) {
        if (this.playerExists(player.getPlayerName(), player.getYearOfBirth())) {
            throw new PlayerExistsException(
                    Language.getInstance().getResourceBundle(EXCEPTION_RESOURCE).getString("exception.playerExists")
            );
        }

        this.playerMapper.registerPlayer(player);
        /*TK: TEST DECREASE GAMESCOUNT METHOD
        try {
            this.playerMapper.decreaseGamesCount(player);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    private boolean playerExists(String playerName, int yearOfBirth) {
        return this.playerMapper.getPlayer(playerName, yearOfBirth) != null;
    }

    /*** UC2 ***/
    public Player getPlayer(String playerName, int yearOfBirth) {
        return this.playerMapper.getPlayer(playerName, yearOfBirth);
    }

    /*** UC3 ***/
    public void decreaseGamesCount(Player player) {
        this.playerMapper.decreaseGamesCount(player);
    }

    public void increaseGamesCount(Player player) throws SQLException {
        this.playerMapper.increaseGamesCount(player);
    }

}
