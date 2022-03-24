package gui;

import controller.DomainController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class HomeScreen extends BorderPane {

    private BorderPane mainMenu; // casting exception when using menu class? -> TO DO //
    private BorderPane registerMenu; // casting exception when using menu class? -> TO DO //
    private BorderPane selectionMenu; // casting exception when using menu class? -> TO DO //

    public HomeScreen(DomainController controller) throws IOException {
        this.mainMenu = new BorderPane();
        this.registerMenu = new RegisterMenu(this, controller);
        this.selectionMenu = new BorderPane();

        this.showMainMenu();
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

    public void showSelectionMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HomeScreen.class.getResource("SelectionMenu.fxml"));
        this.selectionMenu = loader.load();
        this.setCenter(selectionMenu);
    }

    public void closeApplication() {
        Platform.exit();
    }

}
