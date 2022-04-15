package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class FieldLabel extends Label {
    private static final String defaultStyleBlack = "-fx-background-color: gray;-fx-border-color: black;";
    private static final String defaultStyleWhite = "-fx-background-color: white;-fx-border-color: black";
    private static final String defaultStyleTransparent = "-fx-background-color: red; -fx-border-color: transparent";

    public FieldLabel(Color color) {
        setAlignment(Pos.CENTER);
        setStyle(getStyle(color));
        setMinSize(50,50);
        setMaxSize(50,50);
    }

    private String getStyle(Color color) {
        if (color == Color.BLACK) {
            return defaultStyleBlack;
        } else if (color == Color.WHITE) {
            return defaultStyleWhite;
        } else if (color == Color.TRANSPARENT) {
            return defaultStyleTransparent;
        }

        return null;
    }
}
