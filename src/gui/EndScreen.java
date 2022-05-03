package gui;

import controller.DomainController;
import domain.Field;
import domain.Player;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*** Display Scoreboards + Winner (Name + GamesCount) + QuitGame button ***/
public class EndScreen extends GridPane {
    private final DomainController domainController;
    private final HomeScreen homeScreen;
    private final List<Label> playerList;
    private final Player winner;
    public EndScreen(HomeScreen homeScreen, DomainController domainController) throws SQLException {
        this.homeScreen = homeScreen;
        this.domainController = domainController;
        this.playerList = new ArrayList<Label>();
        domainController.getGame().determineWinner();
        this.winner = domainController.getGame().getWinner();
        this.domainController.increaseGamesCount(winner);

        setAlignment(Pos.CENTER);
        addComponents();
    }
    public void QuitGame() throws IOException {
        //No language support yet here
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Exit game");
        alert.setContentText("Are you sure you want to exit ?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            this.homeScreen.showMainMenu();
            this.domainController.startNewGame();
        } else {
            //User clicked cancel in this case (nothing needs to be done)
        }
    }
    private void addComponents()
    {
        //Winner label (might be replaced by another element later)
        Label label = new Label(winner.getPlayerName() + " Games: " + winner.getGamesCount());
        label.setId(winner.getPlayerName() + "Label");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 28));
        label.setAlignment(Pos.CENTER);
        add(label,150,150);
        //Exit button
        Button exitbutton = new Button("Exit");

        add(exitbutton,150,80);
        exitbutton.setOnAction(event -> {
            try {
                QuitGame();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
