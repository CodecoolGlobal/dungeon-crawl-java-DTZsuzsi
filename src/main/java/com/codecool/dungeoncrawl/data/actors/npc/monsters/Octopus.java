package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;

public class Octopus extends Monsters {
    public Octopus(Cell cell) {
        super(cell,20,10);

    }



    @Override
    public String getTileName() {
        return "octopus";
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
            this.action.showGameOverPopup();
        }

        if (this.getHealth()<=0){
            enemyCell.setActor(null);
        }
    }

    @Override
    public void automaticMove() {

    }
}
