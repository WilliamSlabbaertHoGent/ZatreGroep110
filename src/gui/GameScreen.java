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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GameScreen extends GridPane {
    private final DomainController domainController;
    private final HomeScreen homeScreen;
    private final List<Label> playerList;

    public GameScreen(HomeScreen homeScreen, DomainController domainController) {
        this.homeScreen = homeScreen;
        this.domainController = domainController;
        this.playerList = new ArrayList<Label>();

        setAlignment(Pos.CENTER);
        addComponents();
        setFirstActivePlayer();
    }

    private void setFirstActivePlayer() {
        this.domainController.getGame().setActivePlayer();
        for(Label label : this.playerList){
            if(label.getText() == this.domainController.getGame().getActivePlayer().getPlayerName()){
                label.setTextFill(Color.RED);
            }
        }
    }

    private void addComponents() {
        int x = 0;
        for (Field[] arr: domainController.getGame().getGameBord().getFields()) {
            int y = 0;
            for (Field field: arr) {
                if (field != null) {
                    FieldLabel playField = new FieldLabel(field.getColor());
                    add(playField, y, x);
                }
                y++;
            }
            x++;
        }

        int y = 0;
        x = 25;

        int index = 0;
        for (Player player: domainController.getGame().getPlayersShuffle()) {
            Label label = new Label(player.getPlayerName());
            label.setId(player.getPlayerName() + "Label");
            label.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
            add(label, 200, y);
            label.setTextFill(Color.BLACK);

            index++;
            y++;

            this.playerList.add(label);
        }


        Button endbutton = new Button("End Turn");
        Button drawbutton = new Button("Draw");
        Button gamequitbutton = new Button("Quit game");
        add(endbutton,200,100);
        add(drawbutton,180,80);
        add(gamequitbutton,300,80);
        endbutton.setOnAction(event -> EndTurn());
        gamequitbutton.setOnAction(event -> {
            try {
                QuitGame();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
    private void EndTurn(){
        this.domainController.getGame().setNextPlayer();
        for ( Node node : this.getChildren() ) {
            if(node instanceof Label){
                var labelNode = (( Label ) node);
                if(labelNode.getText() != this.domainController.getGame().getActivePlayer().getPlayerName()){
                    labelNode.setTextFill(Color.BLACK);
                }else{
                    labelNode.setTextFill(Color.RED);
                }
            }
        }
    }
    public void QuitGame() throws IOException {
        //No language support yet here
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Quit game");
        alert.setContentText("Are you sure you want to quit ?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            this.homeScreen.showMainMenu();
            this.domainController.startNewGame();
        } else {
            //User clicked cancel in this case
        }
    }
}
