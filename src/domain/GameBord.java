package domain;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class GameBord {
    /*private List<Box> boxes = new ArrayList<>();*/
    /*private List<Stone> placedStones = new ArrayList<>();*/
    private final Field[][] fields = new Field[15][15];

    public GameBord(Game game) {
        setFields();
    }

    public Field[][] getFields() {
        return fields;
    }

    private void setFields() {
        fields[0][4] = new Field(Color.WHITE);
        fields[0][5] = new Field(Color.WHITE);
        fields[0][6] = new Field(Color.BLACK);
        fields[0][8] = new Field(Color.BLACK);
        fields[0][9] = new Field(Color.WHITE);
        fields[0][10] = new Field(Color.WHITE);

        fields[1][1] = new Field(Color.BLACK);
        fields[1][2] = new Field(Color.WHITE);
        fields[1][3] = new Field(Color.WHITE);
        fields[1][4] = new Field(Color.WHITE);
        fields[1][5] = new Field(Color.WHITE);
        fields[1][6] = new Field(Color.WHITE);
        fields[1][7] = new Field(Color.WHITE);
        fields[1][8] = new Field(Color.WHITE);
        fields[1][9] = new Field(Color.WHITE);
        fields[1][10] = new Field(Color.WHITE);
        fields[1][11] = new Field(Color.WHITE);
        fields[1][12] = new Field(Color.WHITE);
        fields[1][13] = new Field(Color.BLACK);

        fields[2][1] = new Field(Color.WHITE);
        fields[2][2] = new Field(Color.BLACK);
        fields[2][3] = new Field(Color.WHITE);
        fields[2][4] = new Field(Color.WHITE);
        fields[2][5] = new Field(Color.WHITE);
        fields[2][6] = new Field(Color.WHITE);
        fields[2][7] = new Field(Color.WHITE);
        fields[2][8] = new Field(Color.WHITE);
        fields[2][9] = new Field(Color.WHITE);
        fields[2][10] = new Field(Color.WHITE);
        fields[2][11] = new Field(Color.WHITE);
        fields[2][12] = new Field(Color.BLACK);
        fields[2][13] = new Field(Color.WHITE);

        fields[3][1] = new Field(Color.WHITE);
        fields[3][2] = new Field(Color.WHITE);
        fields[3][3] = new Field(Color.BLACK);
        fields[3][4] = new Field(Color.WHITE);
        fields[3][5] = new Field(Color.WHITE);
        fields[3][6] = new Field(Color.WHITE);
        fields[3][7] = new Field(Color.WHITE);
        fields[3][8] = new Field(Color.WHITE);
        fields[3][9] = new Field(Color.WHITE);
        fields[3][10] = new Field(Color.WHITE);
        fields[3][11] = new Field(Color.BLACK);
        fields[3][12] = new Field(Color.WHITE);
        fields[3][13] = new Field(Color.WHITE);

        fields[4][0] = new Field(Color.WHITE);
        fields[4][1] = new Field(Color.WHITE);
        fields[4][2] = new Field(Color.WHITE);
        fields[4][3] = new Field(Color.WHITE);
        fields[4][4] = new Field(Color.BLACK);
        fields[4][5] = new Field(Color.WHITE);
        fields[4][6] = new Field(Color.WHITE);
        fields[4][7] = new Field(Color.WHITE);
        fields[4][8] = new Field(Color.WHITE);
        fields[4][9] = new Field(Color.WHITE);
        fields[4][10] = new Field(Color.BLACK);
        fields[4][11] = new Field(Color.WHITE);
        fields[4][12] = new Field(Color.WHITE);
        fields[4][13] = new Field(Color.WHITE);
        fields[4][14] = new Field(Color.WHITE);

        fields[5][0] = new Field(Color.WHITE);
        fields[5][1] = new Field(Color.WHITE);
        fields[5][2] = new Field(Color.WHITE);
        fields[5][3] = new Field(Color.WHITE);
        fields[5][4] = new Field(Color.WHITE);
        fields[5][5] = new Field(Color.BLACK);
        fields[5][6] = new Field(Color.WHITE);
        fields[5][7] = new Field(Color.WHITE);
        fields[5][8] = new Field(Color.WHITE);
        fields[5][9] = new Field(Color.BLACK);
        fields[5][10] = new Field(Color.WHITE);
        fields[5][11] = new Field(Color.WHITE);
        fields[5][12] = new Field(Color.WHITE);
        fields[5][13] = new Field(Color.WHITE);
        fields[5][14] = new Field(Color.WHITE);

        fields[6][0] = new Field(Color.BLACK);
        fields[6][1] = new Field(Color.WHITE);
        fields[6][2] = new Field(Color.WHITE);
        fields[6][3] = new Field(Color.WHITE);
        fields[6][4] = new Field(Color.WHITE);
        fields[6][5] = new Field(Color.WHITE);
        fields[6][6] = new Field(Color.BLACK);
        fields[6][7] = new Field(Color.WHITE);
        fields[6][8] = new Field(Color.BLACK);
        fields[6][9] = new Field(Color.WHITE);
        fields[6][10] = new Field(Color.WHITE);
        fields[6][11] = new Field(Color.WHITE);
        fields[6][12] = new Field(Color.WHITE);
        fields[6][13] = new Field(Color.WHITE);
        fields[6][14] = new Field(Color.BLACK);

        fields[7][1] = new Field(Color.WHITE);
        fields[7][2] = new Field(Color.WHITE);
        fields[7][3] = new Field(Color.WHITE);
        fields[7][4] = new Field(Color.WHITE);
        fields[7][5] = new Field(Color.WHITE);
        fields[7][6] = new Field(Color.WHITE);
        fields[7][7] = new Field(Color.BLACK);
        fields[7][8] = new Field(Color.WHITE);
        fields[7][9] = new Field(Color.WHITE);
        fields[7][10] = new Field(Color.WHITE);
        fields[7][11] = new Field(Color.WHITE);
        fields[7][12] = new Field(Color.WHITE);
        fields[7][13] = new Field(Color.WHITE);

        fields[8][0] = new Field(Color.BLACK);
        fields[8][1] = new Field(Color.WHITE);
        fields[8][2] = new Field(Color.WHITE);
        fields[8][3] = new Field(Color.WHITE);
        fields[8][4] = new Field(Color.WHITE);
        fields[8][5] = new Field(Color.WHITE);
        fields[8][6] = new Field(Color.BLACK);
        fields[8][7] = new Field(Color.WHITE);
        fields[8][8] = new Field(Color.BLACK);
        fields[8][9] = new Field(Color.WHITE);
        fields[8][10] = new Field(Color.WHITE);
        fields[8][11] = new Field(Color.WHITE);
        fields[8][12] = new Field(Color.WHITE);
        fields[8][13] = new Field(Color.WHITE);
        fields[8][14] = new Field(Color.BLACK);

        fields[9][0] = new Field(Color.WHITE);
        fields[9][1] = new Field(Color.WHITE);
        fields[9][2] = new Field(Color.WHITE);
        fields[9][3] = new Field(Color.WHITE);
        fields[9][4] = new Field(Color.WHITE);
        fields[9][5] = new Field(Color.BLACK);
        fields[9][6] = new Field(Color.WHITE);
        fields[9][7] = new Field(Color.WHITE);
        fields[9][8] = new Field(Color.WHITE);
        fields[9][9] = new Field(Color.BLACK);
        fields[9][10] = new Field(Color.WHITE);
        fields[9][11] = new Field(Color.WHITE);
        fields[9][12] = new Field(Color.WHITE);
        fields[9][13] = new Field(Color.WHITE);
        fields[9][14] = new Field(Color.WHITE);

        fields[10][0] = new Field(Color.WHITE);
        fields[10][1] = new Field(Color.WHITE);
        fields[10][2] = new Field(Color.WHITE);
        fields[10][3] = new Field(Color.WHITE);
        fields[10][4] = new Field(Color.BLACK);
        fields[10][5] = new Field(Color.WHITE);
        fields[10][6] = new Field(Color.WHITE);
        fields[10][7] = new Field(Color.WHITE);
        fields[10][8] = new Field(Color.WHITE);
        fields[10][9] = new Field(Color.WHITE);
        fields[10][10] = new Field(Color.BLACK);
        fields[10][11] = new Field(Color.WHITE);
        fields[10][12] = new Field(Color.WHITE);
        fields[10][13] = new Field(Color.WHITE);
        fields[10][14] = new Field(Color.WHITE);

        fields[11][1] = new Field(Color.WHITE);
        fields[11][2] = new Field(Color.WHITE);
        fields[11][3] = new Field(Color.BLACK);
        fields[11][4] = new Field(Color.WHITE);
        fields[11][5] = new Field(Color.WHITE);
        fields[11][6] = new Field(Color.WHITE);
        fields[11][7] = new Field(Color.WHITE);
        fields[11][8] = new Field(Color.WHITE);
        fields[11][9] = new Field(Color.WHITE);
        fields[11][10] = new Field(Color.WHITE);
        fields[11][11] = new Field(Color.BLACK);
        fields[11][12] = new Field(Color.WHITE);
        fields[11][13] = new Field(Color.WHITE);

        fields[12][1] = new Field(Color.WHITE);
        fields[12][2] = new Field(Color.BLACK);
        fields[12][3] = new Field(Color.WHITE);
        fields[12][4] = new Field(Color.WHITE);
        fields[12][5] = new Field(Color.WHITE);
        fields[12][6] = new Field(Color.WHITE);
        fields[12][7] = new Field(Color.WHITE);
        fields[12][8] = new Field(Color.WHITE);
        fields[12][9] = new Field(Color.WHITE);
        fields[12][10] = new Field(Color.WHITE);
        fields[12][11] = new Field(Color.WHITE);
        fields[12][12] = new Field(Color.BLACK);
        fields[12][13] = new Field(Color.WHITE);

        fields[13][1] = new Field(Color.BLACK);
        fields[13][2] = new Field(Color.WHITE);
        fields[13][3] = new Field(Color.WHITE);
        fields[13][4] = new Field(Color.WHITE);
        fields[13][5] = new Field(Color.WHITE);
        fields[13][6] = new Field(Color.WHITE);
        fields[13][7] = new Field(Color.WHITE);
        fields[13][8] = new Field(Color.WHITE);
        fields[13][9] = new Field(Color.WHITE);
        fields[13][10] = new Field(Color.WHITE);
        fields[13][11] = new Field(Color.WHITE);
        fields[13][12] = new Field(Color.WHITE);
        fields[13][13] = new Field(Color.BLACK);

        fields[14][4] = new Field(Color.WHITE);
        fields[14][5] = new Field(Color.WHITE);
        fields[14][6] = new Field(Color.BLACK);
        fields[14][8] = new Field(Color.BLACK);
        fields[14][9] = new Field(Color.WHITE);
        fields[14][10] = new Field(Color.WHITE);
    }
}
