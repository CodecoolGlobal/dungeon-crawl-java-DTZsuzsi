package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.items.Money;
import com.codecool.dungeoncrawl.data.items.shopkeeper.Bomb;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    GameMap gameMap = new GameMap(3, 3, CellType.FLOOR);
    Player player = new Player(gameMap.getCell(1, 1));
    @Test
    void receiveHealth() {

     player.receiveHealth(5);
        int expectedHealth = 15;
        assertEquals(expectedHealth, player.getHealth());

    }

    @Test
    void setForm() {
    player.setForm(PlayerFormTypes.PLAYER_SWORD);
    assertEquals(PlayerFormTypes.PLAYER_SWORD, player.getForm());
    }

    @Test
    void hasEnoughMoney() {
        Cell cell = player.getCell();
        Bomb bomb=new Bomb(cell);
        Money money=new Money();
        player.setMoney(money);
        player.getInventory().addItem(money);
        boolean expected=true;
        boolean result= player.hasEnoughMoney(bomb);
        assertEquals(expected, result);

    }
}