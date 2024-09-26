package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.npc.allies.Ally;
import com.codecool.dungeoncrawl.data.actors.npc.allies.Friend;
import com.codecool.dungeoncrawl.data.items.Inventory;
import com.codecool.dungeoncrawl.data.items.Money;
import com.codecool.dungeoncrawl.data.items.shopkeeper.ShopKeeperItems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player extends Actor {

    private final static int BASIC_HEALTH = 10;
    private final static int BASIC_ATTACK = 5;
    private Inventory inventory;
    private Set<Ally> allies;
    private Friend friend;
    private PLAYER_FORM_TYPES form;
    private Money money;


    public Player(Cell cell) {
        super(cell, BASIC_HEALTH, BASIC_ATTACK);
        inventory = new Inventory();
        this.allies = new HashSet<>();
        this.friend = null;
        this.form = PLAYER_FORM_TYPES.PLAYER_BASIC;
        this.money = null;

    }

    public String getTileName() {
        return form.getTileName();
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public List<Cell> getNeighbourCells() {
        return this.cell.getNeighbors();
    }

    public Set<Ally> getAllies() {
        return allies;
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
//                int playerDx = cell.getX();
//                int playerDy = cell.getY();

                friend.follow(this, dx , dy);
            }
        }
    }

    public boolean hasKey() {
        boolean result = inventory.getItems().stream().filter(item -> item.getTileName().equals("key")).findAny().isPresent();
        return result;
    }


    public void receiveAttackPlus(int attackPlus) {
        this.attack += attackPlus;
    }

    public void meetFriend(Friend friend) {
        this.friend = friend;
    }

    public Friend getFriend() {
        return friend;
    }

    public void addAlly(Ally ally) {
        allies.add(ally);
    }

    public PLAYER_FORM_TYPES getForm() {
        return form;
    }

    public void setForm(PLAYER_FORM_TYPES newForm) {
        this.form = newForm;

    }

    public void setPosition(int x, int y) {
        Cell newCell = cell.getMap().getCell(x, y);
        cell.setActor(null);
        newCell.setActor(this);
        cell = newCell;
    }

    public boolean hasEnoughMoney(ShopKeeperItems item) {
        if (this.money == null) {
            return false;
        } else {
            return item.getPrice() < this.money.getAmount();
        }
    }

    public int howManyHeartHas() {
        if (health <= BASIC_HEALTH) {
            return 1;
        }
        if (health <= 30) {
            return 2;
        }
        if (health <= 50) {
            return 3;
        }
        if (health <= 100) {
            return 4;
        }
        if (health <= 300) {
            return 5;
        }
        return 0;
    }

}
