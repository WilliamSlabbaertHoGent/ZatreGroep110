package gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;

import java.util.Objects;

public class WelcomeScreen extends Pane {
    public WelcomeScreen() {
        Label lblWelcome = new Label("Welcome to Zatre!");
        ImageView ivZatre = new ImageView(
                new Image(
                        getClass().getResourceAsStream(
                                "/images/board.png"
                        )
                )
        );

        lblWelcome.setLayoutX(200);
        lblWelcome.setLayoutY(10);

        ivZatre.setLayoutX(50);
        ivZatre.setLayoutY(50);

        this.getChildren().addAll(lblWelcome, ivZatre);
    }
}
