package com.codecool.dungeoncrawl.logic;


    import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

    public class GameOverPopup extends Application {

        @Override
        public void start(Stage primaryStage) {
            // Call this method when the game is over
            showGameOverPopup();
        }

        private void showGameOverPopup() {
            // Create an Alert of type INFORMATION
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Game Over");
            alert.setHeaderText(null);
            alert.setContentText("Game Over!");


            alert.showAndWait();
        }

        public static void main(String[] args) {
            launch(args);
        }


}
