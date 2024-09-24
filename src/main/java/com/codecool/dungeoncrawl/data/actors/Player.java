package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.npc.allies.Friend;
import com.codecool.dungeoncrawl.data.items.Inventory;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Player extends Actor {

    private Inventory inventory;
    private Friend friend;
    private final static int BASIC_HEALTH=10;
    private final static int BASIC_ATTACK=5;


    public Player(Cell cell) {
        super(cell, BASIC_HEALTH, BASIC_ATTACK);
        inventory = new Inventory();
        this.friend = null;

    }

    public String getTileName() {
        return "player";
    }



    public Inventory getInventory() {
        return inventory;
    }



    public void receiveHealth(int healthPlus) {
        this.health += healthPlus;
    }

    public void move(int dx, int dy) {

        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.getActor() != null) {
            action.meetingOtherActor(nextCell);
        }

        if (nextCell.isWalkable()) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;

            action.pickUpItem(this);

            if (friend != null) {

                friend.follow(this, dx, dy);
            }
        }
    }

    public boolean hasKey() {
        boolean result = inventory.getItems().stream().filter(item -> item.getTileName().equals("key")).findAny().isPresent();
        return result;
    }


    public void receiveAttackPlus(int attackPlus){
        this.attack+=attackPlus;
    }

    public void meetFriend(Friend friend) {
        this.friend = friend;
    }

    public Friend getFriend(){
        return friend;
    }
}
