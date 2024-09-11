package com.codecool.dungeoncrawl.data.actors;
import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.logic.Game;
import com.codecool.dungeoncrawl.logic.GameLogic;

import java.util.ArrayList;
import java.util.List;

public class Player extends Actor {

    private List<Item> inventory;

    public Player(Cell cell, GameLogic gameLogic) {
        super(cell,10,5,gameLogic );
        inventory = new ArrayList<>();
    }

    @Override
    public void automaticMove() {
        move(0,0);
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

    public void displayInventoryItemsToConsole() {
        for (Item item : inventory) {
            System.out.println(item.getTileName());
        }
    }
}
