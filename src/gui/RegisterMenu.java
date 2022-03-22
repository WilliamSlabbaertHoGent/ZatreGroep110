package gui;

import controller.DomainController;
import domain.ConstantInterface;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class RegisterMenu extends BorderPane {

    // TO DO: pass player registration exceptions in domain controller to gui//
    private DomainController controller;
    private HomeScreen homeScreen;
    public RegisterMenu() throws IOException {
        this.controller = new DomainController();
        this.homeScreen = new HomeScreen();
    }

    public TextField playerNameTXT;
    public TextField yearOfBirthTXT;
    public Alert alert = new Alert(Alert.AlertType.NONE);

    // TO DO: move validation below to domain controller //
    public void Register() throws IOException {
        String playerName = playerNameTXT.getText();
        int yearOfBirth = Integer.parseInt(yearOfBirthTXT.getText());
        if (!(playerName.matches("[a-zA-Z0-9]{5,15}"))) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Invalid player name");
            alert.setHeaderText("Invalid player name");
            alert.setContentText("Please provide a valid player name...");
            alert.showAndWait();
        }
        else if (!(yearOfBirthTXT.getText().matches("(19[5-9]\\d|20[0-1]\\d|2020)"))) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Invalid year of birth");
            alert.setHeaderText("Invalid year of birth");
            alert.setContentText("Please provide a valid year of birth...");
            alert.showAndWait();
        }
        else {
            controller.registerPlayer(playerName, yearOfBirth);
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setTitle("Registration successful!");
            alert.setHeaderText("Registration successful!");
            alert.setContentText(("Welcome, " + this.playerNameTXT.getText() + "!" + "\r\n" + "Games Left: " + ConstantInterface.GAMES_COUNT_START_VALUE));
            alert.showAndWait();

            playerNameTXT.clear();
            yearOfBirthTXT.clear();
        }
    }

    public void Return() throws IOException {
        this.homeScreen.showMainMenu();
        // does not work yet //
    }

}
