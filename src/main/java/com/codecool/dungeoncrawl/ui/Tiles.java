package com.codecool.dungeoncrawl.ui;

import com.codecool.dungeoncrawl.data.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class Tiles {
    public static int TILE_WIDTH = 32;
//        public Money money=new Money();

    private static Image tileset = new Image("/tiles.png", 543 * 2, 543 * 2, true, false);
    private static Map<String, Tile> tileMap = new HashMap<>();
    public static class Tile {
        public final int x, y, w, h;
        Tile(int i, int j) {
            x = i * (TILE_WIDTH + 2);
            y = j * (TILE_WIDTH + 2);
            w = TILE_WIDTH;
            h = TILE_WIDTH;
        }
    }

    static {
        tileMap.put("empty", new Tile(0, 0));
        tileMap.put("wall", new Tile(10, 17));
        tileMap.put("floor", new Tile(2, 0));
        tileMap.put("playerShieldSword", new Tile(27, 0));
        tileMap.put("playerBasic", new Tile(25, 0));
        tileMap.put("playerSword", new Tile(26, 0));
        tileMap.put("playerSwordShieldHelmet", new Tile(28, 0));
        tileMap.put("playerSuperSwordShieldHelmet", new Tile(29, 0));
        tileMap.put("playerHelmet", new Tile(30, 0));
        tileMap.put("playerSuper", new Tile(31, 0));
        tileMap.put("skeleton", new Tile(29, 6));
        tileMap.put("dogFighter", new Tile(27, 2));
        tileMap.put("yoda", new Tile(29, 2));
        tileMap.put("octopus", new Tile(25, 8));
        tileMap.put("bat", new Tile(26, 8));
        tileMap.put("mace", new Tile(4, 26));
        tileMap.put("key", new Tile(16, 23));
        tileMap.put("closedDoor", new Tile(3, 9));
        tileMap.put("openDoor", new Tile(6, 9));
        tileMap.put("stairs", new Tile(2, 6));
        tileMap.put("forest", new Tile(5, 1));
        tileMap.put("bear", new Tile(30, 8));
        tileMap.put("wizard", new Tile(24, 1));
        tileMap.put("helmet", new Tile(4, 22));
        tileMap.put("potion", new Tile(26, 23));
        tileMap.put("crown", new Tile(12,24));
        tileMap.put("boss", new Tile(28, 6));
        tileMap.put("bossWall", new Tile(19, 17));
        tileMap.put("bossFloor", new Tile(12, 18));
        tileMap.put("bossSkeleton", new Tile(24,7));
        tileMap.put("friend", new Tile(19,9));
        tileMap.put("shield", new Tile(6,25));
        tileMap.put("superSword", new Tile(4, 30));
        tileMap.put("house", new Tile(19, 10));
        tileMap.put("shopKeeper", new Tile(26, 9));
        tileMap.put("superPotion", new Tile(18,25));
        tileMap.put("1000 gold", new Tile(9, 25));
        tileMap.put("bomb press K to use", new Tile(13, 31));
        tileMap.put("necklace press N to use", new Tile(14, 30));
        tileMap.put("saveGame", new Tile(25, 28));
        tileMap.put("loadGame", new Tile(26, 28));



    }

    public static void drawTile(GraphicsContext context, Drawable d, int x, int y) {
        Tile tile = tileMap.get(d.getTileName());
        context.drawImage(tileset, tile.x, tile.y, tile.w, tile.h,
                x * TILE_WIDTH, y * TILE_WIDTH, TILE_WIDTH, TILE_WIDTH);
    }
}
