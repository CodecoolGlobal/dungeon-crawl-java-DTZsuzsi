package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Actor;

public class Action {
   private Actor actor;
   private Cell cell;
   private GameLogic gameLogic;
    public Action(Cell cell) {
        this.cell=cell;
        this.actor = cell.getActor();
//        this.gameLogic=new GameLogic();
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

    public void changingMap(){
        gameLogic.loadNextMap();
    }

    public void meetingYoda(){
        actor.setHealth(actor.getHealth()+5);
    }
}
