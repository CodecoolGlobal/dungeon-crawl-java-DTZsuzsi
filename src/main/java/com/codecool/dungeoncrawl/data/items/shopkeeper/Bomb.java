package com.codecool.dungeoncrawl.data.items.shopkeeper;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.npc.monsters.Monsters;
import com.codecool.dungeoncrawl.data.items.Item;
import com.codecool.dungeoncrawl.data.items.killers.killer;

import java.util.List;

public class Bomb extends ShopKeeperItems implements killer {
   private static final int BASIC_PRICE = 500;
    public Bomb(boolean pickable) {
        super(true, BASIC_PRICE);

    }

    public Bomb(Cell cell) {
        super(cell);
    }


    @Override
    public String getTileName() {
        return "bomb press K to use";
    }

    @Override
    public void kill(Player player) {
        List<Cell> playerNeighbors=player.getNeighbourCells();
        playerNeighbors.forEach(cell->{if (cell.getActor() instanceof Monsters) {
            cell.setActor(null);
            player.getInventory().removeItem(this);
        }});
    }
}
