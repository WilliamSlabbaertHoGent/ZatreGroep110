package cui;

import java.nio.channels.ScatteringByteChannel;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import controller.DomainController;
import domain.Player;

public class Startup {
	public static void main(String[] args) {

		/*** START UC1 ***/
		Scanner scanner = new Scanner(System.in);
		DomainController controller = new DomainController();
		Printer printer = new Printer(System.out);
		int choice;
		String playerName;
		int yearOfBirth;

		do {
			printer.printMenu();
			choice = scanner.nextInt();
		} while (choice < 1 || choice > 2);

		if (choice == 1) {
			do {
				printer.askPlayerName();
				scanner.nextLine();
				playerName = scanner.nextLine();
				printer.askYearOfBirth();
				yearOfBirth = scanner.nextInt();

				try {
					controller.registerPlayer(playerName, yearOfBirth);
				} catch (RuntimeException exception) {
					printer.printException(exception.getMessage());
				}
			} while (!controller.playerIsRegistered());

			printer.printPlayerInfo(controller.showRegisteredPlayer());

		/*** END UC1 ***/
		} else {
			/*** START UC2 ***/
		}
	}
}
