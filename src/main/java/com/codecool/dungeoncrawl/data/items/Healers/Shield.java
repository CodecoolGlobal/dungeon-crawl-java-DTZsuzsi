package com.codecool.dungeoncrawl.data.items.Healers;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.PlayerFormTypes;
import com.codecool.dungeoncrawl.data.actors.Player;

public class Shield extends HealerItem {
    private final static int BASIC_HEALTH_PLUS = 10;

    public Shield(Cell cell) {
        super(cell, true, BASIC_HEALTH_PLUS);
    }

    @Override
    public void doEffect(Player player) {
        super.doEffect(player);
        PlayerFormTypes form = player.getForm();
        switch (form) {
            case PLAYER_SWORD:
                player.setForm(PlayerFormTypes.PLAYER_SHIELD_SWORD);
                break;
        }
    }

    @Override
    public String getTileName() {
        return "shield";
    }
}
