package com.codecool.dungeoncrawl.data.items.Healers;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.PLAYER_FORM_TYPES;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.items.ChangingPlayerForm;
import com.codecool.dungeoncrawl.data.items.HealthPlus;
import com.codecool.dungeoncrawl.data.items.Item;

public class Shield extends Item implements ChangingPlayerForm, HealthPlus {
    private final static int BASIC_HEALTH_PLUS = 10;
    private int healthPlus;

    public Shield(Cell cell) {
        super(cell, true);
        healthPlus = BASIC_HEALTH_PLUS;
    }

    @Override
    public void changePlayer(Player player) {
        PLAYER_FORM_TYPES form = player.getForm();
        switch (form) {
            case PLAYER_SWORD:
                player.setForm(PLAYER_FORM_TYPES.PLAYER_SHIELD_SWORD);
                break;

        }
    }

    @Override
    public void heal(Player player) {
        player.receiveHealth(healthPlus);

    }

    @Override
    public String getTileName() {
        return "shield";
    }
}
