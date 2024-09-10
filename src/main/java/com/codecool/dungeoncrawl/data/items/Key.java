package com.codecool.dungeoncrawl.data.items;

public class Key extends Items {
    private boolean isCollected;

    public Key(boolean isCollected) {
        this.isCollected = false;
    }

    public boolean isCollected() {
        return isCollected;
    }

    @Override
    public int increaseHealth() {
        if (isCollected) {
            return 1;
        } else {
            return 0;
        }
    }
}
