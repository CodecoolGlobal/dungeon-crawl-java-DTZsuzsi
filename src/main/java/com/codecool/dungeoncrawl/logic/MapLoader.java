package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.npc.allies.Friend;
import com.codecool.dungeoncrawl.data.actors.npc.allies.ShopKeeper;
import com.codecool.dungeoncrawl.data.actors.npc.allies.Yoda;
import com.codecool.dungeoncrawl.data.actors.npc.monsters.*;
import com.codecool.dungeoncrawl.data.items.Healers.Crown;
import com.codecool.dungeoncrawl.data.items.Healers.Helmet;
import com.codecool.dungeoncrawl.data.items.Healers.Potion;
import com.codecool.dungeoncrawl.data.items.Healers.Shield;
import com.codecool.dungeoncrawl.data.items.Key;
import com.codecool.dungeoncrawl.data.items.Money;
import com.codecool.dungeoncrawl.data.items.attacking.BigSword;
import com.codecool.dungeoncrawl.data.items.attacking.Mace;

import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

public class MapLoader {
  private static Random random = new Random();
    public static GameMap loadMap(String fileName, Player player) {
        InputStream is = MapLoader.class.getResourceAsStream(fileName);
        System.out.println(is);
        Scanner scanner = new Scanner(is);

        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine();

        GameMap map = new GameMap(width, height, CellType.EMPTY);
        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case 's':
                            cell.setType(CellType.FLOOR);
                            new Skeleton(cell,random);
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            if (player == null) {
                                map.setPlayer(new Player(cell));
                            } else {
                                map.setPlayer(player);
                                player.setCell(cell);
                                if (player.getFriend() != null) {
                                    player.getFriend().setCell(cell.getNeighbor(-1, 0));
                                }
                            }
                            break;
                        case 'D':
                            cell.setType(CellType.FLOOR);
                            new DogFighter(cell, random);
                            break;
                        case ':':
                            cell.setType(CellType.BOSS_FLOOR);
                            new BossSkeleton(cell,random);
                            break;
                        case 'Y':
                            cell.setType(CellType.FLOOR);
                            new Yoda(cell);
                            break;
                        case 'O':
                            cell.setType(CellType.FLOOR);
                            new Octopus(cell,random);
                            break;
                        case 'B':
                            cell.setType(CellType.FLOOR);
                            new Bat(cell,random);
                            break;
                        case 'M':
                            cell.setType(CellType.FLOOR);
                            new Mace(cell);
                            break;
                        case 'K':
                            cell.setType(CellType.FLOOR);
                            new Key(cell);
                            break;
                        case 'd':
                            cell.setType(CellType.CLOSED_DOOR);
                            break;
                        case 'h':
                            cell.setType(CellType.FLOOR);
                            new Helmet(cell);
                            break;
                        case '+':
                            cell.setType(CellType.FLOOR);
                            new Shield(cell);
                            break;
                        case 'e':
                            cell.setType(CellType.STAIRS);
                            break;
                        case '%':
                            cell.setType(CellType.FOREST);
                            break;
                        case 'b':
                            cell.setType(CellType.FLOOR);
                            new Bear(cell,random);
                            break;
                        case 'w':
                            cell.setType(CellType.FLOOR);
                            new Wizard(cell,random);
                            break;
                        case 'p':
                            cell.setType(CellType.FLOOR);
                            new Potion(cell);
                            break;
                        case 'c':
                            cell.setType(CellType.FLOOR);
                            new Crown(cell);
                            break;
                        case 'F':
                            cell.setType(CellType.FLOOR);
                            new Friend(cell);
                            break;
                        case 'G':
                            cell.setType(CellType.BOSS_WALL);
                            break;
                        case '_':
                            cell.setType(CellType.BOSS_FLOOR);
                            break;
                        case '!':
                            cell.setType(CellType.FLOOR);
                            new Boss(cell,random);
                            break;
                        case '-':
                            cell.setType(CellType.FLOOR);
                            new BigSword(cell);
                            break;
                        case '(':
                            cell.setType(CellType.HOUSE);
                            break;
                        case 'V':
                            cell.setType(CellType.FLOOR);
                            new ShopKeeper(cell);
                            break;
                        case 'Z':
                            cell.setType(CellType.FLOOR);
                            new Money(cell, true);
                            break;
                        case 'S':
                            cell.setType(CellType.SAVE_GAME);
                            break;
                        case 'L':
                            cell.setType(CellType.LOAD_GAME);
                            break;
                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }


}
