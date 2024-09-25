package com.codecool.dungeoncrawl.data.savegame.dao;

import com.codecool.dungeoncrawl.data.savegame.GameState;

public interface GameStateDao {
    void save(GameState gameState);
    GameState load();
}
