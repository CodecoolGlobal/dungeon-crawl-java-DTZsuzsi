package com.codecool.dungeoncrawl.data.actors.npc.allies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.items.Healers.SuperPotion;
import com.codecool.dungeoncrawl.data.items.Inventory;
import com.codecool.dungeoncrawl.logic.PopUpInput;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class ShopKeeper extends Ally {
    private Inventory inventory;
    private final static int BASIC_HEALTH = 25;
    private final static int BASIC_ATTACK = 0;
    public ShopKeeper(Cell cell) {
        super(cell, BASIC_HEALTH, BASIC_ATTACK);
        inventory = new Inventory();
        inventory.addItem(new SuperPotion(false));
    }

    @Override
    public String getTileName() {
        return "shopKeeper";
    }

    @Override
    public void interact(Player player) {

                // When this method is called, show a custom popup

                // Create a new Stage (pop-up)
                Stage popupStage = new Stage();
                popupStage.initModality(Modality.APPLICATION_MODAL); // Block interaction with other windows
                popupStage.setTitle("NPC Interaction");

                // Add a label and text field to simulate input (e.g., player response)
                Label label = new Label("Hello traveler, I'm the famous shopkeeper.\n " +
                        " Do you want my potion? (yes/no)");
                TextField inputField = new TextField();
                Button submitButton = new Button("Submit");

                // When the player submits their name, you can process it
                submitButton.setOnAction(e -> {
                    String answer = inputField.getText();

                    if (answer.equals("yes")) {
                  Cell currentCell=  this.cell;
                    Cell nextCell=currentCell.getNeighbor(0,2);
                    nextCell.setItem(new SuperPotion(true));
                    player.getMoney().setAmount(player.getMoney().getAmount()-100);
                    }

                    popupStage.close(); // Close the pop-up when done
                });



                // Layout for the pop-up window
                VBox layout = new VBox(10, label, inputField, submitButton);
                layout.setStyle("-fx-padding: 20; -fx-alignment: center;");
                Scene popupScene = new Scene(layout, 300, 150);

                // Show the pop-up window
                popupStage.setScene(popupScene);
                popupStage.showAndWait(); // Show pop-up and wait for the user to close it
            }




}
