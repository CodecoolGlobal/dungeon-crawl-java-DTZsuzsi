package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.npc.NPC;

import com.codecool.dungeoncrawl.data.items.Item;
import com.codecool.dungeoncrawl.data.items.attacking.AttackPlus;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Alert;
import com.codecool.dungeoncrawl.data.items.*;
import javafx.util.Duration;


public class Action {

   private Actor actor;
   private Cell cell;


    public Action(Cell cell) {
        this.cell = cell;
        this.actor = cell.getActor();
    }


    public void pickUpItem(Player player){
        Cell currentCell = player.getCell();
        Item item = currentCell.getItem();

        if (item != null ) {
            if (item instanceof HealthPlus) {
                ((HealthPlus) item).heal(player);
            }

            if (item instanceof AttackPlus) {
                ((AttackPlus) item).attackPlus(player);
            }

            if (item.isPickable()){
                player.getInventory().addItem(item);
            }
            if (item instanceof ChangingPlayerForm){
                ((ChangingPlayerForm) item).changePlayer(player);
            }
            currentCell.setItem(null);
        }}

    public void meetingOtherActor(Cell nextCell) {


        if (actor instanceof Player && nextCell.getActor() != null) {
            Player player = (Player) actor;
            if (nextCell.getActor() instanceof NPC ) {
                ((NPC) nextCell.getActor()).interact(player);
            }

        }
    }

    public void showPopup(String title, String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(14),
                event -> System.exit(0)
        ));

        timeline.setCycleCount(1);
        timeline.play();
    }

//    public void findADoor(Cell nextCell) {
//        if (nextCell.getItem() != null && nextCell.getItem().getTileName().equals("door") && actor instanceof Player) {
//            Item key = new Key();
//            Player player = (Player) actor;
//            if (player.isItemInInventory(key)) {
//                player.removeItem(key);
//            }
//        }
//    }
}
