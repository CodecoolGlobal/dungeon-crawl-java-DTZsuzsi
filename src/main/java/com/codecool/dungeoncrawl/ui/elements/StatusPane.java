package com.codecool.dungeoncrawl.ui.elements;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class StatusPane {
    public static final int RIGHT_PANEL_WIDTH = 250;
    public static final int RIGHT_PANEL_PADDING = 10;
    private GridPane ui;
    private Label healthBarValue;
    private Label healthTextLabel;
    private Label healthValueLabel;
    private Label attackTextLabel;
    private Label attackValueLabel;
    private Label inventoryTextLabel;
    private Label inventoryValueLabel;
    private Label friendTextLabel;
    private Label friendValueLabel;

    public StatusPane() {
        ui = new GridPane();
        healthBarValue = new Label();
        healthTextLabel = new Label("Health: ");
        healthValueLabel = new Label();
        attackTextLabel = new Label("Attack Power: ");
        attackValueLabel = new Label();
        inventoryTextLabel = new Label("Inventory: ");
        inventoryValueLabel = new Label();
        friendTextLabel = new Label("Friends: ");
        friendValueLabel = new Label();


    }

    public BorderPane build() {

        ui.setPrefWidth(RIGHT_PANEL_WIDTH);
        ui.setPadding(new Insets(RIGHT_PANEL_PADDING));
        ui.add(healthBarValue, 0, 0);
        ui.add(healthTextLabel, 0, 1);
        ui.add(healthValueLabel, 1, 1);
        ui.add(attackTextLabel, 0, 2);
        ui.add(attackValueLabel, 1, 2);
        ui.add(inventoryTextLabel, 0, 3);
        ui.add(inventoryValueLabel, 0, 4);
        ui.add(friendTextLabel, 0, 5);
        ui.add(friendValueLabel, 0, 6);


        BorderPane borderPane = new BorderPane();
        borderPane.setRight(ui);
        return borderPane;
    }

    public void setHealthValue(String text) {
        healthValueLabel.setText(text);
    }

    public void setAttackValue(String text) {
        attackValueLabel.setText(text);
    }

    public void setInventoryValue(String text) {
        inventoryValueLabel.setText(text);
    }

    public void setFriendValue(String text) {
        friendValueLabel.setText(text);
    }

    public void setHealthBarValue(String text) {
        healthBarValue.setText(text);
    }


}
