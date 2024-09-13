package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.*;
import com.codecool.dungeoncrawl.data.actors.npc.monsters.DogFighter;
import com.codecool.dungeoncrawl.data.actors.npc.monsters.Monsters;
import com.codecool.dungeoncrawl.data.actors.npc.monsters.Skeleton;

import java.util.List;
import java.util.Random;

public class GameLogic {
    private GameMap map;
    private String mapFileName;
    private GameStartSound gameStartSound;
    private GameNewMapLoaderSound gameNewMapLoaderSound;
    private List<String>mapFileNames=List.of("/map.txt","/map2.txt","/map3.txt","/map4.txt");




    public GameLogic() {
        this.mapFileName = "/map.txt";
        this.map = MapLoader.loadMap(mapFileName, null);
        gameStartSound = new GameStartSound("/sound/free-music-in-my-mind-remake-26367.mp3");
        gameStartSound.play();

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

        List<Actor> actors = map.getActors();
        for (Actor actor : actors) {
            if (actor instanceof Monsters) {
                ((Monsters) actor).automaticMove();
            }
        }
    }

    public GameMap getMap() {
        return map;
    }

    public void loadNextMap() {
      Player myPlayer=map.getPlayer();
      gameStartSound.stop();
      int currentIndex=mapFileNames.indexOf(mapFileName);


//        if (mapFileName.equals("/map.txt")) {
         mapFileName = mapFileNames.get(currentIndex+1);
            this.map = MapLoader.loadMap(mapFileName,  myPlayer);
            gameNewMapLoaderSound = new GameNewMapLoaderSound("/sound/get_ready_to_the_next_fight_sielxm3d-83870.mp3");
//            gameNewMapLoaderSound.play();
////        map.setPlayer(player);
//        }
//        else {
//            mapFileName = "/map3.txt";
//            this.map = MapLoader.loadMap("/map3.txt",  myPlayer);
//            gameNewMapLoaderSound = new GameNewMapLoaderSound("/sound/get_ready_to_the_next_fight_sielxm3d-83870.mp3");
//            gameNewMapLoaderSound.play();
//        }
//

    }
}
