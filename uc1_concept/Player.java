package zatre_G110_UC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Player {
	int playerID;
	String playerName;
	int yearOfBirth;
	int gamesCount;
	boolean isValid;
	
	/*CLASS CONSTRUCTOR*/
	public Player() {
	playerName = null;
	yearOfBirth = 0;
	playerID = 1;
	gamesCount = 5;
	isValid = false;
	}
	
	/*DATABASE CONNECTION PARAMETERS*/
	static final String URL = "jdbc:mysql://localhost/ZATRE_G110";
	static final String USER = "mysqladmin";
	static final String PASS = "P@ssw0rd";
	
	/*GET PLAYER DETAILS METHOD*/
	public Object[] getPlayer(String playerName, int yearOfBirth) {
		String GET_PLAYER = "SELECT * FROM players WHERE playerName = \"" + playerName + "\" AND yearOfBirth = " + yearOfBirth;
		Object[] playerObject = new Object[4];
		try {
			Connection sqlconn = DriverManager.getConnection(URL, USER, PASS);
			Statement stmt = sqlconn.createStatement();
			{
			ResultSet rs = stmt.executeQuery(GET_PLAYER);
				while (rs.next()) {
				playerObject[0] = rs.getInt("playerID");
				playerObject[1] = rs.getString("playerName");
				playerObject[2] = rs.getInt("yearOfBirth");
				playerObject[3] = rs.getInt("gamesCount");
				}
		    sqlconn.close();
			}
		} catch (SQLException e) {
			System.out.println("DB fetch failed!");
			e.printStackTrace();
		}
		return playerObject;
	}
	
	/*WRITE INPUT TO DB METHOD*/
	public void insertPlayer(String playerName, int yearOfBirth)
	{
		String INSERT_PLAYER = "INSERT INTO players (playerName, yearOfBirth) VALUES (?, ?)";
		
		try {
			Connection sqlconn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement pstmt = sqlconn.prepareStatement(INSERT_PLAYER);
			{
			pstmt.setString(1, playerName);
			pstmt.setInt(2, yearOfBirth);
		    pstmt.execute();
		    System.out.println("DB write OK!");
		    sqlconn.close();
			}
		} catch (SQLException e) {
			System.out.println("DB write failed!");
			e.printStackTrace();
		}
		
	}

}
