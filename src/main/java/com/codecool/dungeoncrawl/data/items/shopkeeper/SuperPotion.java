package com.codecool.dungeoncrawl.data.items.shopkeeper;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;

public class SuperPotion extends ShopKeeperItems{

    private static final int BASIC_HEALTH_PLUS = 200;
    private static final int BASIC_PRICE = 100;
    private int healthPlus;

    public SuperPotion(Cell cell) {
        super(cell, BASIC_PRICE);
        this.healthPlus = BASIC_HEALTH_PLUS;
    }

    @Override
    public String getTileName() {
        return "superPotion";
    }

    @Override
    public void doEffect(Player player) {
        player.receiveHealth(healthPlus);

    }
}

