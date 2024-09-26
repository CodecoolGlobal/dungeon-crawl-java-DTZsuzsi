package com.codecool.dungeoncrawl.data.items.Healers;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.items.Item;

public class Potion extends Item implements HealthPlus {
    protected int healthPlus;
    private int BASIC_HEALTH_PLUS = 10;

    public Potion(Cell cell, boolean isPickable) {
        super(cell, false);
        this.healthPlus = BASIC_HEALTH_PLUS;
    }

    public Potion(boolean isPickable) {
        super(false);
    }

    @Override
    public String getTileName() {
        return "potion";
    }

    @Override
    public void heal(Player player) {
        player.receiveHealth(healthPlus);
    }
}
