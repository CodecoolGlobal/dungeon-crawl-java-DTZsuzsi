package com.codecool.dungeoncrawl.data.interactions;

import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Player;

public abstract class Interaction {

    private String name;

    public Interaction(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract void interact(Player player, Actor actor);
}
