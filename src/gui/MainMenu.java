package gui;

import controller.DomainController;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import resources.Language;

import java.io.IOException;
import java.util.Locale;

public class MainMenu extends BorderPane {

    public DomainController domainController;
    public Locale[] supportedLanguages = {new Locale("nl"), new Locale(Locale.getDefault().getLanguage())};
    public Label languageLabel;
    public ComboBox languageComboBox;
    private HomeScreen homeScreen;

    public MainMenu() throws IOException {
        this.homeScreen = homeScreen;
        this.domainController = homeScreen.getDomainController();
    }

    public MainMenu(HomeScreen homeScreen, DomainController controller) throws IOException {
        this.homeScreen = homeScreen;
        this.domainController = controller;
    }

    public void showRegisterMenu() throws IOException {
        this.homeScreen.showRegisterMenu();
    }

    public void showSelectionMenu() throws IOException {
        this.homeScreen.showSelectionMenu();
    }

    public void showGameScreen() throws IOException {
        homeScreen.showGameScreen();
    }

    public void getLanguageMenu() throws IOException {
        this.languageLabel.setVisible(true);
        this.languageComboBox.setVisible(true);
        this.languageComboBox.setItems(FXCollections
                .observableArrayList(supportedLanguages));
    }

    public void switchLanguage() throws IOException {
        Language.getInstance().setLocale((Locale) languageComboBox.getSelectionModel().getSelectedItem());
        this.homeScreen.showMainMenu();
    }

    public void closeApplication() throws IOException {
        Platform.exit();
    }

}
