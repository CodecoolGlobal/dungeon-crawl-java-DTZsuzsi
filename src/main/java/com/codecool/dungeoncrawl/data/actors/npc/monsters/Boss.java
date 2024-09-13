package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;

public class Boss extends Monsters {
    public Boss(Cell cell) {
        super(cell, 250, 158);
    }

    @Override
    public  void interact(Player player){

        while (health >= 0 && player.getHealth() >= 0) {
            this.setHealth(health-player.getAttack());
            player.setHealth(player.getHealth()-attack);

        }
        if (player.getHealth() <= 0) {
            this.action.showPopup("Game over", "Sorry, you've died! Game over!");
        }

        if (this.getHealth() <= 0) {
            this.getCell().setActor(null);
            action.showPopup("Winning", "Congratulations! You won!");

        }
    }



    @Override
    public void automaticMove() {

    }

    @Override
    public String getTileName() {
        return "boss";
    }


}
