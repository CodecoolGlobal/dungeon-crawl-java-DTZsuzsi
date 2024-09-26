package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.ArrayList;
import java.util.List;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;

    private Player player;
    private List<Actor> actors;
    private List<Cell> cellsList;

    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        this.cellsList = new ArrayList<>();
        this.actors = new ArrayList<>();
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultCellType);
                cellsList.add(cells[x][y]);
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public List<Actor> getActors() {

        for (Cell cell : cellsList) {
            if (cell.getActor() != null) {
                actors.add(cell.getActor());
            }
            ;
        }
        return actors;
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isPlayerOnStairs() {
        return player.getCell().getType() == CellType.STAIRS;
    }

    public boolean isPlayerOnSaveTile() {
        return player.getCell().getType() == CellType.SAVE_GAME;
    }

    public boolean isPlayerOnLoadTile() {
        return player.getCell().getType() == CellType.LOAD_GAME;
    }

    public boolean isPlayerNextClosedDoor() {
        List<Cell> neighbors = player.getCell().getNeighbors();
        for (Cell cell : neighbors) {
            if (cell.getType() == CellType.CLOSED_DOOR) {
                System.out.println("hi door");
                return true;
            }
        }

        return false;
    }

    public Cell getStairPlace() {
        System.out.println("hi im here");
        return cellsList.stream().filter(cell -> cell.getType().equals(CellType.STAIRS)).findFirst().get();

    }

    public void nextToDoor() {
        List<Item> inventory = player.getInventory().getItems();
        Item key = null;
        if (player.hasKey()) {
            List<Cell> neighbors = player.getCell().getNeighbors();
            for (Cell cell : neighbors) {
                if (cell.getType().equals(CellType.CLOSED_DOOR)) {
                    cell.setType(CellType.OPEN_DOOR);

                }
            }
            key = inventory.stream().filter(item -> item.getTileName() == "key").findFirst().get();
        }
        player.getInventory().removeItem(key);
    }
}
