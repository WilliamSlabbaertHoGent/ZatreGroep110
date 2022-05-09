package domain;

import exceptions.InvalidTilePlacementException;
import javafx.scene.paint.Color;
import resources.Language;

import java.util.ArrayList;
import java.util.List;
import static domain.ConstantInterface.*;

public class GameBord {
    private final Field[][] fields = new Field[15][15];
    private List<Field> currentRoundPlayedFields = new ArrayList<>();
    private int amountTenScoresCurrentRound = 0;
    private int amountElevenScoresCurrentRound = 0;
    private int amountTwelveScoresCurrentRound = 0;
    private int amountDoubleScores = 0;
    private String log;

    public String getLog() {
        return log;
    }

    public GameBord() {
        setFields();
    }

    public Field[][] getFields() {
        return fields;
    }

    public int getAmountTenScoresCurrentRound() {
        return amountTenScoresCurrentRound;
    }

    public int getAmountElevenScoresCurrentRound() {
        return amountElevenScoresCurrentRound;
    }

    public int getAmountTwelveScoresCurrentRound() {
        return amountTwelveScoresCurrentRound;
    }

    public int getAmountDoubleScores() {
        return amountDoubleScores;
    }

    public void resetRound() {
        currentRoundPlayedFields.clear();
        amountTenScoresCurrentRound = 0;
        amountElevenScoresCurrentRound = 0;
        amountTwelveScoresCurrentRound = 0;
        amountDoubleScores = 0;
    }

