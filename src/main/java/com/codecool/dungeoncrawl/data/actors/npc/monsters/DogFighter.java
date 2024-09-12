package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;

public class DogFighter extends Monsters {
    public DogFighter(Cell cell) {
        super(cell,8,5);

    }



    @Override
    public String getTileName() {
        return "dogFighter";
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
}
