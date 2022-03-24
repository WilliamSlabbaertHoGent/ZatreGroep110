package gui;

import controller.DomainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MainMenu extends BorderPane {

    private DomainController controller;
    private HomeScreen homeScreen;

    public MainMenu(DomainController controller, HomeScreen homeScreen) throws IOException {

        this.controller = controller;
        this.homeScreen = homeScreen;
    }

    /*public void showMainMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HomeScreen.class.getResource("MainMenu.fxml"));
        loader.setController(this);
        this.getScene() = loader.load();
        this.setCenter(this);
    }*/

}
