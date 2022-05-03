package gui;

import controller.DomainController;
import domain.Field;
import domain.Player;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*** Display Scoreboards + Winner (Name + GamesCount) + QuitGame button ***/
public class EndScreen extends GridPane {
    private final DomainController domainController;
    private final HomeScreen homeScreen;
    private final List<Label> playerList;
    private final Player winner;
    public EndScreen(HomeScreen homeScreen, DomainController domainController) {
        this.homeScreen = homeScreen;
        this.domainController = domainController;
        this.playerList = new ArrayList<Label>();
        domainController.getGame().determineWinner();
        this.winner = domainController.getGame().getWinner();

        setAlignment(Pos.CENTER);
        addComponents();
    }
    public void QuitGame() throws IOException {
        this.homeScreen.showMainMenu();
        this.domainController.startNewGame();
    }
    private void addComponents()
    {
        //Winner label (might be replaced by another element later)
        Label label = new Label(winner.getPlayerName());
        label.setId(winner.getPlayerName() + "Label");
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 28));
        label.setAlignment(Pos.CENTER);
        add(label,150,150);
        //Gamequit button
        Button gamequitbutton = new Button("Quit game");

        add(gamequitbutton,150,80);
        gamequitbutton.setOnAction(event -> {
            try {
                QuitGame();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
