package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;

import java.util.Random;

public class Bat extends Monsters {
    public Bat(Cell cell) {
        super(cell, 3, 1);

    }

    @Override
    public String getTileName() {
        return "bat";
    }

    @Override
    public void interact(Player player) {
        Cell enemyCell = this.getCell();

        while (this.getHealth() >= 0 && player.getHealth() >= 0) {
            this.setHealth(this.getHealth() - 5);
            player.setHealth(player.getHealth() - 2);

        }
        if (player.getHealth() <= 0) {
            this.action.showPopup("Game over", "Sorry, you've died! Game over!");
        }

        if (this.getHealth() <= 0) {
            enemyCell.setActor(null);
            enemyCell.setActor(player);
        }
    }

    @Override
    public void automaticMove() {
        Random random = new Random();
        this.monsterMove(random.nextInt(3) - 1, random.nextInt(3) - 1);
    }
}



