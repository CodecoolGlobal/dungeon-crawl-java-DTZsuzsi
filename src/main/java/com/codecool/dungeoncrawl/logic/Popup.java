package com.codecool.dungeoncrawl.logic;


    import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

    public class Popup extends Application {

        @Override
        public void start(Stage primaryStage) {

            showGameOverPopup();
        }

        private void showGameOverPopup() {

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
