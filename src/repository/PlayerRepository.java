package repository;

import domain.Player;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PlayerRepository {

    Connection connection;

    public PlayerRepository(Connection Connection) {
        this.connection = Connection;
    }

    /*GET PLAYER DETAILS METHOD*/
    public Object[] getPlayer(String playerName, int yearOfBirth) {
        String GET_PLAYER = "SELECT * FROM Player WHERE playerName = \"" + playerName + "\" AND yearOfBirth = " + yearOfBirth;
        Object[] playerObject = new Object[4];
        try {

            Statement stmt = this.connection.createStatement();
            {
                ResultSet rs = stmt.executeQuery(GET_PLAYER);
                while (rs.next()) {
                    playerObject[0] = rs.getString("playerName");
                    playerObject[1] = rs.getInt("yearOfBirth");
                    playerObject[2] = rs.getInt("gamesCount");
                }
          
            }
        } catch (SQLException e) {
            System.out.println("DB fetch failed!");
            e.printStackTrace();
        }
        return playerObject;
    }

    /*WRITE INPUT TO DB METHOD*/
    public void insertPlayer(Player player)
    {
        String INSERT_PLAYER = "INSERT INTO Player (playerName, yearOfBirth, gamesCount) VALUES (?, ?, ?)";

        try {
            PreparedStatement pstmt = this.connection.prepareStatement(INSERT_PLAYER);
            {
                pstmt.setString(1, player.getPlayerName());
                pstmt.setInt(2, player.getYearOfBirth());
                pstmt.setInt(3, 5);
                pstmt.execute();
                System.out.println("DB write OK!");

            }
        } catch (SQLException e) {
            System.out.println("DB write failed!");
            e.printStackTrace();
        }

    }

}
