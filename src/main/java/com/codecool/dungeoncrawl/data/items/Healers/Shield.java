package com.codecool.dungeoncrawl.data.items.Healers;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.PLAYER_FORM_TYPES;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.items.ChangingPlayerForm;
import com.codecool.dungeoncrawl.data.items.Item;

public class Shield extends HealerItem {
    private final static int BASIC_HEALTH_PLUS = 10;

    public Shield(Cell cell) {
        super(cell, true, BASIC_HEALTH_PLUS);
    }

    @Override
    public void doEffect(Player player) {
        super.doEffect(player);
        PLAYER_FORM_TYPES form = player.getForm();
        switch (form) {
            case PLAYER_SWORD:
                player.setForm(PLAYER_FORM_TYPES.PLAYER_SHIELD_SWORD);
                break;
        }
    }

    @Override
    public String getTileName() {
        return "shield";
    }
}
