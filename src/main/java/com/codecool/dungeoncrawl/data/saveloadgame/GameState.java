package com.codecool.dungeoncrawl.data.saveloadgame;

import com.codecool.dungeoncrawl.data.actors.PlayerFormTypes;

import java.util.List;

public class GameState {
    private String mapName;
    private int playerX;
    private int playerY;
    private int health;
    private int attack;
    private PlayerFormTypes playerForm;
    private List<String> inventoryItems;

    public GameState(String mapName, int playerX, int playerY, int health, int attack, PlayerFormTypes playerForm, List<String> inventoryItems) {
        this.mapName = mapName;
        this.playerX = playerX;
        this.playerY = playerY;
        this.health = health;
        this.attack = attack;
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

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public PlayerFormTypes getPlayerForm() {
        return playerForm;
    }

    public List<String> getInventoryItems() {
        return inventoryItems;
    }
}
