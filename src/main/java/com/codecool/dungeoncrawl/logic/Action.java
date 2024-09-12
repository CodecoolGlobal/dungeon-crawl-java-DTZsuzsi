package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Player;

import com.codecool.dungeoncrawl.data.items.Item;
import javafx.scene.control.Alert;
import com.codecool.dungeoncrawl.data.items.*;


public class Action {
   private Actor actor;
   private Cell cell;
   private GameLogic gameLogic;
    public Action(Cell cell, GameLogic gameLogic) {
        this.cell=cell;
        this.actor = cell.getActor();
        this.gameLogic=gameLogic;

    }


    public void pickUpItem(Player player){
        Cell currentCell = player.getCell();
        Item item = currentCell.getItem();

        if (item != null && item.isPickable()){
            if (item instanceof Mace) {
                player.setAttack(player.getAttack() + 5);
            } else if (item instanceof Helmet) {
                player.setHealth(player.getHealth() + 3);
            }
            player.addPickedUpItem(item);
            currentCell.setItem(null);
//            player.displayInventoryItems();
        }
}

    public void changingMap(){
        System.out.println("hi before");
        gameLogic.loadNextMap();
    }



    public void meetingOtherActor(Cell nextCell) {
        if (nextCell.getItem()!=null&& nextCell.getItem().getTileName()=="exitStairs"){
            System.out.println("stairs");
            changingMap();
        }

        if (actor instanceof Player && nextCell.getActor()!=null){
            Player player=(Player) actor;
            Actor otherActor=nextCell.getActor();
            otherActor.makeInteraction(player,otherActor);
        }


    }

    public void findADoor(Cell nextCell){
           if (nextCell.getItem()!=null && nextCell.getItem().getTileName().equals("door") && actor instanceof Player){
             Item key = new Key();
           Player player = (Player) actor;
         if (player.isItemInInventory(key)) {
           player.removeItem(key);
        }
        }
    }


}
