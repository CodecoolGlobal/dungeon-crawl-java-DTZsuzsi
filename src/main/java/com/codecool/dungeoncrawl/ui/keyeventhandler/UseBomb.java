package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMap;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class UseBomb implements KeyHandler {
    public  final KeyCode code=KeyCode.K;
    @Override
    public void perform(KeyEvent event, GameMap map) {
        if (code.equals(event.getCode())&&map.getPlayer().getInventory().getBomb()!=null) {
            map.getPlayer().getInventory().getBomb().kill(map.getPlayer());
        }

    }
}


