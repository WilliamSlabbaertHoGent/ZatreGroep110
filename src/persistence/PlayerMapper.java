package persistence;

import com.mysql.cj.protocol.Resultset;
import domain.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerMapper {
    private static final String GET_PLAYERS = "SELECT * FROM Player";
    private static final String GET_PLAYER = "SELECT * FROM Player WHERE playerName = ? AND yearOfBirth = ?";
    private static final String INSERT_PLAYER = "INSERT INTO Player (playerName, yearOfBirth, gamesCount) VALUES (?, ?, ?)";
    private static final String DECREASE_GAMESCOUNT = "UPDATE Player SET gamescount = gamescount -1 WHERE playerName = ? AND yearOfBirth = ?";
    private static final String INCREASE_GAMESCOUNT = "UPDATE Player SET gamescount = gamescount +2 WHERE playerName = ? AND yearOfBirth = ?";

    public void registerPlayer(Player player) {
        try(
                Connection connection = DriverManager.getConnection(SQLConnection.DATABASE_URL);
                PreparedStatement query = connection.prepareStatement(INSERT_PLAYER)
        ) {
            query.setString(1, player.getPlayerName());
            query.setInt(2, player.getYearOfBirth());
            query.setInt(3, player.getGamesCount());
            query.executeUpdate(); // Use this to execute INSERT, UPDATE and DELETE statements
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();

        try (
                Connection connection = DriverManager.getConnection(SQLConnection.DATABASE_URL);
                PreparedStatement query = connection.prepareStatement(GET_PLAYERS);
                ResultSet results = query.executeQuery();
        )
        {

            while (results.next()) {
                String playerName = results.getString("playerName");
                int yearOfBirth = results.getInt("yearOfBirth");
                int gamesCount = results.getInt("gamesCount");

                players.add(new Player(
                        playerName,
                        yearOfBirth,
                         gamesCount
                ));
            }

        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }

        return players;
    }

    public Player getPlayer(String playerName, int yearOfBirth) {
        Player player = null;

        try(
                Connection connection = DriverManager.getConnection(SQLConnection.DATABASE_URL);
                PreparedStatement query = connection.prepareStatement(GET_PLAYER)
        ) {

            query.setString(1, playerName);
            query.setInt(2, yearOfBirth);
            try(ResultSet result = query.executeQuery()) {
                if (result.next()) {
                    String resultPlayerName = result.getString("playerName");
                    int resultYearOfBirth = result.getInt("yearOfBirth");
                    int gamesCount = result.getInt("gamesCount");

                    player = new Player(
                            resultPlayerName,
                            resultYearOfBirth,
                            gamesCount
                    );
                }
            }

        }catch (SQLException exception) {
            throw new RuntimeException(exception);
        }

        return player;
    }

    /*** UC3 ***/
    public void decreaseGamesCount(Player player) {
        try(
                Connection connection = DriverManager.getConnection(SQLConnection.DATABASE_URL);
                PreparedStatement query = connection.prepareStatement(DECREASE_GAMESCOUNT)
        ) {
            query.setString(1, player.getPlayerName());
            query.setInt(2, player.getYearOfBirth());
            query.executeUpdate();
            }
        catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void increaseGamesCount(Player player) throws SQLException {
        try(
                Connection connection = DriverManager.getConnection(SQLConnection.DATABASE_URL);
                PreparedStatement query = connection.prepareStatement(INCREASE_GAMESCOUNT)
        ) {
            query.setString(1, player.getPlayerName());
            query.setInt(2, player.getYearOfBirth());
            query.executeUpdate();
        }
        catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

}
