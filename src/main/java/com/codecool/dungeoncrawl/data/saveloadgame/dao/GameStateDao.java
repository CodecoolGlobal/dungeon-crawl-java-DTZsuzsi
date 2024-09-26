package com.codecool.dungeoncrawl.data.saveloadgame.dao;

import com.codecool.dungeoncrawl.data.saveloadgame.GameState;

public interface GameStateDao {
    void save(GameState gameState);
    GameState load();
}
