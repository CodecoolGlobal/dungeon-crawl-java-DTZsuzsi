package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;

public abstract class ItemWithEffect extends Item {

    public ItemWithEffect(Cell cell, boolean isPickable) {
        super(cell, isPickable);
    }

    public ItemWithEffect(boolean pickable) {
        super(pickable);
    }

    @Override
    public String getTileName() {
        return "";
    }

  public  abstract void doEffect(Player player);

}
