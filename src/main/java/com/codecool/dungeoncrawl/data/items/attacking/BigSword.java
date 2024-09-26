package com.codecool.dungeoncrawl.data.items.attacking;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.PLAYER_FORM_TYPES;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.items.ChangingPlayerForm;
import com.codecool.dungeoncrawl.data.items.Item;

public class BigSword extends Item implements ChangingPlayerForm, AttackPlus {
    private final static int BASIC_ATTACK_PLUS = 100;
    private int attackPlus;

    public BigSword(Cell cell) {
        super(cell, true);
        this.attackPlus = BASIC_ATTACK_PLUS;
    }

    @Override
    public void changePlayer(Player player) {
        player.setForm(PLAYER_FORM_TYPES.PLAYER_SUPERSWORD_SHIELD_HELMET);

    }

    @Override
    public String getTileName() {
        return "superSword";
    }

    @Override
    public void attackPlus(Player player) {
        player.receiveAttackPlus(attackPlus);

    }
}
