package gui;

import controller.DomainController;
import domain.Field;
import domain.Game;
import domain.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

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

        int y = 0;
        x = 25;

        int index = 0;
        for (Player player: domainController.getGame().getPlayers()) {
            Label label = new Label(player.getPlayerName());
            label.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
            add(label, x, y);

            switch (index) {
                case 0:
                    label.setTextFill(Color.BLACK);
                    break;
                case 1:
                    label.setTextFill(Color.RED);
                    break;
                case 2:
                    label.setTextFill(Color.BLUE);
                    break;
                default:
                    label.setTextFill(Color.DARKORANGE);
            }

            index++;
            y++;
        }
    }
}
