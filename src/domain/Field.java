package domain;

import javafx.scene.paint.Color;

public class Field {
    private Color color;

    public Field(Color color) {
        setColor(color);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
