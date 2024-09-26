package com.codecool.dungeoncrawl.data.items.Healers;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.items.shopkeeper.ShopKeeperItems;

public class SuperPotion extends ShopKeeperItems implements HealthPlus {
    private static final int BASIC_HEALTH_PLUS = 200;
    private static final int BASIC_PRICE = 100;
    private int healthPlus;

    public SuperPotion(boolean isPickable) {
        super(false, BASIC_PRICE);
        healthPlus = BASIC_HEALTH_PLUS;
    }

    public SuperPotion(Cell cell) {
        super(cell);
    }


    @Override
    public String getTileName() {
        return "superPotion";
    }

    @Override
    public void heal(Player player) {
        player.receiveHealth(healthPlus);

    }
}
