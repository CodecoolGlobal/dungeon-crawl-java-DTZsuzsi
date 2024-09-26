package com.codecool.dungeoncrawl.data.actors.npc.allies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FriendTest {
    GameMap gameMap = new GameMap(10, 10, CellType.FLOOR);
    Player player = new Player(gameMap.getCell(3, 3));


    @Test
    void isPlayerNext() {
        Friend friend = new Friend(player.getCell().getNeighbor(1, 0));
        player.move(1, 0);
        boolean expected = false;
        boolean result = friend.isPlayerNext(player);
        assertEquals(expected, result);
    }

    @Test
    void follow() {
        Friend friend = new Friend(player.getCell().getNeighbor(1, 0));
        player.move(1, 0);
        player.setCell(gameMap.getCell(6, 6));
        int expected = gameMap.getCell(2, 6).getX();
        int result = player.getFriend().getCell().getX();
        assertEquals(expected, result);
    }
}