package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.npc.NPC;

import com.codecool.dungeoncrawl.data.items.Item;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Alert;
import com.codecool.dungeoncrawl.data.items.*;
import javafx.util.Duration;


public class Action {
   private Actor actor;
   private Cell cell;
   private SoundPlayer winnerSound;

    public Action(Cell cell) {
        this.cell=cell;
        this.actor = cell.getActor();
        this.winnerSound=new SoundPlayer(SOUND_TYPES.WINNER);
    }


    public void pickUpItem(Player player){
        Cell currentCell = player.getCell();
        Item item = currentCell.getItem();

        if (item != null && item.isPickable()){
            if (item instanceof Mace) {
                player.setAttack(player.getAttack() + 5);
            } else if (item instanceof Helmet || item instanceof Potion) {
                player.setHealth(player.getHealth() + 3);
            }
            else if(item instanceof Crown){
                player.setAttack(player.getAttack()+90);
//                showPopup("Winning", "Congratulations! You won!");

            }
            player.addPickedUpItem(item);
            currentCell.setItem(null);
        }
}


    public void meetingOtherActor(Cell nextCell) {


        if (actor instanceof Player && nextCell.getActor()!=null) {
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
        winnerSound.play();
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(14),
                event -> System.exit(0)
        ));

        timeline.setCycleCount(1);
        timeline.play();
    }

    public void findADoor(Cell nextCell){
           if (nextCell.getItem()!=null && nextCell.getItem().getTileName().equals("door") && actor instanceof Player){
             Item key = new Key();
           Player player = (Player) actor;
         if (player.isItemInInventory(key)) {
           player.removeItem(key);
        }
        }
    }
}
