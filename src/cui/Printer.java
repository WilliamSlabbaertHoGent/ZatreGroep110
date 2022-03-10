package cui;

import java.io.PrintStream;
import java.util.List;

public class Printer {
    PrintStream output;

    public Printer(PrintStream output) {
        this.output = output;
    }

    public void printMenu() {
        this.output.printf(
                "Select option: %n" +
                "1. Register a player %n" +
                "2. Select a player %n"
        );
    }

    public void askPlayerName() {
        this.output.print("Enter your player name: ");
    }

    public void askYearOfBirth() {
        this.output.print("Enter your year of birth: ");
    }

    public void printException(String message) {
        this.output.println(message);
    }

    public void printPlayerInfo(List<String> playerInfo) {
        for (String info: playerInfo) {
            this.output.println(info);
        }
    }
}
