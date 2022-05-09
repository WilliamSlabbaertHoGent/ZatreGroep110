package gui;

import controller.DomainController;
import domain.Field;
import domain.Player;
import domain.ScoreRow;
import domain.Tile;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class GameScreen extends GridPane {
    private final DomainController domainController;
    private final HomeScreen homeScreen;
    private final List<Label> playerList;
    private List<StackPane> tileStackPaneList;
    private List<Tile> playerInventory;
    private List<FieldLabel> playFields;

    private int selectedTileValue;
    private Rectangle selectedTile;
    private Text selectedText;
    private List<FieldLabel> playedFields;
    private List<Label> scoreRowList;

    public GameScreen(HomeScreen homeScreen, DomainController domainController) {
        this.homeScreen = homeScreen;
        this.domainController = domainController;
        this.playerList = new ArrayList<Label>();
        this.playerInventory = new ArrayList<>();
        this.tileStackPaneList = new ArrayList<>();
        this.playFields = new ArrayList<>();
        playedFields = new ArrayList<>();
        this.scoreRowList = new ArrayList<>();

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
                    FieldLabel playField = new FieldLabel(field.getColor(), x, y);
                    playField.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            try {
                                domainController.setFieldValue(playField.getRow(), playField.getColumn(), selectedTileValue);
                                playField.setText(String.valueOf(selectedTileValue));
                                for (StackPane stack: tileStackPaneList) {
                                    if (stack.getChildren().contains(selectedTile) && stack.getChildren().contains(selectedText)){
                                        stack.getChildren().remove(selectedTile);
                                        stack.getChildren().remove(selectedText);
                                    }
                                }
                            } catch (RuntimeException exception) {
                                triggerAlert(exception.getMessage());
                            }
                        }
                    });
                    playFields.add(playField);
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
        Button logbutton = new Button("Log");
        Button drawbutton = new Button("Draw");
        Button gamequitbutton = new Button("Quit game");
        add(endbutton,220,80);
        add(drawbutton,180,80);
        add(logbutton,10,80);
        add(gamequitbutton,360,80);


        RandomStonesAdd(3);
        logbutton.setOnAction(event-> LogSys());
        endbutton.setOnAction(event -> EndTurn());
        gamequitbutton.setOnAction(event -> {
            try {
                QuitGame();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        addScoreBoard();

    }
    private void EndTurn(){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("End turn");
        alert.setContentText("Are you sure you want to end your turn?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            this.domainController.getGame().setNextPlayer();
            RandomStonesAdd(3);
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
            RandomStonesAdd(2);
        }
        addScoreBoard();
    }
    private void LogSys(){
        for (ScoreRow scoreRow: domainController.getGame().getActivePlayer().getScoreBoard().getScoreRows()) {
            System.out.println("double score: " + (scoreRow.isDoubleBonus() ? "yes" : "no"));
            System.out.println("10 score: " + (scoreRow.isTenScore() ? "yes" : "no"));
            System.out.println("11 score: " + (scoreRow.isElevenScore() ? "yes" : "no"));
            System.out.println("12 score: " + (scoreRow.isTwelveScore() ? "yes" : "no"));
            System.out.println("bonus: " + (scoreRow.getBonus()));
            System.out.println("total: " + scoreRow.getTotal());
        }

        System.out.println(domainController.getGame().getGameBord().getLog());

    }
    private void QuitGame() throws IOException {
        //No language support yet here
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Quit game");
        alert.setContentText("Are you sure you want to quit ?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            this.homeScreen.showMainMenu();
            this.domainController.startNewGame();
        }
    }
    private void RandomStonesAdd(int amount){
        this.playerInventory = this.domainController.RandomTilesShuffle(this.playerInventory, amount);

        int x = 180;
        this.getChildren().removeAll(this.tileStackPaneList);
      
        this.tileStackPaneList = new ArrayList<>();
        for(Tile item : this.playerInventory){
            StackPane stack = new StackPane();
            Rectangle tile = new Rectangle(50,50);
            Text text = new Text(String.valueOf(item.getValue()));
            tile.setStroke(Color.BLACK);
            tile.setFill(Color.WHITE);
            tile.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (tile.getStroke() == Color.WHITE && tile.getFill() == Color.RED) {
                        tile.setStroke(Color.BLACK);
                        selectedTile = null;
                        selectedText = null;
                    } else {
                        // deselect other selected stones
                        if (selectedTile != null) {
                            selectedTile.setFill(Color.WHITE);
                        }

                        tile.setFill(Color.RED);
                        selectedTile = tile;
                        selectedText = text;
                    }
                    setSelectedTileValue(item.getValue());
                }
            });
            stack.getChildren().addAll(tile,text);
            stack.setPadding(new Insets(5,5,5,5));
            add(stack, x, 15);
            this.tileStackPaneList.add(stack);
            x += 10;
        }
    }

    private void setSelectedTileValue(int value) {
        // If already selected, deselect
        if (selectedTileValue == value) {
            selectedTileValue = 0;
            return;
        }

        selectedTileValue = value;
    }

    private boolean validMove(FieldLabel selectedField) {
        if (selectedTile == null && selectedTileValue == 0) {
            triggerAlert("Please select a Stone.");
            return false;
        }

        if (!selectedField.getText().isEmpty()) {
            triggerAlert("Field already has a stone.");
            return false;
        }

        return true;
    }

    private void triggerAlert(String text) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(text);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            alert.close();
        }
    }
    private void addScoreBoard(){
        var x = 5;
        var y = 90;
        for (var node: this.getChildren()) {
            if(node instanceof Label){
                if(this.scoreRowList.contains((Label) node)){
                    node.setVisible(false);
                }
            }
        }
        this.scoreRowList = new ArrayList<>();
        for (var scoreRow: domainController.getGame().getActivePlayer().getScoreBoard().getScoreRows()) {
            var name = new Label(domainController.getGame().getActivePlayer().getPlayerName()+ " => ");
            var doubleS = new Label("double score: " + (scoreRow.isDoubleBonus() ? "yes" : "no") + " | ");
            var tenS = new Label("10 score: " + (scoreRow.isTenScore() ? "yes" : "no") + " | ");
            var elevS = new Label("11 score: " + (scoreRow.isElevenScore() ? "yes" : "no") + " | ");
            var twelS = new Label("12 score: " + (scoreRow.isTwelveScore() ? "yes" : "no") + " | ");
            var bonus = new Label("bonus: " + (scoreRow.getBonus()) + " | ");
            var total = new Label("total: " + scoreRow.getTotal() + " | ");
            this.scoreRowList.add(name);
            this.scoreRowList.add(doubleS);
            this.scoreRowList.add(tenS);
            this.scoreRowList.add(elevS);
            this.scoreRowList.add(twelS);
            this.scoreRowList.add(bonus);
            this.scoreRowList.add(total);

            add(name,y,x);
            add(doubleS,y + 1,x);
            add(tenS,y +2,x);
            add(elevS,y+3,x);
            add(twelS,y+4,x);
            add(bonus,y+5,x);
            add(total,y+6,x);
            x += 1;
            y += 1;
        }
    }
}
