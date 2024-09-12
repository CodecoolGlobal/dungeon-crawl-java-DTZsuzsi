package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Actor;
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
    public abstract void interact(Player player);

    public void monsterMove(int dx, int dy){

        Cell nextCell = getCell().getNeighbor(dx, dy);
        Cell currentCell = getCell();
        if (nextCell.getActor() instanceof Player){
            interact((Player) nextCell.getActor());
        }
        if (checkIfYouCanMoveToNextCell(dx,dy)){
            currentCell.setActor(null);
            nextCell.setActor(this);
            this.setCell(nextCell);
        }
    }
    public abstract void automaticMove();




}