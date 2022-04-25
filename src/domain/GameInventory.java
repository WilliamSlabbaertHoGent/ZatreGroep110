package domain;

public class GameInventory {

    private final Tile[] oneTiles = new Tile[21];
    private final Tile[] twoTiles = new Tile[20];
    private final Tile[] threeTiles = new Tile[20];
    private final Tile[] fourTiles = new Tile[20];
    private final Tile[] fiveTiles = new Tile[20];
    private final Tile[] sixTiles = new Tile[20];

    public GameInventory(Game game) {
        setTileValues();
    }

    public void setTileValues() {
        for (int i = 0; i < this.oneTiles.length; i++) {
            this.oneTiles[i].setValue(1);
        }
        for (int i = 0; i < this.twoTiles.length; i++) {
            this.twoTiles[i].setValue(2);
        }
        for (int i = 0; i < this.threeTiles.length; i++) {
            this.threeTiles[i].setValue(3);
        }
        for (int i = 0; i < this.fourTiles.length; i++) {
            this.fourTiles[i].setValue(4);
        }
        for (int i = 0; i < this.fiveTiles.length; i++) {
            this.fiveTiles[i].setValue(5);
        }
        for (int i = 0; i < this.sixTiles.length; i++) {
            this.sixTiles[i].setValue(6);
        }
    }


}
