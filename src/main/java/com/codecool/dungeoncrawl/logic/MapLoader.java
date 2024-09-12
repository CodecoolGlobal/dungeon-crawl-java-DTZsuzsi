package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.*;
import com.codecool.dungeoncrawl.data.items.*;

import java.io.InputStream;
import java.util.Scanner;

public class MapLoader {
    public static GameMap loadMap(String fileName,  GameLogic gameLogic, Player player) {
        InputStream is = MapLoader.class.getResourceAsStream(fileName);
        System.out.println(is);
        Scanner scanner = new Scanner(is);

        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine(); // empty line

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
                            new Skeleton(cell, gameLogic);
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            map.setPlayer(new Player(cell, gameLogic));
                            break;
                        case 'D':
                            cell.setType(CellType.FLOOR);
                            new DogFighter(cell,gameLogic);
                            break;
                        case 'Y':
                            cell.setType(CellType.FLOOR);
                            new Yoda(cell,gameLogic);
                            break;
                        case 'O':
                            cell.setType(CellType.FLOOR);
                            new Octopus(cell,gameLogic);
                            break;
                        case 'B':
                            cell.setType(CellType.FLOOR);
                            new Bat(cell, gameLogic);
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
                            cell.setType(CellType.FLOOR);
                            new Door(cell);
                            break;
                        case 'h':
                            cell.setType(CellType.FLOOR);
                            new Helmet(cell);
                            break;
                        case 'e':
                            cell.setType(CellType.STAIRS);
                            break;
                        case '%':
                            cell.setType(CellType.FOREST);
                            break;
                        case 'b':
                            cell.setType(CellType.FLOOR);
                            new Bear(cell,15,21,gameLogic);
                            break;
                        case 'w':
                            cell.setType(CellType.FLOOR);
                            new Wizard(cell, 30,2,gameLogic);
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
