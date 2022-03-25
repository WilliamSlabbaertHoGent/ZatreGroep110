package gui;

import controller.DomainController;
import domain.ConstantInterface;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class RegisterMenu extends BorderPane {

    private DomainController controller;
    private HomeScreen homeScreen;

    public RegisterMenu() {
        this.controller = new DomainController();
    }

    public RegisterMenu(HomeScreen homeScreen, DomainController controller) {
        this.homeScreen = homeScreen;
        this.controller = controller;
    }

    public TextField playerNameTXT;
    public TextField yearOfBirthTXT;

    public Alert alert = new Alert(Alert.AlertType.NONE);

    public void Register() throws IOException {
        String playerName = playerNameTXT.getText();
        int yearOfBirth = 0;
        if (!((yearOfBirthTXT.getText() == null) || (yearOfBirthTXT.getText().isBlank()) || !(yearOfBirthTXT.getText().matches("\\d*"))))
        {yearOfBirth = Integer.parseInt(yearOfBirthTXT.getText());}
        try {
            controller.registerPlayer(playerName, yearOfBirth);
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setTitle("Success!");
            alert.setHeaderText("Player successfully registered!");
            alert.setContentText("Welcome, " + playerName + "!" + "\r\n" + "Games left: " + ConstantInterface.GAMES_COUNT_START_VALUE);
            alert.showAndWait();
        } catch (RuntimeException exception) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Invalid input!");
            alert.setHeaderText(exception.getMessage());
            alert.setContentText(exception.getMessage());
            alert.showAndWait();
        }
        finally {
            playerNameTXT.clear();
            yearOfBirthTXT.clear();
        }
    }

    public void Return() throws IOException {
        this.homeScreen.showMainMenu();
        // does not work yet //
    }

}
