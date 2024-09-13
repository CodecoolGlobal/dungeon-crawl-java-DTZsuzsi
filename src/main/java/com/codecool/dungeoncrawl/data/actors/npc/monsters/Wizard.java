package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;

import java.util.Random;

public class Wizard extends Monsters {
    public Wizard(Cell cell, int health, int attack) {
        super(cell, health, attack);
    }

    @Override
    public String getTileName() {
        return "wizard";
    }

//    @Override
//    public void interact(Player player) {
//        while(this.getHealth()>=0&&player.getHealth()>=0){
//            this.setHealth(this.getHealth()-player.getAttack());
//            player.setHealth(player.getHealth()-this.getAttack());
//        }
//        if (player.getHealth()<=0){
//            this.action.showPopup("Game over", "Sorry, you've died! Game over!");        }
//
//        if (this.getHealth()<=0){
//            this.getCell().setActor(null);
//
//        }
//    }

    @Override
    public void automaticMove() {
        if (this.getHealth()>=0){
        Random random = new Random();
        this.monsterMove(random.nextInt(3) - 1, 0);}
    }
}
