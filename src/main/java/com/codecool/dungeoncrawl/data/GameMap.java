package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Player;

import java.util.ArrayList;
import java.util.List;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;

    private Player player;
    private List<Actor> actors;
    private List<Cell> cellsList;

    public Cell[][] getCells() {
        return cells;
    }

    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        this.cellsList=new ArrayList<>();
        this.actors=new ArrayList<>();
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultCellType);
                cellsList.add(cells[x][y]);
            }
        }
    }

    public List<Actor> getActors() {

        for (Cell cell: cellsList) {
            if (cell.getActor()!=null) {
                actors.add(cell.getActor());
            };
        }
        return actors;
    }
    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isPlayerOnStairs(){
        if (player.getCell().getType()==CellType.STAIRS)
            return true;
        else{return false;}
    }
}
