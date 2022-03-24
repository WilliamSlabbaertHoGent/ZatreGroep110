package gui;

import controller.DomainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

import java.util.List;

public class SelectionMenu extends BorderPane {

    private DomainController controller;
    private HomeScreen homeScreen;

    public SelectionMenu(DomainController controller, HomeScreen homeScreen) throws IOException {
        this.homeScreen = homeScreen;
        this.controller = controller;
    }

    public TextField playerNameTXT;
    public TextField yearOfBirthTXT;
    public ListView playerListView;

    public void selectPlayer() {
        String playerName = playerNameTXT.getText();
        int yearOfBirth = Integer.parseInt(yearOfBirthTXT.getText());
        controller.selectPlayer(playerName, yearOfBirth);
        ObservableList<List> playerListItems = FXCollections.observableArrayList(controller.getAllSelectedPlayers());
        playerListView.setItems(playerListItems);
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
