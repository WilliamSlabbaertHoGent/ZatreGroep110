package gui;

import controller.DomainController;
import domain.Field;
import domain.Game;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

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
        for (Field[] arr: domainController.getGame().getGameBord().getFields()) {
            int y = 0;
            for (Field field: arr) {
                if (field != null) {
                    FieldLabel playField = new FieldLabel(field.getColor());
                    add(playField, y, x);
                }
                y++;
            }
            x++;
        }
    }
}
