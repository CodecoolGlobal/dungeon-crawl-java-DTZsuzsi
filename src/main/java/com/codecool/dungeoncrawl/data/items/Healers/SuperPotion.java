package com.codecool.dungeoncrawl.data.items.Healers;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.HealthPlus;

public class SuperPotion extends Potion  {
private static final int BASIC_HEALTH_PLUS=200;
    public SuperPotion(Cell cell, boolean isPickable) {
        super(cell, isPickable);
        super.healthPlus = BASIC_HEALTH_PLUS;
    }

    public SuperPotion(boolean isPickable) {
        super(false);

    }

    @Override
    public String getTileName() {
        return "superPotion";
    }
}
