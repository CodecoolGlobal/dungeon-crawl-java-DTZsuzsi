package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.actors.Player;

public class Skeleton extends Monsters {
    public Skeleton(Cell cell) {
        super(cell,9,4);

    }



    @Override
    public String getTileName() {
        return "skeleton";
    }

    @Override
    public void interact(Player player) {
        Cell enemyCell=this.getCell();

        while(this.getHealth()>=0&&player.getHealth()>=0){
            this.setHealth(this.getHealth()-player.getAttack());
            player.setHealth(player.getHealth()-this.getAttack());

        }
        if (player.getHealth()<=0){
            this.action.showPopup("Game over", "Sorry, you've died! Game over!");        }

        if (this.getHealth()<=0){
            enemyCell.setActor(null);
        }
    }
//TODO:implement later!
    @Override
    public void automaticMove() {
    }
}
