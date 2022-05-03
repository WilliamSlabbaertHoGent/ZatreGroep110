package domain;

import java.util.List;

public class ScoreBoard {
    private List<ScoreRow> scoreRows;
    private int totalScore;
    private void setTotalScore()
    {
        for(int i = 0; i<scoreRows.size();i++)
        {
            int totalrow = scoreRows.get(i).getTotal();
            totalScore += totalrow;
        }

    }
    public int getTotalScore(){return this.totalScore;}
}
