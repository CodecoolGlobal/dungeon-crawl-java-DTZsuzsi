package com.codecool.dungeoncrawl.data.interactions;

import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Player;

public class Healing extends Interaction {
    private int HealthPlus;
    public Healing(String name, int healthPlus) {
        super("healing");
        this.HealthPlus = healthPlus;
    }

    @Override
    public void interact(Player player, Actor actor) {
        player.setHealth(player.getHealth()+HealthPlus);
    }
}
