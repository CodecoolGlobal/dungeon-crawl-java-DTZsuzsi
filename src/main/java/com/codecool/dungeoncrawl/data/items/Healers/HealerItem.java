package com.codecool.dungeoncrawl.data.items.Healers;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.items.ItemWithEffect;

public class HealerItem extends ItemWithEffect {
    private int healthPlus;

    public HealerItem(Cell cell, boolean isPickable, int healthPlus) {
       super(cell,isPickable);
        this.healthPlus = healthPlus;
    }

    @Override
    public void doEffect(Player player) {
        player.receiveHealth(healthPlus);
    }
}
