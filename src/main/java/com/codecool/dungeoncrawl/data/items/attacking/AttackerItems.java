package com.codecool.dungeoncrawl.data.items.attacking;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.items.Item;
import com.codecool.dungeoncrawl.data.items.ItemWithEffect;

public class AttackerItems extends ItemWithEffect {
    protected int attackPlus;
    public AttackerItems(Cell cell, int attackPlus) {
        super(cell, true);
        this.attackPlus=attackPlus;
    }



    @Override
    public void doEffect(Player player) {
        player.receiveAttackPlus(attackPlus);
    }
}
