package domain;

import java.util.ArrayList;
import java.util.List;

public class GameInventory {

    private List<Tile> Tiles;

    public GameInventory() {
        this.Tiles = new ArrayList<Tile>(121);
        setTileValues();
    }

    public void setTileValues() {
        for (int i = 0; i < 21; i++) {
            this.Tiles.add(new Tile(1));
        }
        for (int i = 21; i < 41; i++) {
            this.Tiles.add(new Tile(2));
        }
        for (int i = 41; i < 61; i++) {
            this.Tiles.add(new Tile(3));
        }
        for (int i = 61; i < 81; i++) {
            this.Tiles.add(new Tile(4));
        }
        for (int i = 81; i < 101; i++) {
            this.Tiles.add(new Tile(5));
        }
        for (int i = 101; i < 121; i++) {
            this.Tiles.add(new Tile(6));
        }
    }

    public List<Tile> getTiles() {
        return Tiles;
    }
}
