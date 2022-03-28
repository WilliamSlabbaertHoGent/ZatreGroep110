package gui;

import controller.DomainController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import resources.Language;

import java.io.IOException;
import java.util.Locale;

public class HomeScreen extends BorderPane {

    private DomainController controller;
    private BorderPane mainMenu; // casting exception when using menu class? //
    private BorderPane registerMenu; // casting exception when using menu class? //
    private BorderPane selectionMenu; // casting exception when using menu class? //

    public HomeScreen() {
        this.controller = controller;
    }

    public HomeScreen(DomainController controller) throws IOException {
        this.controller = controller;
        this.mainMenu = new MainMenu(this, controller);
        this.registerMenu = new RegisterMenu(this, controller);
        this.selectionMenu = new SelectionMenu(this, controller );
        this.showMainMenu();
    }

    public void showMainMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"), Language.getInstance().getResourceBundle("resources.MessagesBundle"));
//        loader.setLocation(HomeScreen.class.getResource("MainMenu.fxml"));
        loader.setController(this.mainMenu);
        this.mainMenu = loader.load();
        this.setCenter(mainMenu);
    }

    public void showRegisterMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RegisterMenu.fxml"), Language.getInstance().getResourceBundle("resources.MessagesBundle"));
//        loader.setLocation(HomeScreen.class.getResource("RegisterMenu.fxml"));
        loader.setController(this.registerMenu);
        this.registerMenu = loader.load();
        this.setCenter(registerMenu);
    }

    public void showSelectionMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SelectionMenu.fxml"), Language.getInstance().getResourceBundle("resources.MessagesBundle"));
            loader.setController(this.selectionMenu);
        this.selectionMenu = loader.load();
        this.setCenter(selectionMenu);
    }

}
