package gui;

import controller.DomainController;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MainMenu extends BorderPane {

    private DomainController controller = new DomainController();
    private HomeScreen homeScreen = new HomeScreen();

    public MainMenu() throws IOException
    {
        this.controller = controller;
        this.homeScreen = homeScreen;
    }

    public MainMenu(HomeScreen homeScreen, DomainController controller) throws IOException {

        this.controller = controller;
        this.homeScreen = homeScreen;
    }

    public void showRegisterMenu() throws IOException {
        this.homeScreen.showRegisterMenu();
    }

    public void showSelectionMenu() throws IOException {
        this.homeScreen.showSelectionMenu();
    }

    public void closeApplication() throws IOException {
        Platform.exit();
    }

}
