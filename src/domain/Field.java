package domain;

import javafx.scene.paint.Color;

public class Field {
    private Color color;
    private int tileValue = 0;
    private int row;
    private int column;

    public Field(Color color, int row, int column) {
        setColor(color);
        setRow(row);
        setColumn(column);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getTileValue() {
        return tileValue;
    }

    public final void setTileValue(int value) {
        if (value == 0) {
            throw new RuntimeException("Please select a tile!");
        }

        if (tileValue != 0) {
            throw new RuntimeException("Tile already has a value!");
        }

        tileValue = value;
    }
}
