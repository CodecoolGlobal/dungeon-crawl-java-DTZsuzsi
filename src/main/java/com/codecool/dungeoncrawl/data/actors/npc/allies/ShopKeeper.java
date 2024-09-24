package com.codecool.dungeoncrawl.data.actors.npc.allies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.items.Inventory;

public class ShopKeeper extends Ally {
    private Inventory inventory;
    private final static int BASIC_HEALTH = 25;
    private final static int BASIC_ATTACK = 0;
    public ShopKeeper(Cell cell) {
        super(cell, BASIC_HEALTH, BASIC_ATTACK);
    }

    @Override
    public String getTileName() {
        return "shopKeeper";
    }

    @Override
    public void interact(Player player) {

    }


}
