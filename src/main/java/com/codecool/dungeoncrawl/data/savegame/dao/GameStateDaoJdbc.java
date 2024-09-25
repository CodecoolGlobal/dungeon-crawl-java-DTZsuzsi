package com.codecool.dungeoncrawl.data.savegame.dao;

import com.codecool.dungeoncrawl.data.savegame.GameState;

import javax.sql.DataSource;

public class GameStateDaoJdbc implements GameStateDao {

    private DataSource dataSource;
    public GameStateDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource; //dataSource is used to connect to the database. This is passed into the class via the constructor and will be used in each method to get a connection to the database.
    }                                   //This sets up the DAO to be able to interact with the database.

    @Override
    public void save(GameState gameState) {

    }

    @Override
    public GameState load() {
        return null;
    }
}
