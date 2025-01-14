package com.codecool.dungeoncrawl.data.items.attacking;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.PLAYER_FORM_TYPES;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.items.ChangingPlayerForm;
import com.codecool.dungeoncrawl.data.items.Item;

public class Mace extends AttackerItems {
    private static final int BASIC_ATTACK_PLUS = 20;

    public Mace(Cell cell) {
        super(cell,  BASIC_ATTACK_PLUS);
    }

    @Override
    public String getTileName() {
        return "mace";
    }


    @Override
    public void doEffect(Player player) {
        super.doEffect(player);
        PLAYER_FORM_TYPES playerForm = player.getForm();
        switch (playerForm) {
            case PLAYER_BASIC:
                player.setForm(PLAYER_FORM_TYPES.PLAYER_SWORD);
                System.out.println("oh, a sword");
                break;
            case PLAYER_HELMET:
                player.setForm(PLAYER_FORM_TYPES.PLAYER_SHIELD_SWORD);
                break;
            case PLAYER_SHIELD_SWORD:
                player.setForm(PLAYER_FORM_TYPES.PLAYER_SWORD_SHIELD_HELMET);
                break;
        }
    }
}
