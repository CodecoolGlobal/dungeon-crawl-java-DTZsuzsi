package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health = 10;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public void move(int dx, int dy) {
     Cell nextCell = cell.getNeighbor(dx, dy);

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