    private void setFields() {
        for (int row = FIRST_COLUMN_ROW; row <= LAST_COLUMN_ROW; row++) {
            for (int column = FIRST_COLUMN_ROW; column <= LAST_COLUMN_ROW; column++) {
                fields[row][column] = new Field(Color.WHITE, row, column);
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
        fields[0][6] = new Field(Color.BLACK, 0, 6);
        fields[0][8] = new Field(Color.BLACK, 0, 8);

        fields[14][6] = new Field(Color.BLACK, 14, 6);
        fields[14][8] = new Field(Color.BLACK, 14, 8);

        int firstBlack = 1;
        int lastBlack = 13;

        for (int row = 1; row <= 13; row++) {
            fields[row][firstBlack] = new Field(Color.BLACK, row, firstBlack);
            fields[row][lastBlack] = new Field(Color.BLACK, row, lastBlack);

            if (row == 6 || row == 8) {
                fields[row][0] = new Field(Color.BLACK, row, 0);
                fields[row][14] = new Field(Color.BLACK, row, 14);
            }

            firstBlack++;
            lastBlack--;
        }
    }

    public final void setFieldValue(int row, int column, int value, boolean firstTurn, boolean firstStone) {
        if (firstStone) {
            if (row != 7 || column != 7) {
                throw new InvalidTilePlacementException(
                        Language.getInstance().getString(EXCEPTION_RESOURCE, "exception.firstStoneMiddle")
                );
            }
        }

        List<Field> adjacentFields = getAdjacentFields(row, column);
        List<Field> fieldsWithStones = new ArrayList<>();

        if (!firstStone) {
            boolean validField = false;
            for (Field adjacentField: adjacentFields) {
                if (adjacentField.getTileValue() != 0) {
                    fieldsWithStones.add(adjacentField);
                    validField = true;
                }
            }

            if (!validField) {
                throw new InvalidTilePlacementException(
                        Language.getInstance().getString(EXCEPTION_RESOURCE, "exception.touchOther")
                );
            }

            if (isHorizontalScoreHigherThan12(row, column, value) || isVerticalScoreHigherThan12(row, column, value)) {
                throw new InvalidTilePlacementException(
                        Language.getInstance().getString(EXCEPTION_RESOURCE, "exception.moreThanMaxScore", MAX_POINTS)
                );
            }

            if (fields[row][column].getColor() == Color.BLACK){
                if (!isBlackFieldHorizontallyAllowed(row, column, value) && !isBlackFieldVerticallyAllowed(row, column, value)) {
                    throw new InvalidTilePlacementException(
                            Language.getInstance().getString(EXCEPTION_RESOURCE, "exception.invalidBlackField", MIN_BLACK_FIELD_POINTS, MAX_POINTS)
                    );
                }
            }
        }

        // loop all fields, check if adjacent field was placed in the same turn, if not throw exception
        if (!firstTurn) {
            boolean validField = false;
            for (Field adjacentField: fieldsWithStones) {
                if (!currentRoundPlayedFields.contains(adjacentField)) {
                    validField = true;
                    break;
                }
            }

            if (!validField) {
                throw new InvalidTilePlacementException(
                        Language.getInstance().getString(EXCEPTION_RESOURCE, "exception.touchOtherNotByYourself")
                );
            }
        }

        if (fields[row][column].getColor() == Color.BLACK) {
            amountDoubleScores++;
        }

        fields[row][column].setTileValue(value);
        currentRoundPlayedFields.add(fields[row][column]);

        log = String.format(
                "Placed Stone %n" +
                        "Row: %d %n" +
                        "Column: %d %n" +
                        "HorizontalScore: %d %n" +
                        "verticalScore: %d %n",
                currentRoundPlayedFields.get(currentRoundPlayedFields.size() - 1).getRow(),
                currentRoundPlayedFields.get(currentRoundPlayedFields.size() - 1).getColumn(),
                getHorizontalScore(currentRoundPlayedFields.get(currentRoundPlayedFields.size() - 1).getRow(), currentRoundPlayedFields.get(currentRoundPlayedFields.size() - 1).getColumn()) + value,
                getVerticalScore(currentRoundPlayedFields.get(currentRoundPlayedFields.size() - 1).getRow(), currentRoundPlayedFields.get(currentRoundPlayedFields.size() - 1).getColumn()) + value
        );
    }

    public void calculateScores() {
        List<Field> checkedHorizontalFields = new ArrayList<>();
        List<Field> checkedVerticalFields = new ArrayList<>();
        boolean match;

        for (Field playedField: currentRoundPlayedFields) {
            match = false;
            // check horizontal score
            List<Field> adjacentHorizontalFields = getAllHorizontalAdjacentFields(playedField.getRow(), playedField.getColumn());
            for (Field checkedHorizontalField: checkedHorizontalFields) {
                if (adjacentHorizontalFields.contains(checkedHorizontalField)) {
                    match = true;
                    break;
                }
            }

            if (match) {
                continue;
            }

            checkedHorizontalFields.add(playedField);
            int horizontalScore = getHorizontalScore(playedField.getRow(), playedField.getColumn()) + playedField.getTileValue();

            if (horizontalScore == 10) {
                amountTenScoresCurrentRound++;
            } else if (horizontalScore == 11) {
                amountElevenScoresCurrentRound++;
            } else if (horizontalScore == 12){
                amountTwelveScoresCurrentRound++;
            }

            // check vertical score
            List<Field> adjacentVerticalFields = getAllHorizontalAdjacentFields(playedField.getRow(), playedField.getColumn());
            for (Field checkedVerticalField: checkedVerticalFields) {
                match = false;
                if (adjacentVerticalFields.contains(checkedVerticalField)) {
                    match = true;
                    break;
                }
            }

            if (match) {
                continue;
            }

            checkedVerticalFields.add(playedField);
            int verticalScore = getVerticalScore(playedField.getRow(), playedField.getColumn());

            if (verticalScore == 10) {
                amountTenScoresCurrentRound++;
            } else if (verticalScore == 11) {
                amountElevenScoresCurrentRound++;
            } else if (verticalScore == 12){
                amountTwelveScoresCurrentRound++;
            }
        }
    }

    private List<Field> getAdjacentFields(int row, int column) {
        List<Field> adjacentFields = new ArrayList<>();

        adjacentFields.add(fields[row][column - 1]); // left field
        adjacentFields.add(fields[row - 1][column - 1]); // top left field
        adjacentFields.add(fields[row - 1][column]); // top field
        adjacentFields.add(fields[row - 1][column + 1]); // top right field
        adjacentFields.add(fields[row][column + 1]); // right field
        adjacentFields.add(fields[row + 1][column + 1]); // bottom right field
        adjacentFields.add(fields[row + 1][column]); // bottom field
        adjacentFields.add(fields[row + 1][column - 1]); // bottom left field

        return adjacentFields;
    }

    private List<Field> getAllHorizontalAdjacentFields(int row, int column) {
        List<Field> horizontalAdjacentFields = new ArrayList<>();
        int previousColumn = column - 1;
        int nextColumn = column + 1;

        // get adjacent stones to the left
        for (int y = previousColumn; y >= FIRST_COLUMN_ROW; y--) {
            if (fields[row][y].getTileValue() == 0) {
                break;
            }

            horizontalAdjacentFields.add(fields[row][y]);
        }

        // get adjacent stones to the right
        for (int y = nextColumn; y <= LAST_COLUMN_ROW; y++) {
            if (fields[row][y].getTileValue() == 0) {
                break;
            }

            horizontalAdjacentFields.add(fields[row][y]);
        }


        return horizontalAdjacentFields;
    }

    private List<Field> getAllVerticalAdjacentFields(int row, int column) {
        List<Field> verticalAdjacentFields = new ArrayList<>();
        int previousRow = row - 1;
        int nexRow = row + 1;

        // get adjacent stones to the left
        for (int x = previousRow; x >= FIRST_COLUMN_ROW; x--) {
            if (fields[x][column].getTileValue() == 0) {
                break;
            }

            verticalAdjacentFields.add(fields[x][column]);
        }

        // get adjacent stones to the right
        for (int x = nexRow; x <= LAST_COLUMN_ROW; x++) {
            if (fields[x][column].getTileValue() == 0) {
                break;
            }

            verticalAdjacentFields.add(fields[x][column]);
        }


        return verticalAdjacentFields;
    }

    private int getHorizontalScore(int row, int column) {
        int sum = 0;
        List<Field> horizontalAdjacentFields = getAllHorizontalAdjacentFields(row, column);

        for (Field field: horizontalAdjacentFields) {
            sum += field.getTileValue();
        }

        return sum;
    }

    private int getVerticalScore(int row, int column) {
        int sum = 0;
        List<Field> verticalAdjacentFields = getAllVerticalAdjacentFields(row, column);

        for (Field field: verticalAdjacentFields) {
            sum += field.getTileValue();
        }

        return sum;
    }

    private boolean isHorizontalScoreHigherThan12(int row, int column , int value) {
        int sum = getHorizontalScore(row, column);
        return (sum + value) > MAX_POINTS;
    }

    private boolean isVerticalScoreHigherThan12(int row, int column, int value) {
        int sum = getVerticalScore(row, column);
        return (sum + value) > MAX_POINTS;
    }

    private boolean isBlackFieldHorizontallyAllowed(int row, int column, int value) {
        int sum = getHorizontalScore(row, column);

        return (sum + value) >= MIN_BLACK_FIELD_POINTS;
    }

    private boolean isBlackFieldVerticallyAllowed(int row, int column, int value) {
        int sum = getVerticalScore(row, column);

        return (sum + value) >= MIN_BLACK_FIELD_POINTS;
    }
}