package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.npc.allies.Yoda;
import com.codecool.dungeoncrawl.data.items.Healers.Helmet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ActionTest {
    private Player player;
    private GameMap gameMap;

    @BeforeEach
    void setUp() {
        this.gameMap = new GameMap(3, 3, CellType.FLOOR);
        this.player = new Player(gameMap.getCell(1, 1));
    }


    @Test
    void pickUpItemHealer() {
        Helmet helmet = new Helmet(gameMap.getCell(1, 2));
        player.move(0, 1);
        int expectedHealth = 30;
        int actualHealth = player.getHealth();
        int expectedInventorySize = 1;
        int actualInventorySize = player.getInventory().getItems().size();
        assertEquals(expectedHealth, actualHealth);
        assertEquals(expectedInventorySize, actualInventorySize);
    }



}