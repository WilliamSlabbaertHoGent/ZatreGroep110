package gui;

import controller.DomainController;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class GameScreen extends GridPane {
    private final DomainController domainController;
    private final HomeScreen homeScreen;

    public GameScreen(HomeScreen homeScreen, DomainController domainController) {
        this.homeScreen = homeScreen;
        this.domainController = domainController;

        setAlignment(Pos.CENTER);
        addComponents();
    }

    private void addComponents() {
        int x = 0;
        for (Color[] field: domainController.getGame().getGameBord().getFields()) {
            int y = 0;
            for (Color color: field) {
                Field playField = new Field(color);
                add(playField, y, x);

                y++;
            }
            x++;
        }
    }
}
