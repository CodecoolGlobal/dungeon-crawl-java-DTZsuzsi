package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.*;

import java.util.List;
import java.util.Random;

public class GameLogic {
    private final Player player; //gameMap már tárolja a playert
    private GameMap map;
    private String mapFileName;




    public GameLogic(Cell cell) {
        this.player = new Player(cell);
        this.mapFileName = "/map.txt";
        this.map = MapLoader.loadMap("/map.txt",  player);

    }


    public double getMapWidth() {
        return map.getWidth();
    }

    public double getMapHeight() {
        return map.getHeight();
    }

    public void setup() {
    }

    public Cell getCell(int x, int y) {
        return map.getCell(x, y);
    }

    public String getPlayerHealth() {
        return Integer.toString(map.getPlayer().getHealth());
    }

    public String getPlayerAttack() {
        return Integer.toString(map.getPlayer().getAttack());
    }

    public String getPlayerInventory() {
        return map.getPlayer().displayInventoryItems();
    }

    public void enemyMovingAutomatically() {
        Random random = new Random();
        List<Actor> actors = map.getActors();
        for (Actor actor : actors) {
            if (actor instanceof Bat || actor instanceof Skeleton || actor instanceof DogFighter) {
                actor.move(random.nextInt(3) - 1, random.nextInt(3) - 1);
            }
        }
    }

    public GameMap getMap() {
        return map;
    }

    public void loadNextMap() {
        if (mapFileName=="/map.txt") {
            mapFileName = "/map2.txt";
            this.map = MapLoader.loadMap("/map2.txt",  player);
//        map.setPlayer(player);
        }
        else {
            mapFileName = "/map3.txt";
            this.map = MapLoader.loadMap("/map3.txt",  player);
        }


    }
}
