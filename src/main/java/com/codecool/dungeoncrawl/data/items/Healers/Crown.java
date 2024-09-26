package com.codecool.dungeoncrawl.data.items.Healers;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.PLAYER_FORM_TYPES;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.items.ChangingPlayerForm;
import com.codecool.dungeoncrawl.data.items.Item;

public class Crown extends Item implements HealthPlus, ChangingPlayerForm {
    private final static int BASIC_HEALTH_PLUS = 100;
    private int healthPlus;

    public Crown(Cell cell, boolean isPickable) {
        super(cell, isPickable);
        healthPlus = BASIC_HEALTH_PLUS;
    }

    public Crown() {
    }

    public Crown(Cell cell) {
    }

    @Override
    public String getTileName() {
        return "crown";
    }

    @Override
    public void heal(Player player) {
        player.receiveHealth(healthPlus);
    }

    @Override
    public void changePlayer(Player player) {
        player.setForm(PLAYER_FORM_TYPES.PLAYER_SUPER);
    }
}
