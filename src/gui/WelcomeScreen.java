package gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

import java.util.Objects;

public class WelcomeScreen extends VBox {
    public WelcomeScreen() {
        Label lblWelcome = new Label("Welcome to Zatre!");
        lblWelcome.setLayoutY(10);
        lblWelcome.setLayoutX(200);
        lblWelcome.getStyleClass().add("title");
        lblWelcome.setTextAlignment(TextAlignment.CENTER);
        this.getChildren().add(lblWelcome);

        ImageView ivZatre = new ImageView(
                new Image(
                        getClass().getResourceAsStream(
                                "/images/board.png"
                        )
                )
        );
        ivZatre.setLayoutX(50);
        ivZatre.setLayoutY(50);
        this.getChildren().add(ivZatre);
    }
}
