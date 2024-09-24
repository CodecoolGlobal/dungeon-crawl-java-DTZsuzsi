package com.codecool.dungeoncrawl.data.actors.npc.allies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Follow;
import com.codecool.dungeoncrawl.data.actors.Player;

import java.util.List;

public class Friend extends Ally implements Follow {
    private static final int BASIC_HEALTHPLUS = 5;
    private static final int BASIC_HEALTH = 100;
    private static final int BASIC_ATTACK = 0;
    private int healthPlus;
    private String message;
    private String BASIC_MESSAGE="Hi. I'm Momo. Here is a fruit to heal";

    public Friend(Cell cell) {
        super(cell, BASIC_HEALTH, BASIC_ATTACK);
        this.healthPlus = BASIC_HEALTHPLUS;
        this.message = BASIC_MESSAGE;
    }

    @Override
    public void interact(Player player) {
        if (isPlayerNext(player)) {
            player.meetFriend(this);
            System.out.println("hi hero");

            player.receiveHealth(healthPlus);
        }
    }

    public boolean isPlayerNext(Player player) {
        Cell currentCell = getCell();
        List<Cell> neighbors = currentCell.getNeighbors();

        boolean isPlayerThere = neighbors.stream().filter(cell -> cell.getActor() != null && cell.getActor().equals(player)).findAny().isPresent();
        return isPlayerThere;
    }


    @Override
    public void follow(Player player, int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.isWalkable() && nextCell.getActor() != player) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }

    @Override
    public String getTileName() {
        return "friend";
    }

    public String getMessage() {
        return message;
    }
}


