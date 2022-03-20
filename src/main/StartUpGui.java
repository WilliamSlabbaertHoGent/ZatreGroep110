package main;

import gui.WelcomeScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class StartUpGui extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        WelcomeScreen root = new WelcomeScreen();
        Scene scene = new Scene(root, 1100, 800);

        URL url = this.getClass().getResource("/css/style.css");
        if (url == null) {
            System.out.println("Resource not found.");
            System.exit(-1);
        }

        scene.getStylesheets().add(url.toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Welcome to Zatre.");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
