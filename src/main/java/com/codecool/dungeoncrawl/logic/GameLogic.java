package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.npc.monsters.Monsters;

import java.util.List;

public class GameLogic {
    private GameMap map;
    private String mapFileName;


private SoundPlayer gameStartSound;
private SoundPlayer gameNewMapLoaderSound;
    private List<String> mapFileNames = List.of("/map1.txt", "/map2.txt", "/map3.txt", "/map4.txt");


    public GameLogic() {
        this.mapFileName = "/map1.txt";
        this.map = MapLoader.loadMap(mapFileName, null);
        this. gameStartSound = new SoundPlayer(SOUND_TYPES.START);
        gameStartSound.play();
        this.gameNewMapLoaderSound = new SoundPlayer(SOUND_TYPES.NEW_MAP);

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
        return map.getPlayer().getInventory().displayInventoryItems();
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
        Player myPlayer = map.getPlayer();
        gameStartSound.stop();
        int currentIndex = mapFileNames.indexOf(mapFileName);
        mapFileName = mapFileNames.get(currentIndex + 1);
        this.map = MapLoader.loadMap(mapFileName, myPlayer);
        gameNewMapLoaderSound.play();
    }

    public void meetDoor(){
if (getMap().isPlayerNextClosedDoor()){
    getMap().nextToDoor();
}
    }
}
