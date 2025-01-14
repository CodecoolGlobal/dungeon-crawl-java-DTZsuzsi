package com.codecool.dungeoncrawl.data.items.Healers;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.PLAYER_FORM_TYPES;
import com.codecool.dungeoncrawl.data.actors.Player;

public class Crown extends HealerItem {
    private final static int BASIC_HEALTH_PLUS = 100;

    public Crown(Cell cell) {
        super(cell, true, BASIC_HEALTH_PLUS);
    }


    @Override
    public String getTileName() {
        return "crown";
    }


    @Override
    public void doEffect(Player player) {
        super.doEffect(player);
        player.setForm(PLAYER_FORM_TYPES.PLAYER_SUPER);
    }
}
