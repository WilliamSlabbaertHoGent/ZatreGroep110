package gui;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class HomeScreen extends BorderPane {

    private BorderPane mainMenu; // casting exception when using subclass? -> TO DO //
    private BorderPane registerMenu; // casting exception when using subclass? -> TO DO //

    public HomeScreen() throws IOException {
        this.mainMenu = new BorderPane();
        this.registerMenu = new BorderPane();
        showMainMenu();
    }

    public void showMainMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HomeScreen.class.getResource("MainMenu.fxml"));
        loader.setController(this);
        this.mainMenu = loader.load();
        this.setCenter(mainMenu);
    }

    public void showRegisterMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HomeScreen.class.getResource("RegisterMenu.fxml"));
        this.registerMenu = loader.load();
        this.setCenter(registerMenu);
    }

    public void closeApplication() {
        Platform.exit();
    }
}
