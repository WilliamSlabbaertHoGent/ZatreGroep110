package gui;

import controller.DomainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import resources.Language;

import java.lang.*;
import static domain.ConstantInterface.*;

import java.io.IOException;

import java.util.List;

public class SelectionMenu extends BorderPane {

    private DomainController controller;
    private HomeScreen homeScreen;

    public SelectionMenu() throws IOException {
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
    public Button confirmSelectionButton;

    public Alert alert = new Alert(Alert.AlertType.NONE);

    public void selectPlayer() {
        String playerName = playerNameTXT.getText();
        // yearOfBirth validation in GUI as controller select method requires int parameter //
        int yearOfBirth = 0;
        if (!((yearOfBirthTXT.getText() == null) || (yearOfBirthTXT.getText().isBlank()) || !(yearOfBirthTXT.getText().matches("\\d*"))))
        {yearOfBirth = Integer.parseInt(yearOfBirthTXT.getText());}
        try {
            controller.selectPlayer(playerName, yearOfBirth);
            ObservableList<List> playerListItems = FXCollections.observableArrayList(controller.getAllSelectedPlayers());
            playerListView.setItems(playerListItems);
            if (playerListItems.size() >= 2 ) {
                this.confirmSelectionButton.setDisable(false);
            }
        }
        catch (RuntimeException exception)
        {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle(
                    Language.getInstance().getResourceBundle(ERROR_RESOURCE).getString("error.invalidInput")
            );
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
        alert.setAlertType(Alert.AlertType.CONFIRMATION);
        alert.setTitle(Language.getInstance().getResourceBundle(LABEL_RESOURCE).getString("label.confirmPlayers"));
        alert.setHeaderText(Language.getInstance().getResourceBundle(LABEL_RESOURCE).getString("label.startNewGame"));
        alert.setContentText(Language.getInstance().getResourceBundle(LABEL_RESOURCE).getString("label.startNewGameLong"));
        alert.showAndWait();

        try {
            homeScreen.showGameScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // TK
        // START GAME(playerselection)
        // ADJUST GAMESCOUNT(playerselection) -> decreaseGamesCount()
        // DETERMINE ORDER OF PLAY(playerselection) -> shufflePlayers()
        // (PLAY TURN -> RANDOM SCORE) + ADJUST SCOREBOARD
        // CHECK WINNER
        // ADJUST GAMESCOUNT(winner) -> increaseGamesCount()
        // SHOW WINNER(name, gamescount)

    }

    public void returnToMain() throws IOException {
        this.homeScreen.showMainMenu();
    }

}
