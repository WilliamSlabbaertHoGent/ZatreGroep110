package domain;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class GameBord {
    private final Field[][] fields = new Field[15][15];

    public GameBord(Game game) {
        setFields();
    }

    public Field[][] getFields() {
        return fields;
    }

    private void setFields() {
        for (int row = 0; row <= 14; row++) {
            for (int column = 0; column <= 14; column++) {
                fields[row][column] = new Field(Color.WHITE);
            }
        }

        clearUnneededFields();
        setBlackFields();
    }

    private void clearUnneededFields() {
        for (int column = 0; column <= 14; column++) {
            if (column == 4 || column == 5 || column == 6 || column == 8 || column == 9 || column == 10) {
                continue;
            }

            fields[0][column] = null;
            fields[14][column] = null;
        }

        fields[0][7] = null;

        for (int row = 1; row <= 14; row++) {

            if (row == 4 || row == 5 || row == 6 || row == 8 || row == 9 || row == 10) {
                continue;
            }

            fields[row][0] = null;
            fields[row][14] = null;
        }
    }

    private void setBlackFields() {
        fields[0][6] = new Field(Color.BLACK);
        fields[0][8] = new Field(Color.BLACK);

        fields[14][6] = new Field(Color.BLACK);
        fields[14][8] = new Field(Color.BLACK);

        int firstBlack = 1;
        int lastBlack = 13;

        for (int row = 1; row <= 13; row++) {
            fields[row][firstBlack] = new Field(Color.BLACK);
            fields[row][lastBlack] = new Field(Color.BLACK);

            if (row == 6 || row == 8) {
                fields[row][0] = new Field(Color.BLACK);
                fields[row][14] = new Field(Color.BLACK);
            }

            firstBlack++;
            lastBlack--;
        }
    }
}