package domain;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import static domain.ConstantInterface.*;

public class GameBord {
    private final Field[][] fields = new Field[15][15];

    public GameBord() {
        setFields();
    }

    public Field[][] getFields() {
        return fields;
    }

    private void setFields() {
        for (int row = FIRST_COLUMN_ROW; row <= LAST_COLUMN_ROW; row++) {
            for (int column = FIRST_COLUMN_ROW; column <= LAST_COLUMN_ROW; column++) {
                fields[row][column] = new Field(Color.WHITE);
            }
        }

        clearUnneededFields();
        setBlackFields();
    }

    private void clearUnneededFields() {
        for (int column = FIRST_COLUMN_ROW; column <= LAST_COLUMN_ROW; column++) {
            if (column == 4 || column == 5 || column == 6 || column == 8 || column == 9 || column == 10) {
                continue;
            }

            fields[FIRST_COLUMN_ROW][column] = null;
            fields[LAST_COLUMN_ROW][column] = null;
        }

        fields[FIRST_COLUMN_ROW][7] = null;

        for (int row = FIRST_COLUMN_ROW + 1; row <= LAST_COLUMN_ROW; row++) {

            if (row == 4 || row == 5 || row == 6 || row == 8 || row == 9 || row == 10) {
                continue;
            }

            fields[row][FIRST_COLUMN_ROW] = null;
            fields[row][LAST_COLUMN_ROW] = null;
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