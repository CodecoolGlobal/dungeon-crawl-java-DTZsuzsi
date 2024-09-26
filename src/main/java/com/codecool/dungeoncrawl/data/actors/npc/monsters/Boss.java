package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.logic.SOUND_TYPES;
import com.codecool.dungeoncrawl.logic.SoundPlayer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Boss extends Monsters {
    private static final int BASIC_HEALTH=250;
    private static final int BASIC_ATTACK=158;
    public Boss(Cell cell) {
        super(cell, BASIC_HEALTH, BASIC_ATTACK);
    }

    @Override
    public  void interact(Player player){

        while (health >= 0 && player.getHealth() >= 0) {
            this.setHealth(health-player.getAttack());
            player.setHealth(player.getHealth()-attack);

        }
        if (player.getHealth() <= 0) {
            this.action.showPopup("Game over", "Sorry, you've died! Game over!");
        }

        if (this.getHealth() <= 0) {
            this.getCell().setActor(null);
            this.getCell().setType(CellType.BOSSFLOOR);
            action.showPopup("Winning", "Congratulations! You won!");
            SoundPlayer winnerSound = new SoundPlayer(SOUND_TYPES.WINNER);
            winnerSound.play();
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.seconds(14),
                    event -> System.exit(0)
            ));

            timeline.setCycleCount(1);
            timeline.play();

        }
    }



    @Override
    public void automaticMove() {

    }

    @Override
    public String getTileName() {
        return "boss";
    }


}
