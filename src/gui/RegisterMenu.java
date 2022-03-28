package gui;

import controller.DomainController;
import domain.ConstantInterface;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;


import java.io.IOException;

public class RegisterMenu extends BorderPane {

    private DomainController controller = new DomainController();
    private HomeScreen homeScreen = new HomeScreen();

    public RegisterMenu() throws IOException {
        this.controller = controller;
        this.homeScreen = homeScreen;
    }

    public RegisterMenu(HomeScreen homeScreen, DomainController controller) throws IOException {
        this.homeScreen = homeScreen;
        this.controller = controller;
    }

    public TextField playerNameTXT;
    public TextField yearOfBirthTXT;
    public Alert alert = new Alert(Alert.AlertType.NONE);

    public void registerPlayer() throws IOException {
        String playerName = playerNameTXT.getText();
        // yearOfBirth validation in GUI as controller register method requires int parameter //
        int yearOfBirth = 0;
        if (!((yearOfBirthTXT.getText() == null) || (yearOfBirthTXT.getText().isBlank()) || !(yearOfBirthTXT.getText().matches("\\d*"))))
        {yearOfBirth = Integer.parseInt(yearOfBirthTXT.getText());}
        try {
            controller.registerPlayer(playerName, yearOfBirth);
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setTitle("Success!");
            alert.setHeaderText("Player successfully registered.");
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

    public void returnToMain() throws IOException {
        this.homeScreen.showMainMenu();
        // works to return to main menu - breaks register screen afterwards //
        // Error resolving onAction='#registerPlayer', either the event handler is not in the Namespace or there is an error in the script. //
    }

}
