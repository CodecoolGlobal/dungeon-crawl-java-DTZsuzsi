package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.npc.allies.Ally;
import com.codecool.dungeoncrawl.data.actors.npc.monsters.Monsters;
import com.codecool.dungeoncrawl.data.items.Item;
import javafx.scene.control.Alert;
import com.codecool.dungeoncrawl.data.items.*;


public class Action {
   private Actor actor;
   private Cell cell;

    public Action(Cell cell) {
        this.cell=cell;
        this.actor = cell.getActor();
    }


    public void pickUpItem(Player player){
        Cell currentCell = player.getCell();
        Item item = currentCell.getItem();

        if (item != null && item.isPickable()){
            if (item instanceof Mace) {
                player.setAttack(player.getAttack() + 5);
            } else if (item instanceof Helmet || item instanceof  Potion) {
                player.setHealth(player.getHealth() + 3);
            }
            else if(item instanceof Crown){
                showPopup("Winning", "Congratulations! You won!");

            }
            player.addPickedUpItem(item);
            currentCell.setItem(null);
        }
}


    public void meetingOtherActor(Cell nextCell) {


        if (actor instanceof Player && nextCell.getActor()!=null) {
            Player player = (Player) actor;
            if (nextCell.getActor() instanceof Ally) {
                ((Ally) nextCell.getActor()).interact(player);
            }
            if (nextCell.getActor() instanceof Monsters) {
                ((Monsters) nextCell.getActor()).interact(player);
            }
        }
    }

    public void showPopup(String title, String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
        System.exit(0);
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
