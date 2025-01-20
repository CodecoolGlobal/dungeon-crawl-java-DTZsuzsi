package com.codecool.dungeoncrawl.data.items.attacking;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.PlayerFormTypes;
import com.codecool.dungeoncrawl.data.actors.Player;

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
        PlayerFormTypes playerForm = player.getForm();
        switch (playerForm) {
            case PLAYER_BASIC:
                player.setForm(PlayerFormTypes.PLAYER_SWORD);
                System.out.println("oh, a sword");
                break;
            case PLAYER_HELMET:
                player.setForm(PlayerFormTypes.PLAYER_SHIELD_SWORD);
                break;
            case PLAYER_SHIELD_SWORD:
                player.setForm(PlayerFormTypes.PLAYER_SWORD_SHIELD_HELMET);
                break;
        }
    }
}
