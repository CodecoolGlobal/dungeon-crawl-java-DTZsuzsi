package com.codecool.dungeoncrawl.data.actors.npc.allies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.items.Inventory;
import com.codecool.dungeoncrawl.data.items.Item;
import com.codecool.dungeoncrawl.data.items.shopkeeper.Bomb;
import com.codecool.dungeoncrawl.data.items.shopkeeper.Necklace;
import com.codecool.dungeoncrawl.data.items.shopkeeper.ShopKeeperItems;
import com.codecool.dungeoncrawl.data.items.shopkeeper.SuperPotion;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Optional;

public class ShopKeeper extends Ally {
    private final static int BASIC_HEALTH = 25;
    private final static int BASIC_ATTACK = 0;
    private Inventory inventory;

    public ShopKeeper(Cell cell) {
        super(cell, BASIC_HEALTH, BASIC_ATTACK, "I'm the shopkeeper. Come and I'll help.");
        inventory = new Inventory();
        inventory.addItem(new SuperPotion(cell));
        inventory.addItem(new Bomb(cell));
        inventory.addItem(new Necklace(cell));
    }

    @Override
    public String getTileName() {
        return "shopKeeper";
    }

    @Override
    public void interact(Player player) {
        player.addAlly(this);

        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("Shopkeeper");

        Label label = new Label("Hello traveler, I'm the famous shopkeeper.\n " +
                "I have three wonderful objects for you: \n" +
                "1. Super potion (200 health), price: 100 gold.\n" +
                "2. Bomb (Press 'K' to kill all enemies nearby), price: 500 gold.\n" +
                "3. Necklace (Press 'N' to teleport to next stairs), price: 1000 gold.\n" +
                "Which one do you choose? Type 'superpotion, \n'" +
                " 'bomb' or 'necklace'."
        );

        TextField inputField = new TextField();
        Button submitButton = new Button("Submit");

        submitButton.setOnAction(e -> {
            try {
                String answer = inputField.getText().toLowerCase();  // Lowercase to ignore case sensitivity

                switch (answer) {
                    case "superpotion":
                        processPurchase(player, "SuperPotion", popupStage);
                        break;
                    case "bomb":
                        processPurchase(player, "Bomb", popupStage);
                        break;
                    case "necklace":
                        processPurchase(player, "Necklace", popupStage);
                        break;
                    default:
                        Platform.runLater(() -> action.showPopup("error", "Invalid choice! Please type 'superpotion', 'bomb', or 'necklace'."));
                        break;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                Platform.runLater(() -> action.showPopup("error", "An unexpected error occurred."));
            }
        });

        // Layout for the pop-up window
        VBox layout = new VBox(10, label, inputField, submitButton);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");
        Scene popupScene = new Scene(layout, 400, 300);

        popupStage.setScene(popupScene);
        popupStage.showAndWait();
    }

    private void processPurchase(Player player, String itemType, Stage popupStage) {
        Optional<Item> optionalItem = inventory.getItems().stream()
                .filter(item -> item.getClass().getSimpleName().equals(itemType))
                .findFirst();

        if (optionalItem.isPresent()) {
            ShopKeeperItems item = (ShopKeeperItems) optionalItem.get();
            if (player.hasEnoughMoney(item)) {
                Cell currentCell = this.cell;
                Cell nextCell = currentCell.getNeighbor(0, 2);
                nextCell.setItem(item);
                player.getMoney().setAmount(player.getMoney().getAmount() - item.getPrice());
                inventory.removeItem(item);

                Platform.runLater(() -> {
                    action.showPopup("success", "You have successfully purchased the " + itemType + "!");
                    popupStage.close();
                });
            } else {
                Platform.runLater(() -> action.showPopup("nomoney", "Sorry, you don't have enough money for the " + itemType + "!"));
            }
        } else {
            Platform.runLater(() -> action.showPopup("error", "Sorry, the shopkeeper doesn't have a " + itemType + "!"));
        }
    }


//
}
