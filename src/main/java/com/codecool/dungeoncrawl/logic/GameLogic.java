package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.configuration.DatabaseManager;
import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.npc.allies.Ally;
import com.codecool.dungeoncrawl.data.actors.npc.monsters.Monster;
import com.codecool.dungeoncrawl.data.items.Item;
import com.codecool.dungeoncrawl.data.items.ItemFactory;
import com.codecool.dungeoncrawl.data.saveloadgame.GameState;

import java.util.List;
import java.util.stream.Collectors;

public class GameLogic {
    private GameMap map;
    private String mapFileName;


    private SoundPlayer gameStartSound;
    private SoundPlayer gameNewMapLoaderSound;
    private List<String> mapFileNames = List.of("/map1.txt", "/map2.txt", "/map3.txt", "/map4.txt");
    private DatabaseManager databaseManager;

    public GameLogic() {
        this.mapFileName = "/map1.txt";
        this.map = MapLoader.loadMap(mapFileName, null);
        this.gameStartSound = new SoundPlayer(SOUND_TYPES.START);
        gameStartSound.play();
        this.gameNewMapLoaderSound = new SoundPlayer(SOUND_TYPES.NEW_MAP);
        this.databaseManager = new DatabaseManager();


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

    public String getHearts() {
        int amount = map.getPlayer().countHearts();
        String message = "";
        String heart = "❤\uFE0F";
        for (int i = 0; i < amount; i++) {
            message += heart;
        }
        return message;
    }

    public String getFriendMessages() {
        String message = "";
        if (map.getPlayer().getAllies().size() != 0) {
            for (Ally ally : map.getPlayer().getAllies()) {
                message += ally.getMessage();
            }
        }
        return message;
    }

    public String getPlayerInventory() {
        return map.getPlayer().getInventory().displayInventoryItems();
    }


    public void enemyMovingAutomatically() {

        List<Actor> actors = map.getActors();
        for (Actor actor : actors) {
            if (actor instanceof Monster) {
                ((Monster) actor).automaticMove();
            }
        }
    }

    public GameMap getMap() {
        return map;
    }

    public void loadNextMap() {
//        Player myPlayer = map.getPlayer();
//        gameStartSound.stop();
//        int currentIndex = mapFileNames.indexOf(mapFileName);
//        mapFileName = mapFileNames.get(currentIndex + 1);
//        this.map = MapLoader.loadMap(mapFileName, myPlayer);
//        gameNewMapLoaderSound.play();

        Player myPlayer = map.getPlayer();
        gameStartSound.stop();

        int currentIndex = mapFileNames.indexOf(mapFileName);
        if (currentIndex + 1 < mapFileNames.size()) {
            mapFileName = mapFileNames.get(currentIndex + 1);
            this.map = MapLoader.loadMap(mapFileName, myPlayer);

            gameNewMapLoaderSound.stop();
            gameNewMapLoaderSound.play();
        } else {
            System.out.println("No more maps to load.");
        }
    }

    public void meetDoor() {
        if (getMap().isPlayerNextClosedDoor()) {
            getMap().nextToDoor();
        }
    }

    public String getMapFileName() {
        return mapFileName;
    }

    public void saveGame(Player player) {
        List<String> itemNames = player.getInventory().getItems().stream()
                .map(Item::getTileName)
                .collect(Collectors.toList());

        GameState gameState = new GameState(
                mapFileName,
                player.getX(),
                player.getY(),
                player.getHealth(),
                player.getAttack(),
                player.getForm(),
                itemNames
        );
        databaseManager.getGameStateDao().save(gameState);
        System.out.println("Game saved");
    }

    public void loadGame() {
        GameState gameState = databaseManager.getGameStateDao().load();

        if (gameState != null) {
            Player player = map.getPlayer();
            player.setForm(gameState.getPlayerForm());
            String mapFileNameLoaded = gameState.getMapName();
            System.out.println(mapFileNameLoaded);
            this.map = MapLoader.loadMap(mapFileNameLoaded, player);
            player.setPosition(gameState.getPlayerX(), gameState.getPlayerY());
            player.setHealth(gameState.getHealth());
            player.setAttack(gameState.getAttack());

            List<String> itemNames = gameState.getInventoryItems();
            List<Item> items = itemNames.stream()
                    .map(itemName -> ItemFactory.createItem(itemName, player.getCell()))
                    .collect(Collectors.toList());

            player.getInventory().setItems(items);
            System.out.println("game loaded");
        } else {
            System.out.println("No game found");
        }
    }

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }
}
