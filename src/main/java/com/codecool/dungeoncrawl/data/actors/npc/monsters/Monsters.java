package com.codecool.dungeoncrawl.data.actors.npc.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Interaction;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.npc.NPC;
import com.codecool.dungeoncrawl.logic.SOUND_TYPES;
import com.codecool.dungeoncrawl.logic.SoundPlayer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.Random;

public abstract class Monsters extends NPC implements Interaction {
public int dxMove;
public int dyMove;
    public Monsters(Cell cell, int health, int attack, int dxMove, int dyMove) {
        super(cell, health, attack);
        this.dxMove = dxMove;
        this.dyMove = dyMove;
    }

    @Override
    public String getTileName() {
        return "";
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
            System.out.println("winner sound");
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.seconds(14),
                    event -> System.exit(0)
            ));

            timeline.setCycleCount(1);
            timeline.play();
        }
        if (health <= 0) {
            cell.setActor(null);
        }
    }

    public void monsterMove(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.getActor() instanceof Player) {
            interact((Player) nextCell.getActor());
        }
        if (nextCell.isWalkable()) {
            cell.setActor(null);
            nextCell.setActor(this);
            this.setCell(nextCell);
        }
    }

    public  void automaticMove(){
        Random random = new Random();
        if (this.getHealth()>=0){
            if(dxMove==0){
                this.monsterMove(0, random.nextInt(3)-dyMove);
            }
            if(dyMove==0){
                this.monsterMove(random.nextInt(3)-dxMove,0);
            }
            this.monsterMove(random.nextInt(3)-dxMove, random.nextInt(3)-dyMove);}
    };


}