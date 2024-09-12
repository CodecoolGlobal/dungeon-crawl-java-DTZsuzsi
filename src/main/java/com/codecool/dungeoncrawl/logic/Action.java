package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Player;
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
    public void attack(Cell nextCell){

        Actor enemy=nextCell.getActor();


        while(enemy.getHealth()>=0&&actor.getHealth()>=0){
            enemy.setHealth(enemy.getHealth()-5);
            actor.setHealth(actor.getHealth()-2);
            System.out.println(actor.getHealth());
            System.out.println(enemy.getHealth());
        }
        if (actor.getHealth()<=0){
            System.out.println("Game over");
            System.exit(0);
        }

        if (enemy.getHealth()<=0){
           nextCell.setActor(null);
        }

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
        gameLogic.loadNextMap();
    }

    public void monsterMoving(Actor actor, int x, int y){
actor.automaticMove();
    }

    public void meetingYoda(){
        actor.setHealth(actor.getHealth()+5);
    }

    public void findingSomething(Cell nextCell) {
        if (nextCell.getActor()!=null){
            System.out.println("attack");
            if (nextCell.getActor().getTileName()=="yoda"){
                meetingYoda();
            }
            else {
                attack(nextCell);
            }
        }

        if (nextCell.getItem()!=null&& nextCell.getItem().getTileName()=="exitStairs"){
            System.out.println("stairs");
            changingMap();
        }

        if (nextCell.getItem()!=null && nextCell.getItem().getTileName().equals("door") && actor instanceof Player){
            Item key = new Key();
            Player player = (Player) actor;
            if (player.isItemInInventory(key)) {
                player.removeItem(key);
            }
        }
    }
}
