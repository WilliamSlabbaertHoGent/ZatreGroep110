package main;

import gui.HomeScreen;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class StartUpGui extends Application {

    private Stage mainStage;

    public StartUpGui() throws IOException {
    }

    @Override
    public void start(Stage mainStage) throws Exception {

        /*
        WelcomeScreen root = new WelcomeScreen();
        Scene scene = new Scene(root, 1100, 800);

        URL url = this.getClass().getResource("/css/style.css");
        if (url == null) {
            System.out.println("Resource not found.");
            System.exit(-1);
        }

        scene.getStylesheets().add(url.toExternalForm());
        */

        this.mainStage = mainStage;
        this.mainStage.setTitle("Zatre Game");
        /*showMainScreen();*/
        Scene scene = new Scene(new HomeScreen());
        mainStage.setHeight(400);
        mainStage.setWidth(600);
        mainStage.setResizable(false);
        mainStage.setScene(scene);
        mainStage.show();
    }

    /*public void showMainScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HomeScreen.class.getResource("HomeScreen.fxml"));
        homeScreen = loader.load();

    }
    */
    public static void main(String[] args) {
        launch(args);
    }
}
