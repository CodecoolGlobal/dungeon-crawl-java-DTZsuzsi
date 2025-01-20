package com.codecool.dungeoncrawl.data.items.attacking;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.PlayerFormTypes;
import com.codecool.dungeoncrawl.data.actors.Player;

public class BigSword extends AttackerItems {
    private final static int BASIC_ATTACK_PLUS = 100;

    public BigSword(Cell cell) {
        super(cell,  BASIC_ATTACK_PLUS);
    }

    @Override
    public void doEffect(Player player) {
        super.doEffect(player);
        player.setForm(PlayerFormTypes.PLAYER_SUPERSWORD_SHIELD_HELMET);

    }

    @Override
    public String getTileName() {
        return "superSword";
    }


}
