package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;

public class Bear extends Monsters {
    public Bear(Cell cell, int health, int attack) {
        super(cell, health, attack);
    }

    @Override
    public String getTileName() {
        return "bear";
    }

    @Override
    public void interact(Player player) {
        Cell enemyCell=this.getCell();

        while(this.getHealth()>=0&&player.getHealth()>=0){
            this.setHealth(this.getHealth()-5);
            player.setHealth(player.getHealth()-2);
            System.out.println(player.getHealth());
            System.out.println(this.getHealth());
        }
        if (player.getHealth()<=0){
            this.action.showPopup("Game over", "Sorry, you've died! Game over!");        }

        if (this.getHealth()<=0){
            enemyCell.setActor(null);
        }
    }
//TODO: implement
    @Override
    public void automaticMove() {
    }
}
