package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class FieldLabel extends Label {
    private static final String defaultStyleBlack = "-fx-background-image: url(\"/tile_image_one.png\");-fx-background-position: center center;-fx-background-size: 50 50; -fx-border-color: black;";
    private static final String defaultStyleWhite = "-fx-background-color: white;-fx-border-color: black";
    private static final String defaultStyleTransparent = "-fx-background-color: red; -fx-border-color: transparent";

    private int row;
    private int column;

    public FieldLabel(Color color, int row, int column) {
        setAlignment(Pos.CENTER);
        setStyle(getStyle(color));
        setMinSize(50, 50);
        setMaxSize(50, 50);
        setRow(row);
        setColumn(column);
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

    public int getRow() {
        return row;
    }

    private void setRow(int row) {
        this.row = row;
    }

    int getColumn() {
        return column;
    }

    private void setColumn(int column) {
        this.column = column;
    }
}
