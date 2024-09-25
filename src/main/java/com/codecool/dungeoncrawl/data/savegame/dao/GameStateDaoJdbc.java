package com.codecool.dungeoncrawl.data.savegame.dao;

import com.codecool.dungeoncrawl.data.savegame.GameState;

import javax.sql.DataSource;
import java.sql.*;

public class GameStateDaoJdbc implements GameStateDao {

    private DataSource dataSource;

    public GameStateDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource; //dataSource is used to connect to the database. This is passed into the class via the constructor and will be used in each method to get a connection to the database.
    }                                   //This sets up the DAO to be able to interact with the database.

    @Override
    public void save(GameState gameState) {
        try (Connection connection = dataSource.getConnection()) { //this uses try-with-resources, which automatically closes the connection after the block of code is executed.
            String gameStateSql = "INSERT INTO game_state(map_name, player, player_y, player_form)" +
                         "VALUES (?, ?, ?, ?)" +
                         "ON CONFLICT (id) DO UPDATE" +
                         "SET map_name = ?, player = ?, player_y = ?, player_form = ?";
            PreparedStatement st = connection.prepareStatement(gameStateSql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, gameState.getMapName());
            st.setInt(2, gameState.getPlayerX());
            st.setInt(3, gameState.getPlayerY());
            st.setString(4, gameState.getPlayerForm().getTileName());
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys(); //After executing the INSERT query, this retrieves the ID (or other auto-generated values) from the database. In this case, it retrieves the newly generated game state id from the author table.
            rs.next(); //ResultSet (rs) is a cursor-like structure that holds the result of a database query. Initially, the cursor is positioned before the first result, so you need to move it to the first row using rs.next().
            int gameStateId = rs.getInt(1);

            //Deletes existing inventory
            String deleteInventorySql = "DELETE FROM inventory WHERE id = ?";
            PreparedStatement deleteInventory = connection.prepareStatement(deleteInventorySql);
            deleteInventory.setInt(1, gameStateId);
            deleteInventory.executeUpdate();

            //Insert current inventory
            String inventorySql = "INSERT INTO inventory (game_state_id, item_name) values(?, ?)";
            PreparedStatement inventorySt = connection.prepareStatement(inventorySql);
            for (String item : gameState.getInventoryItems()) {
                inventorySt.setInt(1, gameStateId);
                inventorySt.setString(2, item);
                inventorySt.executeUpdate();
            }
        } catch (SQLException throwables) {
            throw new RuntimeException("Failed to save gameState", throwables);
        }
    }

    @Override
    public GameState load() {
        return null;
    }
}
