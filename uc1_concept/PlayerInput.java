package zatre_G110_UC1;

import java.time.LocalDate;
import java.util.Scanner;

public class PlayerInput {
	
	public static void main(String[] args) {
		
		Player newPlayer = new Player();
		do {
			/*PROVIDE INPUT - LOOP WHILE NOT VALID*/
			System.out.println("Please enter player information...");
			Scanner nameInput = new Scanner(System.in).useDelimiter("\\R");
			System.out.println("Enter player name:");
			System.out.println("Note: Player name must be alphanumeric and at least 5 characters long!");
				
				/*INPUT PLAYER NAME - LOOP WHILE NOT VALID*/
				while ((!nameInput.hasNext("[a-zA-Z0-9]{5,15}"))) {
				System.out.println("Invalid entry! Please enter a valid name.");
				nameInput.next();
				}
				String playerName = nameInput.next();
					
				/*INPUT YEAR OF BIRTH - LOOP WHILE NOT VALID*/
				Scanner yearInput = new Scanner(System.in).useDelimiter("\\R");
				System.out.println("Enter year of birth (1950-2020):");
				System.out.println("Note:");
		
				LocalDate currentDate = LocalDate.now();
				int currentYear = currentDate.getYear();
				int yearOfBirth;
				int playerAge;
       
				do {
					System.out.println("You must be older than 6 to play this game!");
						while ((!yearInput.hasNext("(19[5-9]\\d|20[0-1]\\d|2020)"))) {
						System.out.println("Invalid entry! Please enter a valid year.");
						yearInput.next();
						}
					yearOfBirth = yearInput.nextInt();
					playerAge = currentYear - yearOfBirth;
					}
				while (playerAge < 6);

			/*SET NEW PLAYER OBJECT ATTRIBUTE VALUES*/
			newPlayer.playerName = playerName;
			newPlayer.yearOfBirth = yearOfBirth;
		
			/*GET PLAYER DETAILS - CHECK IF PLAYER IS UNIQUE*/
			Object playerObject[] = newPlayer.getPlayer(newPlayer.playerName, newPlayer.yearOfBirth);
			if (playerObject[0] == null)
			{
				newPlayer.isValid = true;
				/*PRINT VALIDATION OK*/
				System.out.println("Input OK! Attempting to register the following player:");
				System.out.println("Player name: " + playerName);
				System.out.println("Year of birth: " + yearOfBirth);
			}
			else
			{
			System.out.println("Player already exists! Please try again.");
			}
			
		}
		while (!(newPlayer.isValid));
		
		/*WRITE INPUT TO DB*/
		newPlayer.insertPlayer(newPlayer.playerName, newPlayer.yearOfBirth);
		
		/*GET PLAYER DETAILS - DISPLAY WELCOME MESSAGE*/
		Object playerObject[] = newPlayer.getPlayer(newPlayer.playerName, newPlayer.yearOfBirth);
		System.out.println("Welcome, " + playerObject[1] + "!");
		System.out.println("You have " + playerObject[3] + " games left to play.");
		
		/* OLD CHECK IF UNIQUE */
		
		/*String GET_PLAYER = "SELECT * FROM players WHERE playerName = \"" + newPlayer.playerName + "\" AND yearOfBirth = " + newPlayer.yearOfBirth;
		
		try {
		Connection sqlconn = DriverManager.getConnection(URL, USER, PASS);
		Statement stmt = sqlconn.createStatement();
		{
		ResultSet rs = stmt.executeQuery(GET_PLAYER);
			if (rs.next() == false)
			{
			newPlayer.isValid = true;
			
			System.out.println("Input OK! Attempting to register the following player:");
			System.out.println("Player name: " + playerName);
			System.out.println("Year of birth: " + yearOfBirth);
			}
			else
			{
			System.out.println("Player already exists! Please try again.");
			}
	    sqlconn.close();
		}
		} catch (SQLException e) {
		System.out.println("DB fetch failed!");
		e.printStackTrace();
		}*/
		
		/*nameInput.close();
		yearInput.close();*/
		
		
		/* OLD WRITE TO DB */
		
		/*write player data to DB*/
		/*String INSERT_PLAYER = "INSERT INTO players (playerName, yearOfBirth, gamesCount) VALUES (?, ?, ?)";
		
		try {
			Connection sqlconn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement pstmt = sqlconn.prepareStatement(INSERT_PLAYER);
			{
			pstmt.setString(1, newPlayer.playerName);
			pstmt.setInt(2, newPlayer.yearOfBirth);
			pstmt.setInt(3, newPlayer.gamesCount);
		    pstmt.execute();
		    System.out.println("DB write OK!");
		    sqlconn.close();
			}
		} catch (SQLException e) {
			System.out.println("DB write failed!");
			e.printStackTrace();
		}*/
		
		
		/* OLD FETCH */
		
		/*fetch player data from DB - welcome message*/
		/*String GET_PLAYER = "SELECT * FROM players WHERE playerName = \"" + newPlayer.playerName + "\" AND yearOfBirth = " + newPlayer.yearOfBirth;
		
		try {
			Connection sqlconn = DriverManager.getConnection(URL, USER, PASS);
			Statement stmt = sqlconn.createStatement();
			{
			ResultSet rs = stmt.executeQuery(GET_PLAYER);
				while (rs.next()) {
				System.out.println("Welcome, " + rs.getString("playerName") + "!");
				System.out.println("You have " + rs.getInt("gamesCount") + " games left to play.");
				}
		    sqlconn.close();
			}
		} catch (SQLException e) {
			System.out.println("DB fetch failed!");
			e.printStackTrace();
		}*/
		
		
		/* OLD VALIDATION */
		
		/*System.out.println(newPlayer.playerID);
		System.out.println(newPlayer.playerName);
		System.out.println(newPlayer.yearOfBirth);
		System.out.println(newPlayer.gamesCount);*/

		/*validate*/
        /*int playerAge = currentYear - yearOfBirth;*/
        
        
        /*String yearString = Integer.toString(yearOfBirth);
        
		if ((playerName.isEmpty()) || ((yearString.isEmpty())))
		{
			System.out.println("Empty values are not allowed!");
			System.out.println(newPlayer.isValid);
		}
		
		else if ((newPlayer.playerName.length() > 5) || (playerAge < 6))
		{
			System.out.println("Please take player restrictions into account!");
			System.out.println(newPlayer.isValid);
		}
		
		else
		{
			System.out.println("Input OK! Proceeding to register player: " + playerName);
			newPlayer.isValid = true;
		}
		
		nameInput.close();
		yearInput.close();*/
        
		

	}

}
