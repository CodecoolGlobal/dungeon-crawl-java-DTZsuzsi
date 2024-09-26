package com.codecool.dungeoncrawl.data.actors.npc.allies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.npc.NPC;

import java.util.Objects;

public abstract class Ally extends NPC {
    protected String message;

    public Ally(Cell cell, int health, int attack, String message) {
        super(cell, health, attack);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ally ally = (Ally) o;
        return Objects.equals(message, ally.message);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(message);
    }
}
