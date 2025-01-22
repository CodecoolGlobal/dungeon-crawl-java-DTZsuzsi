package com.codecool.dungeoncrawl.configuration;

import com.codecool.dungeoncrawl.data.saveloadgame.dao.GameStateDao;
import com.codecool.dungeoncrawl.data.saveloadgame.dao.GameStateDaoJdbc;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DatabaseManager {
   private GameStateDao gameStateDao;
   private DataSource dataSource;

    public void setup() throws SQLException {
        this.dataSource = connect();
        this.gameStateDao = new GameStateDaoJdbc(dataSource);
    }

    private DataSource connect() throws SQLException {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setDatabaseName(System.getenv("DB_NAME"));
        dataSource.setUser(System.getenv("DB_USERNAME"));
        dataSource.setPassword(System.getenv("DB_PASSWORD"));
        dataSource.setServerNames(new String[] {"localhost"});
        dataSource.setPortNumbers(new int[] {Integer.parseInt(System.getenv("DB_PORT"))});
        System.out.println("Trying to connect to PostgreSQL database");
        dataSource.getConnection().close();
        return dataSource;
    }

    public GameStateDao getGameStateDao() {
        return gameStateDao;
    }


    public DataSource getDataSource() {
        return dataSource;
    }
}