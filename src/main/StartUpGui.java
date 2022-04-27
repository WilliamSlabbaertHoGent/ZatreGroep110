package main;

import controller.DomainController;
import domain.Game;
import gui.HomeScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class StartUpGui extends Application {

    private Stage mainStage;
    private DomainController controller;

    @Override
    public void start(Stage mainStage) throws Exception {

        this.controller = new DomainController();
        this.controller.startNewGame();
        this.mainStage = mainStage;
        this.mainStage.setTitle("Zatre Game");
        Scene scene = new Scene(new HomeScreen(controller));
        mainStage.setHeight(850);
        mainStage.setWidth(1400);
        mainStage.setResizable(false);
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
