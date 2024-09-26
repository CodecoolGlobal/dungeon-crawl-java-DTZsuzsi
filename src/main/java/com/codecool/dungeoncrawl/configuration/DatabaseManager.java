package com.codecool.dungeoncrawl.configuration;

import com.codecool.dungeoncrawl.data.saveloadgame.dao.GameStateDao;
import com.codecool.dungeoncrawl.data.saveloadgame.dao.GameStateDaoJdbc;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DatabaseManager {
    GameStateDao gameStateDao;
    DataSource dataSource;

    public void setup() throws SQLException {
        this.dataSource = connect();
        this.gameStateDao = new GameStateDaoJdbc(dataSource);
    }

    private DataSource connect() throws SQLException {
        PGSimpleDataSource dataSource = new PGSimpleDataSource(); //creates a new instance of PGSimpleDataSource, a class that provides simple configuration for PostgreSQL connections. It’s used to establish the connection parameters like database name, username, and password.
        dataSource.setDatabaseName("dungeoncrawl"); //this tells the dataSource which database to connect to
        dataSource.setUser("postgres");
        dataSource.setPassword("PostgreSQL@123"); //PostgreSQL@123. Syabolcs
        dataSource.setServerNames(new String[] {"localhost"});  // Replace with your actual server
        dataSource.setPortNumbers(new int[] {5432});  // Replace with your actual port if different
        System.out.println("Trying to connect to PostgreSQL database");
        dataSource.getConnection().close(); //dataSource.getConnection() is the key method here. It actually opens a connection to the database using the DataSource object we set up earlier. .close() closes the connection immediately after it’s opened, which is a simple way to check if the connection is successful. If no exceptions are thrown, the connection was established properly. If there is a problem (wrong credentials, database not found, etc.), an exception will be thrown.
        return dataSource; // returns a DataSource object, which manages the connection to the database. The method throws an SQLException in case something goes wrong while setting up the connection.
        //After testing the connection, the method returns the DataSource object so that other parts of the program can use it to interact with the database.
    }

    public GameStateDao getGameStateDao() {
        return gameStateDao;
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}