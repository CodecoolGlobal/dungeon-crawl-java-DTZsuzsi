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
    private static final int BASIC_HEALTH = 250;
    private static final int BASIC_ATTACK = 158;

    public Boss(Cell cell) {
        super(cell, BASIC_HEALTH, BASIC_ATTACK);
    }

    @Override
    public void interact(Player player) {

        while (health >= 0 && player.getHealth() >= 0) {
            this.setHealth(health - player.getAttack());
            player.setHealth(player.getHealth() - attack);
        }

        if (player.getHealth() <= 0) {
            this.action.showPopup("Game over", "Sorry, you've died! Game over!");
            SoundPlayer gameOver = new SoundPlayer(SOUND_TYPES.GAME_OVER);
            gameOver.play();
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.seconds(14),
                    event -> System.exit(0)
            ));
            timeline.setCycleCount(1);
            timeline.play();
        }

        if (this.getHealth() <= 0) {
            this.getCell().setActor(null);
            this.getCell().setType(CellType.BOSSFLOOR);

            // Play monster roar first
            SoundPlayer monsterRoar = new SoundPlayer(SOUND_TYPES.MONSTER_ROAR);
            monsterRoar.play();
            action.showPopup("Winning", "Congratulations! You won!");

            // Chain the events: first, wait for the roar to finish, then play the winner sound
            Timeline soundTimeline = new Timeline(
                    new KeyFrame(Duration.seconds(2), event -> {
                        // Play winner sound after roar finishes
                        SoundPlayer winnerSound = new SoundPlayer(SOUND_TYPES.WINNER);
                        winnerSound.play();

                        // Schedule winner sound to stop after 14 seconds
                        Timeline stopWinnerSoundTimeline = new Timeline(new KeyFrame(
                                Duration.seconds(14),
                                e -> {
                                    winnerSound.stop();
                                }
                        ));
                        stopWinnerSoundTimeline.setCycleCount(1);
                        stopWinnerSoundTimeline.play();

                        // Exit the game after showing the popup and allowing the winner sound to finish
                        Timeline exitTimeline = new Timeline(new KeyFrame(
                                Duration.seconds(16), // Wait slightly longer than the winner sound to ensure popup is visible
                                e -> System.exit(0)
                        ));
                        exitTimeline.setCycleCount(1);
                        exitTimeline.play();
                    })
            );
            soundTimeline.setCycleCount(1);
            soundTimeline.play();
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
