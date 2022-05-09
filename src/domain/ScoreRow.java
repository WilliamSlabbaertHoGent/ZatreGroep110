package domain;

public class ScoreRow {
    private boolean tenScore;
    private boolean elevenScore;
    private boolean twelveScore;
    private int bonus;
    private boolean doubleBonus;
    private int totalBonusScore;
    private int orderCount;

    public ScoreRow(boolean tenScore, boolean elevenScore, boolean twelveScore, int bonus, boolean doubleBonus) {
        setTenScore(tenScore);
        setElevenScore(elevenScore);
        setTwelveScore(twelveScore);
        setBonus(bonus);
        setDoubleBonus(doubleBonus);
    }


    public int getTotal(){
        int sum = 0;

        if (isTenScore()) {
            sum += 1;
        }

        if (isElevenScore()) {
            sum += 2;
        }

        if (isTwelveScore()) {
            sum += 4;
        }

        sum += bonus;

        if (doubleBonus) {
            sum *= 2;
        }

        return sum;
    }

    public boolean isTenScore() {
        return tenScore;
    }

    public void setTenScore(boolean tenScore) {
        this.tenScore = tenScore;
    }

    public boolean isElevenScore() {
        return elevenScore;
    }

    public void setElevenScore(boolean elevenScore) {
        this.elevenScore = elevenScore;
    }

    public boolean isTwelveScore() {
        return twelveScore;
    }

    public void setTwelveScore(boolean twelveScore) {
        this.twelveScore = twelveScore;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public boolean isDoubleBonus() {
        return doubleBonus;
    }

    public void setDoubleBonus(boolean doubleBonus) {
        this.doubleBonus = doubleBonus;
    }

    public int getTotalBonusScore() {
        return totalBonusScore;
    }

    public void setTotalBonusScore(int totalBonusScore) {
        this.totalBonusScore = totalBonusScore;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }
}


