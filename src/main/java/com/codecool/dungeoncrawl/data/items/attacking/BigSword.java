package com.codecool.dungeoncrawl.data.items.attacking;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.PLAYER_FORM_TYPES;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.items.ChangingPlayerForm;
import com.codecool.dungeoncrawl.data.items.Item;

public class BigSword extends AttackerItems {
    private final static int BASIC_ATTACK_PLUS = 100;

    public BigSword(Cell cell) {
        super(cell,  BASIC_ATTACK_PLUS);
    }

    @Override
    public void doEffect(Player player) {
        super.doEffect(player);
        player.setForm(PLAYER_FORM_TYPES.PLAYER_SUPERSWORD_SHIELD_HELMET);

    }

    @Override
    public String getTileName() {
        return "superSword";
    }


}
