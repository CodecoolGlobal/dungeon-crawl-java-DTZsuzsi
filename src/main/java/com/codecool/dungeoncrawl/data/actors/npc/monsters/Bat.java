package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;

public  class Bat extends Monsters {
    public Bat(Cell cell) {
        super(cell,3,1);

    }



    @Override
    public String getTileName() {
        return "bat";
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



