package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonstersTest {
    GameMap gameMap = new GameMap(10, 10, CellType.FLOOR);
    Player player = new Player(gameMap.getCell(1, 1));
    @Test
    void interactAttack() {
        Skeleton skeleton = new Skeleton(gameMap.getCell(2, 1));
        player.move(1,0);
        int expectedHealth=-1;
        int actualHealth=skeleton.getHealth();
        Actor expectedActor=null;
        Monsters actualActor=(Monsters)gameMap.getCell(1,1).getActor();
        assertEquals(expectedHealth,actualHealth);
        assertEquals(expectedActor,actualActor);

    }

    @Test
    void automaticMoveNotGoToWall() {
    }
}