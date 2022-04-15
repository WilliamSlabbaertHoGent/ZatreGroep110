package domain;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class GameBord {
    private List<Box> boxes = new ArrayList<>();
    private List<Stone> placedStones = new ArrayList<>();
    private Color[][] fields = new Color[15][15];

    public GameBord(Game game) {
        setFields();
    }

    public Color[][] getFields() {
        return fields;
    }

    private void setFields() {
        fields[0][4] = Color.WHITE;
        fields[0][5] = Color.WHITE;
        fields[0][6] = Color.BLACK;
        fields[0][8] = Color.BLACK;
        fields[0][9] = Color.WHITE;
        fields[0][10] = Color.WHITE;

        fields[1][1] = Color.BLACK;
        fields[1][2] = Color.WHITE;
        fields[1][3] = Color.WHITE;
        fields[1][4] = Color.WHITE;
        fields[1][5] = Color.WHITE;
        fields[1][6] = Color.WHITE;
        fields[1][7] = Color.WHITE;
        fields[1][8] = Color.WHITE;
        fields[1][9] = Color.WHITE;
        fields[1][10] = Color.WHITE;
        fields[1][11] = Color.WHITE;
        fields[1][12] = Color.WHITE;
        fields[1][13] = Color.BLACK;

        fields[2][1] = Color.WHITE;
        fields[2][2] = Color.BLACK;
        fields[2][3] = Color.WHITE;
        fields[2][4] = Color.WHITE;
        fields[2][5] = Color.WHITE;
        fields[2][6] = Color.WHITE;
        fields[2][7] = Color.WHITE;
        fields[2][8] = Color.WHITE;
        fields[2][9] = Color.WHITE;
        fields[2][10] = Color.WHITE;
        fields[2][11] = Color.WHITE;
        fields[2][12] = Color.BLACK;
        fields[2][13] = Color.WHITE;

        fields[3][1] = Color.WHITE;
        fields[3][2] = Color.WHITE;
        fields[3][3] = Color.BLACK;
        fields[3][4] = Color.WHITE;
        fields[3][5] = Color.WHITE;
        fields[3][6] = Color.WHITE;
        fields[3][7] = Color.WHITE;
        fields[3][8] = Color.WHITE;
        fields[3][9] = Color.WHITE;
        fields[3][10] = Color.WHITE;
        fields[3][11] = Color.BLACK;
        fields[3][12] = Color.WHITE;
        fields[3][13] = Color.WHITE;

        fields[4][0] = Color.WHITE;
        fields[4][1] = Color.WHITE;
        fields[4][2] = Color.WHITE;
        fields[4][3] = Color.WHITE;
        fields[4][4] = Color.BLACK;
        fields[4][5] = Color.WHITE;
        fields[4][6] = Color.WHITE;
        fields[4][7] = Color.WHITE;
        fields[4][8] = Color.WHITE;
        fields[4][9] = Color.WHITE;
        fields[4][10] = Color.BLACK;
        fields[4][11] = Color.WHITE;
        fields[4][12] = Color.WHITE;
        fields[4][13] = Color.WHITE;
        fields[4][14] = Color.WHITE;

        fields[5][0] = Color.WHITE;
        fields[5][1] = Color.WHITE;
        fields[5][2] = Color.WHITE;
        fields[5][3] = Color.WHITE;
        fields[5][4] = Color.WHITE;
        fields[5][5] = Color.BLACK;
        fields[5][6] = Color.WHITE;
        fields[5][7] = Color.WHITE;
        fields[5][8] = Color.WHITE;
        fields[5][9] = Color.BLACK;
        fields[5][10] = Color.WHITE;
        fields[5][11] = Color.WHITE;
        fields[5][12] = Color.WHITE;
        fields[5][13] = Color.WHITE;
        fields[5][14] = Color.WHITE;

        fields[6][0] = Color.BLACK;
        fields[6][1] = Color.WHITE;
        fields[6][2] = Color.WHITE;
        fields[6][3] = Color.WHITE;
        fields[6][4] = Color.WHITE;
        fields[6][5] = Color.WHITE;
        fields[6][6] = Color.BLACK;
        fields[6][7] = Color.WHITE;
        fields[6][8] = Color.BLACK;
        fields[6][9] = Color.WHITE;
        fields[6][10] = Color.WHITE;
        fields[6][11] = Color.WHITE;
        fields[6][12] = Color.WHITE;
        fields[6][13] = Color.WHITE;
        fields[6][14] = Color.BLACK;

        fields[7][1] = Color.WHITE;
        fields[7][2] = Color.WHITE;
        fields[7][3] = Color.WHITE;
        fields[7][4] = Color.WHITE;
        fields[7][5] = Color.WHITE;
        fields[7][6] = Color.WHITE;
        fields[7][7] = Color.BLACK;
        fields[7][8] = Color.WHITE;
        fields[7][9] = Color.WHITE;
        fields[7][10] = Color.WHITE;
        fields[7][11] = Color.WHITE;
        fields[7][12] = Color.WHITE;
        fields[7][13] = Color.WHITE;

        fields[8][0] = Color.BLACK;
        fields[8][1] = Color.WHITE;
        fields[8][2] = Color.WHITE;
        fields[8][3] = Color.WHITE;
        fields[8][4] = Color.WHITE;
        fields[8][5] = Color.WHITE;
        fields[8][6] = Color.BLACK;
        fields[8][7] = Color.WHITE;
        fields[8][8] = Color.BLACK;
        fields[8][9] = Color.WHITE;
        fields[8][10] = Color.WHITE;
        fields[8][11] = Color.WHITE;
        fields[8][12] = Color.WHITE;
        fields[8][13] = Color.WHITE;
        fields[8][14] = Color.BLACK;

        fields[9][0] = Color.WHITE;
        fields[9][1] = Color.WHITE;
        fields[9][2] = Color.WHITE;
        fields[9][3] = Color.WHITE;
        fields[9][4] = Color.WHITE;
        fields[9][5] = Color.BLACK;
        fields[9][6] = Color.WHITE;
        fields[9][7] = Color.WHITE;
        fields[9][8] = Color.WHITE;
        fields[9][9] = Color.BLACK;
        fields[9][10] = Color.WHITE;
        fields[9][11] = Color.WHITE;
        fields[9][12] = Color.WHITE;
        fields[9][13] = Color.WHITE;
        fields[9][14] = Color.WHITE;

        fields[10][0] = Color.WHITE;
        fields[10][1] = Color.WHITE;
        fields[10][2] = Color.WHITE;
        fields[10][3] = Color.WHITE;
        fields[10][4] = Color.BLACK;
        fields[10][5] = Color.WHITE;
        fields[10][6] = Color.WHITE;
        fields[10][7] = Color.WHITE;
        fields[10][8] = Color.WHITE;
        fields[10][9] = Color.WHITE;
        fields[10][10] = Color.BLACK;
        fields[10][11] = Color.WHITE;
        fields[10][12] = Color.WHITE;
        fields[10][13] = Color.WHITE;
        fields[10][14] = Color.WHITE;

        fields[11][1] = Color.WHITE;
        fields[11][2] = Color.WHITE;
        fields[11][3] = Color.BLACK;
        fields[11][4] = Color.WHITE;
        fields[11][5] = Color.WHITE;
        fields[11][6] = Color.WHITE;
        fields[11][7] = Color.WHITE;
        fields[11][8] = Color.WHITE;
        fields[11][9] = Color.WHITE;
        fields[11][10] = Color.WHITE;
        fields[11][11] = Color.BLACK;
        fields[11][12] = Color.WHITE;
        fields[11][13] = Color.WHITE;

        fields[12][1] = Color.WHITE;
        fields[12][2] = Color.BLACK;
        fields[12][3] = Color.WHITE;
        fields[12][4] = Color.WHITE;
        fields[12][5] = Color.WHITE;
        fields[12][6] = Color.WHITE;
        fields[12][7] = Color.WHITE;
        fields[12][8] = Color.WHITE;
        fields[12][9] = Color.WHITE;
        fields[12][10] = Color.WHITE;
        fields[12][11] = Color.WHITE;
        fields[12][12] = Color.BLACK;
        fields[12][13] = Color.WHITE;

        fields[13][1] = Color.BLACK;
        fields[13][2] = Color.WHITE;
        fields[13][3] = Color.WHITE;
        fields[13][4] = Color.WHITE;
        fields[13][5] = Color.WHITE;
        fields[13][6] = Color.WHITE;
        fields[13][7] = Color.WHITE;
        fields[13][8] = Color.WHITE;
        fields[13][9] = Color.WHITE;
        fields[13][10] = Color.WHITE;
        fields[13][11] = Color.WHITE;
        fields[13][12] = Color.WHITE;
        fields[13][13] = Color.BLACK;

        fields[14][4] = Color.WHITE;
        fields[14][5] = Color.WHITE;
        fields[14][6] = Color.BLACK;
        fields[14][8] = Color.BLACK;
        fields[14][9] = Color.WHITE;
        fields[14][10] = Color.WHITE;
    }
}
