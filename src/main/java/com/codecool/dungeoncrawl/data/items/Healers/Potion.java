package com.codecool.dungeoncrawl.data.items.Healers;

import com.codecool.dungeoncrawl.data.Cell;

public class Potion extends HealerItem {
    private static int BASIC_HEALTH_PLUS = 10;

    public Potion(Cell cell) {
        super(cell, false, BASIC_HEALTH_PLUS);
    }


    @Override
    public String getTileName() {
        return "potion";
    }


}
