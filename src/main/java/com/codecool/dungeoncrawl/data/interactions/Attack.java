package com.codecool.dungeoncrawl.data.interactions;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Player;
import javafx.scene.control.Alert;

public class Attack extends Interaction {
    public Attack(String name) {
        super(name);
    }

    @Override
    public void interact(Player player, Actor enemy) {

        Cell enemyCell=enemy.getCell();

        while(enemy.getHealth()>=0&&player.getHealth()>=0){
            enemy.setHealth(enemy.getHealth()-5);
            player.setHealth(player.getHealth()-2);
            System.out.println(player.getHealth());
            System.out.println(enemy.getHealth());
        }
        if (player.getHealth()<=0){
            showGameOverPopup();
        }

        if (enemy.getHealth()<=0){
            enemyCell.setActor(null);
        }
    }

    private void showGameOverPopup() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText("Game Over! Better luck next time.");
        alert.showAndWait();
        System.exit(0);



    }
}
