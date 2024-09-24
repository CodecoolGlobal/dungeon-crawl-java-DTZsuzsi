package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;

public class Mace extends Item implements AttackPlus{
private int attackPlus;
private static final int BASIC_ATTACK_PLUS=20;
    public Mace(Cell cell) {
        super(cell, true);
        this.attackPlus=BASIC_ATTACK_PLUS;
    }

    @Override
    public String getTileName() {
        return "mace";
    }

    @Override
    public void attackPlus(Player player) {
        player.receiveAttackPlus(attackPlus);
    }
}
