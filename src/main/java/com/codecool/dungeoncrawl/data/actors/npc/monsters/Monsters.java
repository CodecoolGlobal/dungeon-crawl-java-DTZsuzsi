package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Interaction;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.npc.NPC;

public abstract class Monsters extends NPC implements Interaction {

    public Monsters(Cell cell, int health, int attack) {
        super(cell, health, attack);
    }

    @Override
    public String getTileName() {
        return "";
    }

    @Override
    public void interact(Player player) {
        while (health >= 0 && player.getHealth() >= 0) {
            this.setHealth(health - player.getAttack());
            player.setHealth(player.getHealth() - attack);
        }
        if (player.getHealth() <= 0) {
            this.action.showPopup("Game over", "Sorry, you've died! Game over!");
        }
        if (health <= 0) {
            cell.setActor(null);
        }
    }

    public void monsterMove(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.getActor() instanceof Player) {
            interact((Player) nextCell.getActor());
        }
        if (nextCell.isWalkable()) {
            cell.setActor(null);
            nextCell.setActor(this);
            this.setCell(nextCell);
        }
    }

    public abstract void automaticMove();


}