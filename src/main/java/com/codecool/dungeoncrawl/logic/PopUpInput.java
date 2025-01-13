package com.codecool.dungeoncrawl.logic;

import javafx.application.Application;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.Optional;

public class PopUpInput extends Application {
private String result;
    @Override
    public void start(Stage primaryStage) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("User Input Dialog");
        dialog.setHeaderText("Hi. I'm the famous shopkeeper. I have a lot's of great item for you");
        dialog.setContentText("Do you want it?");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(answer -> {
            System.out.println("User's answer: " + answer);
            this.result = answer;
        });
    }


}
