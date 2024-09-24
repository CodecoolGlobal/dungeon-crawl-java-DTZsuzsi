package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Player extends Actor {

    private List<Item> inventory;

    public Player(Cell cell) {
        super(cell, 10, 5);
        inventory = new ArrayList<>();
    }


    public String getTileName() {
        return "player";
    }

    public void addPickedUpItem(Item item) {
        inventory.add(item);
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public String displayInventoryItems() {
        StringBuilder inventoryString = new StringBuilder();
        for (Item item : inventory) {
            inventoryString.append(" ").append(item.getTileName()).append("\n");
        }
        return inventoryString.toString();
    }

    public boolean isItemInInventory(Item item) {
        return inventory.contains(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
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

            action.findADoor(nextCell);
            action.pickUpItem(this);

        }
    }

    public boolean hasKey() {
        boolean result = inventory.stream().filter(item -> item.getTileName().equals("key")).findAny().isPresent();
        System.out.println(result);
        return result;
    }

    public List<Item> getItems() {
        return inventory;
    }

    public void receiveAttackPlus(int attackPlus){
        this.attack+=attackPlus;
    }
}
