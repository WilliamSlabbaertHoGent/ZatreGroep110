package cui;

import java.nio.channels.ScatteringByteChannel;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import controller.DomainController;
import domain.Player;
import persistence.PlayerMapper;

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
			printer.printMenu(controller.hasMaxPlayers());
			choice = scanner.nextInt();


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
		} else if (choice == 2){
			if (controller.hasMaxPlayers()) {
				break;
			}

			boolean playerSelected = false;

			/*** START UC2 ***/
			do {
				printer.askPlayerName();
				scanner.nextLine();
				playerName = scanner.nextLine();
				printer.askYearOfBirth();
				yearOfBirth = scanner.nextInt();

				try {
					controller.selectPlayer(playerName, yearOfBirth);
					playerSelected = true;
				} catch (RuntimeException exception) {
					printer.printException(exception.getMessage());
				}
			} while (!playerSelected && !controller.hasMaxPlayers());

			List<List<String>> allSelectedPlayers = controller.getAllSelectedPlayers();
			for (List<String> playerInfo: allSelectedPlayers) {
				printer.printPlayerInfo(playerInfo);
			}
		}
		} while (choice != 0);
	}
}
