package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;

import java.util.Objects;

public abstract class Item implements Drawable {
    private Cell cell;
    protected boolean isPickable;

    public Item(Cell cell, boolean isPickable) {
        this.cell = cell;
        if (this.cell != null) {
            this.cell.setItem(this);
        }
        this.isPickable = isPickable;
    }

   public Item(boolean pickable) {
        this.isPickable = pickable;
   }
   public Item() {

   }

    public Cell getCell() {
        return cell;
    }



    public abstract String getTileName();

    public boolean isPickable() {
        return isPickable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return getTileName().equals(item.getTileName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTileName());
    }
}
