package controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import connection.SQLConnection;
import domain.Player;
import repository.PlayerRepository;

public class DomainController {

	private PlayerRepository playerRepository;
	private SQLConnection connection;
	private boolean continuePlaying = true;
	private ArrayList<Player> playerList =  new ArrayList<Player>();

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

		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Name is required.");
		}

		if (year == 0) {
			throw new IllegalArgumentException("Year is required");
		}

		Object[] player = this.playerRepository.getPlayer(name, year);

		if (player[0] == null) {
			throw new NoSuchElementException("Player does not exist");
		}

		if ((int) player[2] <= 0) {
			throw new IllegalArgumentException("Player does not have enough games");
		}

		return player;
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
	/*

	 */
	public boolean validateExistingPlayer(Player player)
	{
		var temp = getPlayer(player.getPlayerName(), player.getYearOfBirth());
		if(temp[0] != null && temp[1] != null) {
			//Temp values for validation after checking they exist
			String playerNameTemp = (String)temp[0];
			int yearOfBirthTemp = (int)temp[1];
			LocalDate now = LocalDate.now();
			if (playerNameTemp.length() != 0 && yearOfBirthTemp > now.getYear() - 110 && yearOfBirthTemp <= now.getYear() - 6 ) {
				return true;
			}
			System.out.println("Invalid playername or Year of Birth");
			return false;
		}
		System.out.println("Player does not exist");
		return false;
	}
	public  void displayAllPlayers()
	{
		for (int i = 0; i < playerList.size(); i++)
		{
			Player tempPlayer = playerList.get(i);
			System.out.println(tempPlayer.toString());
		}
	}
	public void selectPlayer()
	{
		String playerName="";
		int yearOfBirth=0;
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please enter the username: ");
		if(userInput.hasNext())
		{
			playerName = userInput.next();
			userInput.nextLine();
		}
		System.out.println("Please enter the year of birth: ");
		if(userInput.hasNextInt())
		{
			yearOfBirth = userInput.nextInt();
			userInput.nextLine();
		}
		Object[] temp = getPlayer(playerName,yearOfBirth);
		if(temp != null)
		{
			Player tempPlayer = new Player((String)temp[0],(int)temp[1],(int)temp[2]);
			if(validateExistingPlayer(tempPlayer)){
				//Second "if" because we need to display a separate message for both cases

				if(playerList.size() < 4 && !playerList.contains(tempPlayer)) {
					playerList.add(tempPlayer);
				}
				else{
					if (playerList.size() < 4 ) {
						System.out.println("The player list is already full, no more players can be added.");
					} else {
						System.out.println("The player has already been selected, please select another.");
					}
				}
			}
			else{System.out.print("Player could not be validated");}
		}


	}
	public void menu()
	{
		int option = 0;
		Scanner menuInput = new Scanner(System.in);
		do {
			System.out.printf("%s%n%s%n%s%n%s%n", "Option 1: Select a player", "Option 2: Start game","Option 3: Display" ,"Option 4: Exit");
			if(menuInput.hasNextInt()) {
				option = menuInput.nextInt();
				menuInput.hasNextLine();
			}
			switch (option) {
				case 1:
					selectPlayer();
					break;
				case 2:
					System.out.println("StartGame method here");
					break;
				case 3:
					displayAllPlayers();
					break;
				case 4:
					this.continuePlaying = false;
					System.out.println("Closing application...");
					break;
				default:
					System.out.println("Invalid selection");
			}
		}while(this.continuePlaying);

	}

}
