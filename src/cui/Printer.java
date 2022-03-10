package cui;

import java.io.PrintStream;
import java.util.List;

public class Printer {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    PrintStream output;

    public Printer(PrintStream output) {
        this.output = output;
    }

    public void printMenu(boolean gameIsFull) {
        if (!gameIsFull) {
            this.output.printf(
                    "Select option: %n" +
                            "0. Quit %n" +
                            "1. Register a player %n" +
                            "2. Select a player %n"
            );
        } else {
            this.output.printf(
                    "Select option: %n" +
                            "0. Quit %n" +
                            "1. Register a player %n"
            );
        }
    }

    public void askPlayerName() {
        this.output.print("Enter your player name: ");
    }

    public void askYearOfBirth() {
        this.output.print("Enter your year of birth: ");
    }

    public void printException(String message) {
        this.output.println(ANSI_RED + message + ANSI_RESET);
    }

    public void printPlayerInfo(List<String> playerInfo) {
        for (String info: playerInfo) {
            this.output.println(ANSI_YELLOW + info + ANSI_RESET);
        }
    }
}
