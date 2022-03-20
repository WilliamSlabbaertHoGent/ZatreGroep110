package cui;

import controller.DomainController;

import java.util.List;
import java.util.Scanner;

public class ZatreApplicatie {
    private DomainController domainController;

    public ZatreApplicatie(DomainController domainController) {
        this.domainController = domainController;
    }

    public void start() {
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
                        printer.printPlayerInfo(controller.showRegisteredPlayer());
                    } catch (RuntimeException exception) {
                        printer.printException(exception.getMessage());
                    }
                } while (!controller.playerIsRegistered());


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
