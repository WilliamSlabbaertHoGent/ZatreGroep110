package cui;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import controller.DomainController;
import domain.Player;

public class Startup {

    public static void main(String[] args) throws SQLException {
        // TODO Auto-generated method stub
        DomainController controller = new DomainController();

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


        Player player = new Player(playerName, yearOfBirth);
        controller.registerPlayer(player);

        System.out.println("Welcome, " + player.getPlayerName() + "!");
        System.out.println("You have " + player.getGamesCount() + " games left to play.");

    }

}
