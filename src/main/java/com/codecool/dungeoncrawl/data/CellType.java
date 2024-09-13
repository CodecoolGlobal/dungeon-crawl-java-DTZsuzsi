package com.codecool.dungeoncrawl.data;

public enum CellType {
    EMPTY("empty",false),
    FLOOR("floor",true),
    WALL("wall",false),
    FOREST("forest",false),
    STAIRS("stairs",true),
    BOSSFLOOR("bossFloor",true),
    BOSSWALL("bossWall",false);




    private final String tileName;
    private boolean isWalkable;

    CellType(String tileName, boolean isWalkable) {
        this.tileName = tileName;
        this.isWalkable = isWalkable;
    }

    public String getTileName() {
        return tileName;
    }

    public boolean isWalkable() {
        return isWalkable;
    }
}
