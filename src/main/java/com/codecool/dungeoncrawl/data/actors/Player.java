package com.codecool.dungeoncrawl.data.actors;
import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.items.Item;
import com.codecool.dungeoncrawl.data.items.Key;

import java.util.ArrayList;
import java.util.List;

public class Player extends Actor {

    private List<Item> inventory;

    public Player(Cell cell) {
        super(cell,10,5);
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

    @Override
    public boolean checkIfYouCanMoveToNextCell(int dx, int dy) {
        if (!super.checkIfYouCanMoveToNextCell(dx, dy)) {
            return false;
        }
        Cell nextCell = getCell().getNeighbor(dx, dy);
        if (nextCell.hasDoor()) {
            Key key = new Key();
            if (!isItemInInventory(key)) {
                return false;
            }
        }
        return true;
    }
}
