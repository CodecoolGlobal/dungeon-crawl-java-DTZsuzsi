package com.codecool.dungeoncrawl.logic;

import javafx.application.Application;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.Optional;

public class PopUpInput extends Application {
private String result;
    @Override
    public void start(Stage primaryStage) {
        // Create a TextInputDialog
        TextInputDialog dialog = new TextInputDialog();
//        dialog.setTitle("User Input Dialog");
//        dialog.setHeaderText("Hi. I'm the famous shopkeeper. I have a lot's of great item for you");
//        dialog.setContentText("Do you want it?");
        dialog.setTitle("Shopkeeper's Offer");
        dialog.setHeaderText("Greetings, brave warrior! I'm the renowned shopkeeper with rare and valuable items.");
        dialog.setContentText("Would you like to make a purchase?");

        // Show the dialog and capture the input
        Optional<String> result = dialog.showAndWait();

        // Handle the input
        result.ifPresent(answer -> {
            System.out.println("User's answer: " + answer);
            this.result = answer;
        });
    }

    public String getResult() {
        return result;
    }
}
