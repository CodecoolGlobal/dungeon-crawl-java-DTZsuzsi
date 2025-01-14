package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.items.Healers.Crown;
import com.codecool.dungeoncrawl.data.items.Healers.Potion;
import com.codecool.dungeoncrawl.data.items.shopkeeper.Necklace;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InventoryTest {
    GameMap gameMap = new GameMap(3, 3, CellType.FLOOR);
    Player player = new Player(gameMap.getCell(1, 1));

    @Test
    void removeItem() {
        Crown crown = new Crown(gameMap.getCell(1, 1));
        Potion potion = new Potion(gameMap.getCell(1,2));
        player.getInventory().addItem(crown);
        player.getInventory().addItem(potion);
        player.getInventory().removeItem(crown);
        int expected = 1;
        int result = player.getInventory().getItems().size();
        assertEquals(expected, result);
    }

    @Test
    void addItemNotPickable() {
        Potion potion = new Potion(gameMap.getCell(1,2));
        Crown crown = new Crown(gameMap.getCell(1, 1));
        player.getInventory().addItem(potion);
        player.getInventory().addItem(crown);
        int expected = 1;
        int result = player.getInventory().getItems().size();
        assertEquals(expected, result);
    }


    @Test
    void isItemInInventory() {
        Potion potion = new Potion(gameMap.getCell(1,2));
        Crown crown = new Crown(gameMap.getCell(1, 1));
        player.getInventory().addItem(potion);
        player.getInventory().addItem(crown);
    boolean expected = true;
    boolean result = player.getInventory().getItems().stream().anyMatch(item -> item.equals(crown));
    assertEquals(expected, result);}

    @Test
    void getNecklace() {
        Necklace necklace = new Necklace(gameMap.getCell(1, 1));
        Potion potion = new Potion(gameMap.getCell(1,2));
        player.getInventory().addItem(necklace);
        player.getInventory().addItem(potion);
        Necklace result = player.getInventory().getNecklace();
        assertEquals(necklace, result);

    }
}