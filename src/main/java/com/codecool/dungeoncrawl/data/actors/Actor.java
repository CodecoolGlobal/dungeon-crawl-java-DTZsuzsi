package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;
import com.codecool.dungeoncrawl.logic.Action;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health = 10;
    private Action action;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
        this.action=new Action(cell);

    }

    public void move(int dx, int dy) {
     Cell nextCell = cell.getNeighbor(dx, dy);
if (nextCell.getActor()!=null){
    System.out.println("attack");
    action.attack(nextCell);
}

        if (isTheNeighborGood(dx, dy)){

        cell.setActor(null);
        nextCell.setActor(this);
        cell = nextCell;}
    }

    public boolean isTheNeighborGood(int dx, int dy) {
       Cell nextCell = cell.getNeighbor(dx, dy);
      if (nextCell.getY()<2 || nextCell.getX()<2){
          return false;
      }

       if (nextCell.getType().getTileName()=="wall"){
           return false;
       }

       else if(nextCell.getActor()!=null){
           return false;
       }
       return true;
    }



    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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
