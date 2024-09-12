package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;
import com.codecool.dungeoncrawl.data.interactions.Interaction;
import com.codecool.dungeoncrawl.logic.Action;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health ;
    private Action action;
    private int attack;
    private Interaction interaction;

    public int getAttack(){
        return attack;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }

    public Actor(Cell cell, int health, int attack,  Interaction interaction) {
        this.cell = cell;
        this.cell.setActor(this);
        this.action=new Action(cell);
        this.health = health;
        this.attack=attack;
        this.interaction=interaction;

    }

    public void move(int dx, int dy) {

     Cell nextCell = cell.getNeighbor(dx, dy);
       if(nextCell.getActor()!=null) {
           action.meetingOtherActor(nextCell);
       }
//       if(nextCell.getType().getTileName()=="stairs"){
//           System.out.println("stairs");
//           action.changingMap();
//       }
        if (checkIfYouCanMoveToNextCell(dx, dy)){
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;

            if (this instanceof Player) {
                Player player = (Player) this;
                action.findADoor(nextCell);
                action.pickUpItem(player);

            }
        }
    }

    public boolean checkIfYouCanMoveToNextCell(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);


        if (nextCell.getType().getTileName() == "wall"||nextCell.getType().getTileName()=="forest") {
            return false;
        } else if (nextCell.getActor() != null) {
            return false;
        }
        return true;
    }

public void makeInteraction(Player player, Actor otherActor) {
        this.interaction.interact(player, otherActor);
}
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }


}
