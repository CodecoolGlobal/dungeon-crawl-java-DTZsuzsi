package com.codecool.dungeoncrawl.data.items.shopkeeper;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;

public class Necklace extends ShopKeeperItems  {
    private static final int BASIC_PRICE = 1000;


    public Necklace(Cell cell) {

        super(cell, BASIC_PRICE);
    }

    @Override
    public String getTileName() {
        return "necklace press N to use";
    }


    @Override
    public void doEffect(Player player) {
     Cell stairsCell=player.getCell().getGameMap().getStairPlace();
     player.setCell(stairsCell);
     player.getInventory().removeItem(this);
    }
}
