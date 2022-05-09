package domain;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {
    private List<ScoreRow> scoreRows;

    public ScoreBoard() {
        scoreRows = new ArrayList<>();
    }

    public int getTotalScore()
    {
        int totalScore = 0;

        for (ScoreRow scoreRow: scoreRows) {
            totalScore += scoreRow.getTotal();
        }

        return totalScore;
    }

    public List<ScoreRow> getScoreRows()  {
        return this.scoreRows;
    }

    public void addScores(int amountTenScores, int amountElevenScores, int amountTwelveScores, int amountDoubleScores) {
        if (scoreRows.size() == 0) {
            this.scoreRows.add(new ScoreRow(false, false, false, getBonusPoints(), false));
        }

        boolean match = false;
        // add Ten Scores
        for (int x = amountTenScores; x > 0; x--) {
            match = false;
            for (ScoreRow scoreRow: scoreRows) {
                if (!scoreRow.isTenScore()) {
                    scoreRow.setTenScore(true);
                    match = true;
                    break;
                }
            }

            if (!match) {
                this.scoreRows.add(new ScoreRow(true, false, false, getBonusPoints(), false));
            }
        }

        // add eleven scores
        for (int x = amountElevenScores; x > 0; x--) {
            match = false;
            for (ScoreRow scoreRow: scoreRows) {
                if (!scoreRow.isElevenScore()) {
                    scoreRow.setElevenScore(true);
                    match = true;
                    break;
                }
            }

            if (!match) {
                this.scoreRows.add(new ScoreRow(false, true, false, getBonusPoints(), false));
            }
        }
        // add twelve scores

        for (int x = amountTwelveScores; x > 0; x--) {
            match = false;
            for (ScoreRow scoreRow: scoreRows) {
                if (!scoreRow.isTwelveScore()) {
                    scoreRow.setTwelveScore(true);
                    match = true;
                    break;
                }
            }

            if (!match) {
                this.scoreRows.add(new ScoreRow(false, false, true, getBonusPoints(), false));
            }
        }

        // add doublescores
        for (int x = amountDoubleScores; x > 0; x--) {
            match = false;
            for (ScoreRow scoreRow: scoreRows) {
                if (!scoreRow.isTenScore()) {
                    scoreRow.setTenScore(true);
                    match = true;
                    break;
                }
            }

            if (!match) {
                this.scoreRows.add(new ScoreRow(false, false, false, getBonusPoints(), true));
            }
        }
    }

    private int getBonusPoints() {
        return switch (scoreRows.size()) {
            case 0, 1, 2, 3 -> 3;
            case 4, 5, 6, 7 -> 4;
            case 8, 9, 10, 11 -> 5;
            case 12, 13, 14, 15 -> 6;
            default -> 0;
        };
    }
}
