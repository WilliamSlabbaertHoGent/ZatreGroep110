package controller;

import java.sql.SQLException;

import connection.SQLConnection;
import domain.Player;
import repository.PlayerRepository;

public class DomainController {

    private PlayerRepository playerRepository;
    private SQLConnection connection;

    public DomainController() throws SQLException {
        this.connection = new SQLConnection();
        this.playerRepository = new PlayerRepository(this.connection.connect());

    }

    public void registerPlayer(Player player)
    {
        this.playerRepository.insertPlayer(player);
    }
    public Object[] getPlayer(String name, int year){
        return this.playerRepository.getPlayer(name,year);
    }


}
