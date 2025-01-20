package com.codecool.dungeoncrawl.data.items.Healers;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.PlayerFormTypes;
import com.codecool.dungeoncrawl.data.actors.Player;

public class Helmet extends HealerItem
{
    private final static int BASIC_HEALTH_PLUS = 20;

    public Helmet(Cell cell) {
        super(cell, true, BASIC_HEALTH_PLUS);
    }

    @Override
    public String getTileName() {
        return "helmet";
    }

    @Override
    public void doEffect(Player player) {
    super.doEffect(player);
        PlayerFormTypes playerType = player.getForm();
        switch (playerType) {
            case PLAYER_BASIC:
                player.setForm(PlayerFormTypes.PLAYER_HELMET);
                break;
            case PLAYER_SHIELD_SWORD:
                player.setForm(PlayerFormTypes.PLAYER_SWORD_SHIELD_HELMET);
                break;
            case PLAYER_SWORD:
                player.setForm(PlayerFormTypes.PLAYER_SHIELD_SWORD);
                break;
        }
    }
}
