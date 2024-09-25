package com.codecool.dungeoncrawl.data.savegame;

import java.util.List;

public class GameState {
    private String mapName;
    private int playerX;
    private int playerY;
    private String playerForm;
    private List<String> inventoryItems;

    public GameState(String mapName, int playerX, int playerY, String playerForm, List<String> inventoryItems) {
        this.mapName = mapName;
        this.playerX = playerX;
        this.playerY = playerY;
        this.playerForm = playerForm;
        this.inventoryItems = inventoryItems;
    }

    public String getMapName() {
        return mapName;
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public String getPlayerForm() {
        return playerForm;
    }

    public List<String> getInventoryItems() {
        return inventoryItems;
    }
}
