package com.codecool.dungeoncrawl.data.items.shopkeeper;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.npc.monsters.Monsters;

import java.util.List;

public class Bomb extends ShopKeeperItems  {
   private static final int BASIC_PRICE = 500;
    public Bomb(Cell cell) {
        super(cell, BASIC_PRICE);

    }






    @Override
    public String getTileName() {
        return "bomb press K to use";
    }

    @Override
    public void doEffect(Player player) {
        List<Cell> playerNeighbors=player.getNeighbourCells();
        playerNeighbors.forEach(cell->{if (cell.getActor() instanceof Monsters) {
            cell.setActor(null);
            player.getInventory().removeItem(this);
        }});
    }
}
