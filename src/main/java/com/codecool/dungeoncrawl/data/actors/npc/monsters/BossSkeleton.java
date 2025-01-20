package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;

import java.util.Random;

public class BossSkeleton extends Monsters {
    private static final int BASIC_HEALTH = 3;
    private static final int BASIC_ATTACK = 3;
    private static final int BASIC_MOVE = 1;

    public BossSkeleton(Cell cell) {
        super(cell, BASIC_HEALTH, BASIC_ATTACK, BASIC_MOVE,BASIC_MOVE);
    }

    @Override
    public void automaticMove() {
        super.automaticMove();

    }

    @Override
    public void interact(Player player) {

        while (health >= 0 && player.getHealth() >= 0) {
            this.setHealth(health - player.getAttack());
            player.setHealth(player.getHealth() - attack);

        }
        if (player.getHealth() <= 0) {
            cell.setActor(null);
        }

        if (this.getHealth() <= 0) {
            this.setHealth(3);
            Cell nextCell = cell.getNeighbor(1, 0);
            new BossSkeleton(nextCell);

        }
    }

    @Override
    public String getTileName() {
        return "bossSkeleton";
    }
}
