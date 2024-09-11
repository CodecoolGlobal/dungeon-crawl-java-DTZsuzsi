package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Player extends Actor {

    private List<Item> inventory;

    public Player(Cell cell) {
        super(cell);
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

    public void displayInventoryItemsToConsole() {
        for (Item item : inventory) {
            System.out.println(item.getTileName());
        }
    }


//    public void attack(){
//        List<Cell> neighboringCells=new ArrayList<>();
//        for (int i=-1; i<=1;i++){
//            for (int j=-1; j<=1;j++){
//                Cell cell=getCell();
//                neighboringCells.add(cell.getNeighbor(i,j));
//            }
//        }
//        for (Cell cell:neighboringCells){
//            if (cell.getActor()!=null)
//        }
//    }


}
