package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Money extends Item {
private int amount;
private int BASIC_AMOUNT=1000;
    public Money(Cell cell, boolean isPickable) {
        super(cell, true);
        this.amount = BASIC_AMOUNT;
    }

    public Money(){
        this.amount = BASIC_AMOUNT;
        super.isPickable=false;
    }

    public Money(boolean pickable) {
        super(pickable);
    }

    @Override
    public String getTileName() {
        return amount + " gold";
    }




    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
this.amount = amount;
    }
}
