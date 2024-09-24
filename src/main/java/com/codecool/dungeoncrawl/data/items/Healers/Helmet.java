package com.codecool.dungeoncrawl.data.items.Healers;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.PLAYER_FORM_TYPES;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.items.ChangingPlayerForm;
import com.codecool.dungeoncrawl.data.items.HealthPlus;
import com.codecool.dungeoncrawl.data.items.Item;

public class Helmet extends Item implements HealthPlus, ChangingPlayerForm {
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

    @Override
    public void changePlayer(Player player) {
        PLAYER_FORM_TYPES playerType=player.getForm();
        switch (playerType) {
            case PLAYER_BASIC:
                player.setForm(PLAYER_FORM_TYPES.PLAYER_HELMET);
                break;
            case PLAYER_SHIELD_SWORD:
                player.setForm(PLAYER_FORM_TYPES.PLAYER_SWORD_SHIELD_HELMET);
                break;
            case PLAYER_SWORD:
                player.setForm(PLAYER_FORM_TYPES.PLAYER_SHIELD_SWORD);
                break;
        }
    }
}
