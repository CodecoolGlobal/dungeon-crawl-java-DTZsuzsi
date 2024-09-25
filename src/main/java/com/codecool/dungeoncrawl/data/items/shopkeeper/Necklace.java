package com.codecool.dungeoncrawl.data.items.shopkeeper;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.items.Item;

public class Necklace extends ShopKeeperItems implements Teleport {
    private static final int BASIC_PRICE = 1000;

    public Necklace(boolean pickable) {
        super(true, BASIC_PRICE);
    }

    @Override
    public String getTileName() {
        return "necklace press N to use";
    }


    @Override
    public void teleport(Player player) {
     Cell nextToDoor=player.getCell().getGameMap().getDoor();
     player.setCell(nextToDoor);
     player.getInventory().removeItem(this);
    }
}
