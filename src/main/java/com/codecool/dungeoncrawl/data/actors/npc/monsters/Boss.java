package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.logic.SOUND_TYPES;
import com.codecool.dungeoncrawl.logic.SoundPlayer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.Random;

public class Boss extends Monsters {
    private static final int BASIC_HEALTH = 250;
    private static final int BASIC_ATTACK = 158;
    private static final int BASIC_MOVE=1;


    public Boss(Cell cell) {
        super(cell, BASIC_HEALTH, BASIC_ATTACK, BASIC_MOVE,0);
    }

    @Override
    public void interact(Player player) {
        while (health >= 0 && player.getHealth() >= 0) {
            this.setHealth(health - player.getAttack());
            player.setHealth(player.getHealth() - attack);
        }

        if (player.getHealth() <= 0) {
            gameOver();
        }

        if (this.getHealth() <= 0) {
            winTheGame();
        }
    }

    private void winTheGame() {
        this.getCell().setActor(null);
        this.getCell().setType(CellType.BOSS_FLOOR);
        SoundPlayer monsterRoar = new SoundPlayer(SOUND_TYPES.MONSTER_ROAR);
        monsterRoar.play();
        action.showPopup("Winning", "Congratulations! You won!");
        Timeline soundTimeline = new Timeline(
                new KeyFrame(Duration.seconds(2), event -> {
                    SoundPlayer winnerSound = new SoundPlayer(SOUND_TYPES.WINNER);
                    winnerSound.play();
                    Timeline stopWinnerSoundTimeline = new Timeline(new KeyFrame(
                            Duration.seconds(14),
                            e -> {
                                winnerSound.stop();
                            }
                    ));
                    stopWinnerSoundTimeline.setCycleCount(1);
                    stopWinnerSoundTimeline.play();
                    Timeline exitTimeline = new Timeline(new KeyFrame(
                            Duration.seconds(16),
                            e -> System.exit(0)
                    ));
                    exitTimeline.setCycleCount(1);
                    exitTimeline.play();
                })
        );
        soundTimeline.setCycleCount(1);
        soundTimeline.play();
    }

    private void gameOver() {
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


    @Override
    public void automaticMove() {
        super.automaticMove();

    }

    @Override
    public String getTileName() {
        return "boss";
    }


}
