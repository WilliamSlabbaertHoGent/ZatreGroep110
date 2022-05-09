package main;
import controller.DomainController;
import gui.HomeScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


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
        mainStage.setHeight(1000);
        mainStage.setWidth(1900);
        mainStage.setResizable(false);
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
