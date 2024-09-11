package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Player;

public class GameLogic {
    private final Player player;
    private GameMap map;


    public GameLogic() {
        this.map = MapLoader.loadMap("/map.txt", this);
        this.player = new Player(new Cell(map, 5, 5, CellType.FLOOR), this);

    }

    public double getMapWidth() {
        return map.getWidth();
    }

    public double getMapHeight() {
        return map.getHeight();
    }

    public void setup() {
    }

    public Cell getCell(int x, int y) {
        return map.getCell(x, y);
    }

    public String getPlayerHealth() {
        return Integer.toString(map.getPlayer().getHealth());
    }

    public String getPlayerAttack() {
        return Integer.toString(map.getPlayer().getAttack());
    }

    public String getPlayerInventory() {
        return map.getPlayer().displayInventoryItems();
    }


    public GameMap getMap() {
        return map;
    }

    public void loadNextMap() {
        this.map = MapLoader.loadMap("/map2.txt", this);
    }
}
