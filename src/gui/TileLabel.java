package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;


public class TileLabel extends Label {

    private static final String defaultStyleOne = "-fx-background-image: url('tile_image_one.png');-fx-border-color: transparent;";
    private static final String defaultStyleTwo = "-fx-background-image: url('tile_image_two.png');-fx-border-color: transparent";
    private static final String defaultStyleThree = "-fx-background-image: url('tile_image_three.png');-fx-border-color: transparent";
    private static final String defaultStyleFour = "-fx-background-image: url('tile_image_four.png');-fx-border-color: transparent;";
    private static final String defaultStyleFive = "-fx-background-image: url('tile_image_five.png');-fx-border-color: transparent";
    private static final String defaultStyleSix = "-fx-background-image: url('tile_image_six.png');-fx-border-color: transparent";

    public TileLabel(int value) {
        setAlignment(Pos.CENTER);
        setStyle(getStyle(value));
        setMinSize(50,50);
        setMaxSize(50,50);
    }

    private String getStyle(int value) {
        if (value == 1) {
            return defaultStyleOne;
        } else if (value == 2) {
            return defaultStyleTwo;
        } else if (value == 3) {
            return defaultStyleThree;
        } else if (value == 4) {
            return defaultStyleFour;
        } else if (value == 5) {
            return defaultStyleFive;
        } else if (value == 6) {
            return defaultStyleSix;
        }
        return null;

    }
}
