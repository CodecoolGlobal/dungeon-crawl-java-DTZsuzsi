package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;

public class Helmet extends Item implements HealthPlus {
    private int healthPlus;
    private final static int BASIC_HEALTH_PLUS=20;
    public Helmet(Cell cell) {
        super(cell, true);
        this.healthPlus = BASIC_HEALTH_PLUS;
    }

    @Override
    public String getTileName() {
        return "helmet";
    }

    @Override
    public void heal(Player player) {
        player.receiveHealth(healthPlus);

    }
}
