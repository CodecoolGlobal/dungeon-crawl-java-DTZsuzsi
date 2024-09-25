package com.codecool.dungeoncrawl.data.savegame;

import com.codecool.dungeoncrawl.data.actors.PLAYER_FORM_TYPES;

import java.util.List;

public class GameState {
    private String mapName;
    private int playerX;
    private int playerY;
    private PLAYER_FORM_TYPES playerForm;
    private List<String> inventoryItems;

    public GameState(String mapName, int playerX, int playerY, PLAYER_FORM_TYPES playerForm, List<String> inventoryItems) {
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

    public PLAYER_FORM_TYPES getPlayerForm() {
        return playerForm;
    }

    public List<String> getInventoryItems() {
        return inventoryItems;
    }
}
