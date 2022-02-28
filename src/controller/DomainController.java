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

	public boolean registerPlayer(Player player) {
		if (validatePlayer(player)) {
			this.playerRepository.insertPlayer(player);
		} else {
			return false;
		}
		return true;
	}

	public Object[] getPlayer(String name, int year) {
		return this.playerRepository.getPlayer(name, year);
	}

	public void closeConnection() throws SQLException {
		this.connection.closeConnection();
	}

	public boolean validatePlayer(Player player) {
		var temp = getPlayer(player.getPlayerName(), player.getYearOfBirth());
		if (temp[0] == null) {
			return true;
		}
		return false;
	}

}
