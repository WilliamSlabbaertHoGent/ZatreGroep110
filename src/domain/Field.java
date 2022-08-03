package domain;

import exceptions.NoTileSelectedException;
import exceptions.TileOccupiedException;
import javafx.scene.paint.Color;
import resources.Language;

import static domain.ConstantInterface.EXCEPTION_RESOURCE;


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
            throw new NoTileSelectedException(
                    Language.getInstance().getString(EXCEPTION_RESOURCE, "exception.selectTile")
            );
        }

        if (tileValue != 0) {
            throw new TileOccupiedException(
                    Language.getInstance().getString(EXCEPTION_RESOURCE, "exception.tileOccupied")
            );
        }

        tileValue = value;
    }
}
