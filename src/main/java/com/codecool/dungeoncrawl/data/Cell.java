package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Follow;
import com.codecool.dungeoncrawl.data.actors.npc.NPC;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cell implements Drawable {
    private CellType type;
    private Actor actor;
    private GameMap gameMap;
    private int x, y;

    private Item item;
    private boolean isWalkable;

    public Cell(GameMap gameMap, int x, int y, CellType type) {
        this.gameMap = gameMap;
        this.x = x;
        this.y = y;
        this.type = type;
        this.isWalkable = type.isWalkable();
    }

    public CellType getType() {
        return type;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Cell getNeighbor(int dx, int dy) {
        return gameMap.getCell(x + dx, y + dy);
    }

    public List<Cell> getNeighbors() {
        List<Cell> neighbors = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                neighbors.add(this.getNeighbor(i, j));
            }
        }
        return neighbors;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String getTileName() {
        if (actor != null) {
            return actor.getTileName();
        } else if (item != null) {
            return item.getTileName();
        } else {
            return type.getTileName();
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public GameMap getMap() {
        return gameMap;
    }

    public boolean isWalkable() {
        if (this.isWalkable == type.isWalkable() &&
                actor instanceof Follow) {
            return true;
        } else if (this.isWalkable = type.isWalkable() && actor == null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return x == cell.x && y == cell.y && type == cell.type && Objects.equals(actor, cell.actor) && Objects.equals(gameMap, cell.gameMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, actor, gameMap, x, y);
    }

    public GameMap getGameMap() {
        return gameMap;
    }
}
