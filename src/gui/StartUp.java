package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartUp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        WelcomeScreen root = new WelcomeScreen();
        Scene scene = new Scene(root, 1100, 800);

        stage.setScene(scene);
        stage.setTitle("Welcome to Zatre.");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
