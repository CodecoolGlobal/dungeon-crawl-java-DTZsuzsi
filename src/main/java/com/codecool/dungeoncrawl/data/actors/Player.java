package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

import java.util.ArrayList;
import java.util.List;

public class Player extends Actor {
    public Player(Cell cell) {
        super(cell);
    }

    public String getTileName() {
        return "player";
    }

//    public void attack(){
//        List<Cell> neighboringCells=new ArrayList<>();
//        for (int i=-1; i<=1;i++){
//            for (int j=-1; j<=1;j++){
//                Cell cell=getCell();
//                neighboringCells.add(cell.getNeighbor(i,j));
//            }
//        }
//        for (Cell cell:neighboringCells){
//            if (cell.getActor()!=null)
//        }
//    }


}
