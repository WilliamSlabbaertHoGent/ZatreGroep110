package gui;

import controller.DomainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import resources.Language;

import java.io.IOException;

import static domain.ConstantInterface.LABEL_RESOURCE;

public class HomeScreen extends BorderPane {

    private DomainController controller;
    private BorderPane mainMenu;
    private BorderPane registerMenu;
    private BorderPane selectionMenu;
    private GridPane gameScreen;

    public HomeScreen(DomainController controller) throws IOException {
        this.controller = controller;
        this.mainMenu = new MainMenu(this, controller);
        this.registerMenu = new RegisterMenu(this, controller);
        this.selectionMenu = new SelectionMenu(this, controller);
//        this.gameScreen = new GameScreen(this, controller);
        this.showMainMenu();
    }

    public DomainController getDomainController() {
        return this.controller;
    }

    public void showMainMenu() throws IOException {
        this.mainMenu = new MainMenu(this, this.controller);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"), Language.getInstance().getResourceBundle(LABEL_RESOURCE));
//        loader.setLocation(HomeScreen.class.getResource("MainMenu.fxml"));
        loader.setController(this.mainMenu);
        this.mainMenu = loader.load();
        this.setCenter(mainMenu);
    }

    public void showRegisterMenu() throws IOException {
        this.registerMenu = new RegisterMenu(this, this.controller);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RegisterMenu.fxml"), Language.getInstance().getResourceBundle(LABEL_RESOURCE));
//        loader.setLocation(HomeScreen.class.getResource("RegisterMenu.fxml"));
        loader.setController(this.registerMenu);
        this.registerMenu = loader.load();
        this.setCenter(registerMenu);
    }

    public void showSelectionMenu() throws IOException {
        this.selectionMenu = new SelectionMenu(this, this.controller);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SelectionMenu.fxml"), Language.getInstance().getResourceBundle(LABEL_RESOURCE));
        loader.setController(this.selectionMenu);
        this.selectionMenu = loader.load();
        this.setCenter(selectionMenu);
    }

    public void showGameScreen() throws IOException {
        setCenter(gameScreen);
    }

    public void setGameScreen() {
        this.gameScreen = new GameScreen(this, controller);
    }
}
