package domain;

public class GameInventory {

    private final Tile[] Tiles = new Tile[121];
    /*private final Tile[] twoTiles = new Tile[20];
    private final Tile[] threeTiles = new Tile[20];
    private final Tile[] fourTiles = new Tile[20];
    private final Tile[] fiveTiles = new Tile[20];
    private final Tile[] sixTiles = new Tile[20];*/

    public GameInventory(Game game) {
        setTileValues();
    }

    public void setTileValues() {
        for (int i = 0; i < 21; i++) {
            this.Tiles[i].setValue(1);
        }
        for (int i = 21; i < 41; i++) {
            this.Tiles[i].setValue(2);
        }
        for (int i = 41; i < 61; i++) {
            this.Tiles[i].setValue(3);
        }
        for (int i = 61; i < 81; i++) {
            this.Tiles[i].setValue(4);
        }
        for (int i = 81; i < 101; i++) {
            this.Tiles[i].setValue(5);
        }
        for (int i = 101; i < 121; i++) {
            this.Tiles[i].setValue(6);
        }
    }


}
