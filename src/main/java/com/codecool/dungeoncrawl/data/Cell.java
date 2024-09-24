package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.npc.NPC;
import com.codecool.dungeoncrawl.data.items.Item;

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

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Actor getActor() {
        return actor;
    }
    public NPC getNPC() {
        return (NPC) actor;
    }

    public Cell getNeighbor(int dx, int dy) {
        return gameMap.getCell(x + dx, y + dy);
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


public boolean isWalkable(){
        return this.isWalkable=type.isWalkable()&&
                actor==null;
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
}
