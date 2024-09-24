package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;

public class Potion extends Item implements HealthPlus{
    private int healthPlus;
    private int BASIC_HEALTH_PLUS=10;

    public Potion(Cell cell, boolean isPickable) {
        super(cell, false);
        this.healthPlus = BASIC_HEALTH_PLUS;
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
