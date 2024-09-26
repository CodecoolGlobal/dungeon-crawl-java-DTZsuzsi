package com.codecool.dungeoncrawl.data.actors.npc.allies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.items.Healers.SuperPotion;
import com.codecool.dungeoncrawl.data.items.Inventory;
import com.codecool.dungeoncrawl.data.items.Item;
import com.codecool.dungeoncrawl.data.items.shopkeeper.Bomb;
import com.codecool.dungeoncrawl.data.items.shopkeeper.Necklace;
import com.codecool.dungeoncrawl.data.items.shopkeeper.ShopKeeperItems;
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
        inventory.addItem(new SuperPotion(false));
        inventory.addItem(new Bomb(true));
        inventory.addItem(new Necklace(true));
    }

    @Override
    public String getTileName() {
        return "shopKeeper";
    }

    @Override
//    public void interact(Player player) {
//        player.addAlly(this);
//
//
//        Stage popupStage = new Stage();
//        popupStage.initModality(Modality.APPLICATION_MODAL);
//        popupStage.setTitle("Shopkeeper");
//
//        Label label = new Label("Hello traveler, I'm the famous shopkeeper.\n " +
//                " I have three wonderful objects for you: \n" +
//                "The famous super potion, get you 200 health, price: 100 gold\n" +
//                "A bomb, which you can use to kill (press K) all your enemies\n" +
//                "in the neighbor, price: 500 gold.\n" +
//                "A necklace, which teleport (press N) you to the next stairs. 1000 gold.\n"+
//                "Which one do you choose? Necklace, bomb or superpotion?"
//        );
//        TextField inputField = new TextField();
//        Button submitButton = new Button("Submit");
//
//        submitButton.setOnAction(e -> {
//            String answer = inputField.getText();
//
//            if (answer.equals("superpotion")) {
//                Cell currentCell = this.cell;
//                Cell nextCell = currentCell.getNeighbor(0, 2);
//                SuperPotion superPotion;
//                superPotion = (SuperPotion) inventory.getItems().stream().filter(item -> item instanceof SuperPotion).findFirst().get();
//                if (player.hasEnoughMoney(superPotion)) {
//                    nextCell.setItem(superPotion);
//                    player.getMoney().setAmount(player.getMoney().getAmount() - superPotion.getPrice());
//                    inventory.removeItem(superPotion);
//                }
//                else {
//                    popupStage.close();
//                    action.showPopup("nomoney", "Sorry, you don't have enough money!");
//                }
//            }
//
//            if (answer.equals("bomb")) {
//                Cell currentCell = this.cell;
//                Cell nextCell = currentCell.getNeighbor(0, 2);
//                Bomb bomb = (Bomb) inventory.getItems().stream().filter(item -> item instanceof Bomb).findFirst().get();
//                if (player.hasEnoughMoney(bomb)) {
//                    nextCell.setItem(bomb);
//                    player.getMoney().setAmount(player.getMoney().getAmount() - bomb.getPrice());
//                    inventory.removeItem(bomb);
//                }
//                else {
//                    popupStage.close();
//                    action.showPopup("nomoney", "Sorry, you don't have enough money!");
//                }
//            }
//
//            if (answer.equals("necklace")) {
//                Cell currentCell = this.cell;
//                Cell nextCell = currentCell.getNeighbor(0, 2);
//                Necklace necklace=(Necklace) inventory.getItems().stream().filter(item -> item instanceof Necklace).findFirst().get();
//                if (player.hasEnoughMoney(necklace)) {
//                nextCell.setItem(necklace);
//                player.getMoney().setAmount(player.getMoney().getAmount() - necklace.getPrice());
//                inventory.removeItem(necklace);}
//                else {
//                    popupStage.close();
//                    action.showPopup("nomoney", "Sorry, not enough money!");
//                }
//            }
//
//            popupStage.close();
//        });
//
//
//        // Layout for the pop-up window
//        VBox layout = new VBox(10, label, inputField, submitButton);
//        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");
//        Scene popupScene = new Scene(layout, 400, 300);
//
//        // Show the pop-up window
//        popupStage.setScene(popupScene);
//        popupStage.showAndWait(); // Show pop-up and wait for the user to close it
//    }

    public void interact(Player player) {
        player.addAlly(this);

        // Create the popup stage
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("Shopkeeper");

        // Create a label with shopkeeper's message
        Label label = new Label("Hello traveler, I'm the famous shopkeeper.\n " +
                "I have three wonderful objects for you: \n" +
                "1. Super potion (200 health), price: 100 gold.\n" +
                "2. Bomb (Press 'K' to kill all enemies nearby), price: 500 gold.\n" +
                "3. Necklace (Press 'N' to teleport to next stairs), price: 1000 gold.\n" +
                "Which one do you choose? Type 'superpotion', 'bomb', or 'necklace'."
        );

        TextField inputField = new TextField();
        Button submitButton = new Button("Submit");

        submitButton.setOnAction(e -> {
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
                    action.showPopup("error", "Invalid choice! Please type 'superpotion', 'bomb', or 'necklace'.");
                    break;
            }
        });

        // Layout for the pop-up window
        VBox layout = new VBox(10, label, inputField, submitButton);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");
        Scene popupScene = new Scene(layout, 400, 300);

        // Show the pop-up window
        popupStage.setScene(popupScene);
        popupStage.showAndWait(); // Show pop-up and wait for the user to close it
    }

    // Helper method to handle purchase logic
    private void processPurchase(Player player, String itemType, Stage popupStage) {
        Optional<Item> optionalItem = inventory.getItems().stream()
                .filter(item -> item.getClass().getSimpleName().equals(itemType))
                .findFirst();

        if (optionalItem.isPresent()) {
            ShopKeeperItems item =(ShopKeeperItems) optionalItem.get();
            if (player.hasEnoughMoney(item)) {
                // Place item in next cell and deduct money
                Cell currentCell = this.cell;
                Cell nextCell = currentCell.getNeighbor(0, 2);
                nextCell.setItem(item);
                player.getMoney().setAmount(player.getMoney().getAmount() - item.getPrice());
                inventory.removeItem(item);
                popupStage.close();
                action.showPopup("success", "You have successfully purchased the " + itemType + "!");
            } else {
                // Not enough money
                action.showPopup("nomoney", "Sorry, you don't have enough money for the " + itemType + "!");
            }
        } else {
            // Item not found in inventory
            action.showPopup("error", "Sorry, the shopkeeper doesn't have a " + itemType + "!");
        }
    }

}
