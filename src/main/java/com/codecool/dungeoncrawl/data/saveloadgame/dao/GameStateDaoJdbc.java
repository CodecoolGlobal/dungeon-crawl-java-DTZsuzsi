package com.codecool.dungeoncrawl.data.saveloadgame.dao;

import com.codecool.dungeoncrawl.data.actors.PLAYER_FORM_TYPES;
import com.codecool.dungeoncrawl.data.items.Inventory;
import com.codecool.dungeoncrawl.data.saveloadgame.GameState;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameStateDaoJdbc implements GameStateDao {

    private DataSource dataSource;

    public GameStateDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource; //dataSource is used to connect to the database. This is passed into the class via the constructor and will be used in each method to get a connection to the database.
    }                                   //This sets up the DAO to be able to interact with the database.

    @Override
    public void save(GameState gameState) {
        try (Connection connection = dataSource.getConnection()) {
            // Delete previous game state and inventory
            String deleteGameStateSql = "DELETE FROM game_state";
            PreparedStatement deleteGameStateSt = connection.prepareStatement(deleteGameStateSql);
            deleteGameStateSt.executeUpdate();

            String deleteInventorySql = "DELETE FROM inventory";
            PreparedStatement deleteInventorySt = connection.prepareStatement(deleteInventorySql);
            deleteInventorySt.executeUpdate();

            // Insert the new game state
            String gameStateSql = "INSERT INTO game_state(map_name, player_x, player_y, player_health, player_attack, player_form)" +
                    "VALUES (?, ?, ?, ?, ?, ?)" +
                    "ON CONFLICT (game_state_id) DO UPDATE " +
                    "SET map_name = EXCLUDED.map_name, " +
                    "player_x = EXCLUDED.player_x, " +
                    "player_y = EXCLUDED.player_y, " +
                    "player_health = EXCLUDED.player_health, " +
                    "player_attack = EXCLUDED.player_attack," +
                    "player_form = EXCLUDED.player_form";
            PreparedStatement st = connection.prepareStatement(gameStateSql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, gameState.getMapName());
            st.setInt(2, gameState.getPlayerX());
            st.setInt(3, gameState.getPlayerY());
            st.setInt(4, gameState.getHealth());
            st.setInt(5, gameState.getAttack());
            st.setString(6, gameState.getPlayerForm().getTileName());
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            rs.next();
            int gameStateId = rs.getInt(1);

            // Insert the current inventory
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
        try (Connection connection = dataSource.getConnection()) {
            String gameStateSql = "SELECT * FROM game_state LIMIT 1"; // instead of limit WHERE id = ? or WHERE user_id could be used if we save game by user
            PreparedStatement st = connection.prepareStatement(gameStateSql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String mapName = rs.getString("map_name");
                int playerX = rs.getInt("player_x");
                int playerY = rs.getInt("player_y");
                int health = rs.getInt("player_health");
                int attack = rs.getInt("player_attack");
//                String playerForm = rs.getString("player_form");

                //load inventory
                String inventorySql = "SELECT item_name FROM inventory WHERE game_state_id = ?";
                PreparedStatement inventorySt = connection.prepareStatement(inventorySql);
                inventorySt.setInt(1, rs.getInt("game_state_id"));
                ResultSet inventoryRs = inventorySt.executeQuery();

                List<String> inventoryItems = new ArrayList<>();
                while (inventoryRs.next()) {
                    inventoryItems.add(inventoryRs.getString("item_name"));
                }
                String tileName = rs.getString("player_form");
                PLAYER_FORM_TYPES playerFormToLoad = PLAYER_FORM_TYPES.getEnumByTileName(tileName);
                Inventory inventory = new Inventory();
                inventory.loadItemsFromString(inventoryItems, null);
                return new GameState(mapName, playerX, playerY, health, attack, playerFormToLoad, inventoryItems);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
