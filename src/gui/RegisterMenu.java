package gui;

import controller.DomainController;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import resources.Language;

import java.io.IOException;

import static domain.ConstantInterface.*;

public class RegisterMenu extends BorderPane {

    public TextField playerNameTXT;
    public TextField yearOfBirthTXT;
    public Alert alert = new Alert(Alert.AlertType.NONE);
    private DomainController controller;
    private HomeScreen homeScreen;
    public RegisterMenu() throws IOException {
        this.controller = controller;
        this.homeScreen = homeScreen;
    }
    public RegisterMenu(HomeScreen homeScreen, DomainController controller) throws IOException {
        this.homeScreen = homeScreen;
        this.controller = controller;
    }

    public void registerPlayer() throws IOException {
        String playerName = playerNameTXT.getText();

        int yearOfBirth = 0;
        if (!((yearOfBirthTXT.getText() == null) || (yearOfBirthTXT.getText().isBlank()) || !(yearOfBirthTXT.getText().matches("\\d*")))) {
            yearOfBirth = Integer.parseInt(yearOfBirthTXT.getText());
        }
        try {
            controller.registerPlayer(playerName, yearOfBirth);
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setTitle(
                    Language.getInstance().getResourceBundle(LABEL_RESOURCE).getString("label.success")
            );
            alert.setHeaderText(
                    Language.getInstance().getResourceBundle(LABEL_RESOURCE).getString("label.registerSuccess")
            );
            alert.setContentText(
                    String.format(
                            "%s %s! %s %d",
                            Language.getInstance().getResourceBundle(LABEL_RESOURCE).getString("label.welcome"),
                            playerName,
                            Language.getInstance().getResourceBundle(LABEL_RESOURCE).getString("label.gamesCount"),
                            GAMES_COUNT_START_VALUE
                    )
            );
            alert.showAndWait();
        } catch (RuntimeException exception) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle(
                    Language.getInstance().getResourceBundle(ERROR_RESOURCE).getString("error.invalidInput")
            );
            alert.setHeaderText(exception.getMessage());
            alert.setContentText(exception.getMessage());
            alert.showAndWait();
        } finally {
            playerNameTXT.clear();
            yearOfBirthTXT.clear();
        }
    }

    public void returnToMain() throws IOException {
        this.homeScreen.showMainMenu();
    }

}
