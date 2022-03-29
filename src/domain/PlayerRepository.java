package domain;

import exceptions.PlayerExistsException;
import persistence.PlayerMapper;
import resources.Language;
import static domain.ConstantInterface.*;

public class PlayerRepository {
    private final PlayerMapper playerMapper;

    public PlayerRepository() {
        this.playerMapper = new PlayerMapper();
    }

    /*** UC1 ***/
    public void registerPlayer(Player player) {
        if (this.playerExists(player.getPlayerName(), player.getYearOfBirth())) {
            Language.getInstance().getResourceBundle(EXCEPTION_RESOURCE).getString("exception.playerExists");
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
