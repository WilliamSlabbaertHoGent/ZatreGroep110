package gui;

import controller.DomainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

import java.util.List;

public class SelectionMenu extends BorderPane {

    private DomainController controller;
    private HomeScreen homeScreen;

    public SelectionMenu() {
        this.controller = controller;
        this.homeScreen = homeScreen;
    }

    public SelectionMenu(HomeScreen homeScreen, DomainController controller) throws IOException {
        this.homeScreen = homeScreen;
        this.controller = controller;
    }

    public TextField playerNameTXT;
    public TextField yearOfBirthTXT;
    public ListView playerListView;
    public Alert alert = new Alert(Alert.AlertType.NONE);

    public void selectPlayer() {
        String playerName = playerNameTXT.getText();
        int yearOfBirth = Integer.parseInt(yearOfBirthTXT.getText());
        try {
            controller.selectPlayer(playerName, yearOfBirth);
            ObservableList<List> playerListItems = FXCollections.observableArrayList(controller.getAllSelectedPlayers());
            playerListView.setItems(playerListItems);
        }
        catch (RuntimeException exception)
        {
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

    public void confirmSelection()
    {
        // START GAME METHOD OR DIALOG BOX //
    }

    public void Return() throws IOException {
        this.homeScreen.showMainMenu();
        // does not work yet //
    }

}
