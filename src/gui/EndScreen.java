package gui;

import controller.DomainController;
import domain.Player;
import domain.ScoreRow;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.io.IOException;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*** Display Scoreboards + Winner (Name + GamesCount) + QuitGame button ***/
public class EndScreen extends GridPane {
    private final DomainController domainController;
    private final HomeScreen homeScreen;
    private final List<Player> playerList;
    private final Player winner;
    public EndScreen(HomeScreen homeScreen, DomainController domainController) throws SQLException {
        this.homeScreen = homeScreen;
        this.domainController = domainController;
        this.playerList = domainController.getGame().getPlayers();
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
        }
    }
    private void addComponents()
    {
        //Scoreboards
        ArrayList<TableView> scoreBoards = new ArrayList<TableView>();
        for(Player player : playerList) //Iterate players
        {
            TableView tempScoreBoard = new TableView(); //reset
            TableColumn<Integer, ScoreRow> cl1 = new TableColumn<>("Ten score");
            cl1.setCellValueFactory(new PropertyValueFactory<>("tenScore"));
            TableColumn<Integer, ScoreRow> cl2 = new TableColumn<>("Eleven score");
            cl2.setCellValueFactory(new PropertyValueFactory<>("elevenScore"));
            TableColumn<Integer, ScoreRow> cl3 = new TableColumn<>("Twelve score");
            cl3.setCellValueFactory(new PropertyValueFactory<>("twelveScore"));
            TableColumn<Integer, ScoreRow> cl4 = new TableColumn<>("Bonus score");
            cl4.setCellValueFactory(new PropertyValueFactory<>("bonus"));
            TableColumn<Integer, ScoreRow> cl5 = new TableColumn<>("Doublebonus score");
            cl5.setCellValueFactory(new PropertyValueFactory<>("doubleBonus"));
            TableColumn<Integer, ScoreRow> cl6 = new TableColumn<>("Totalbonus score");
            cl6.setCellValueFactory(new PropertyValueFactory<>("totalBonusScore"));
            TableColumn<Integer, ScoreRow> cl7 = new TableColumn<>("Total score");
            cl7.setCellValueFactory(new PropertyValueFactory<>("total"));
            tempScoreBoard.getColumns().add(cl1);
            tempScoreBoard.getColumns().add(cl2);
            tempScoreBoard.getColumns().add(cl3);
            tempScoreBoard.getColumns().add(cl4);
            tempScoreBoard.getColumns().add(cl5);
            tempScoreBoard.getColumns().add(cl6);
            tempScoreBoard.getColumns().add(cl7);
            for (ScoreRow scoreRow : player.getScoreBoard().getScoreRows()) //Iterate each scorerow per player
            {
                tempScoreBoard.getItems().add(scoreRow);

            }
            scoreBoards.add(tempScoreBoard);
        }
        for(TableView tempTable : scoreBoards)
        {
            VBox vbox = new VBox();
            vbox.getChildren().addAll(tempTable);
            vbox.setSpacing(10);
            vbox.setAlignment(Pos.CENTER);
            add(vbox,0,0);
        }


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
