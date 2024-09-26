package com.codecool.dungeoncrawl.data;

public enum CellType {
    EMPTY("empty",false),
    FLOOR("floor",true),
    WALL("wall",false),
    FOREST("forest",false),
    STAIRS("stairs",true),
    BOSSFLOOR("bossFloor",true),
    BOSSWALL("bossWall",false),
    CLOSED_DOOR("closedDoor",false),
    OPEN_DOOR("openDoor",true),
    HOUSE("house",false),
    SAVE_GAME("saveGame", true),
    LOAD_GAME("loadGame", true);



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
