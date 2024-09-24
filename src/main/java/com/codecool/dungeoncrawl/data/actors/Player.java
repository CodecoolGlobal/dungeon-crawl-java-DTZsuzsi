package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.Inventory;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Player extends Actor {

    private Inventory inventory;

    public Player(Cell cell) {
        super(cell, 10, 5);
        inventory = new Inventory();
    }

    public String getTileName() {
        return "player";
    }



    public Inventory getInventory() {
        return inventory;
    }



    public void receiveHealth(int healthPlus) {
        this.health += healthPlus;
    }

    public void move(int dx, int dy) {

        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.getActor() != null) {
            action.meetingOtherActor(nextCell);
        }

        if (nextCell.isWalkable()) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;

            action.pickUpItem(this);

        }
    }

    public boolean hasKey() {
        boolean result = inventory.getItems().stream().filter(item -> item.getTileName().equals("key")).findAny().isPresent();
        return result;
    }


    public void receiveAttackPlus(int attackPlus){
        this.attack+=attackPlus;
    }
}
