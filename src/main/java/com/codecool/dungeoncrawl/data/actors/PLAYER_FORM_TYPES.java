package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.ui.Tiles;

public enum PLAYER_FORM_TYPES {
PLAYER_SHIELD_SWORD("playerShieldSword"),
    PLAYER_BASIC ("playerBasic"),
    PLAYER_SWORD("playerSword"),
    PLAYER_SWORD_SHIELD_HELMET("playerSwordShieldHelmet"),
    PLAYER_SUPERSWORD_SHIELD_HELMET("playerSuperSwordShieldHelmet"),
    PLAYER_HELMET ("playerHelmet"),
    PLAYER_SUPER("playerSuper"),;

private String tileName;

    PLAYER_FORM_TYPES(String tileName) {
        this.tileName = tileName;
    }

    public static PLAYER_FORM_TYPES getEnumByTileName(String tileName) {
        for (PLAYER_FORM_TYPES value : PLAYER_FORM_TYPES.values()) {
            if (value.getTileName().equals(tileName)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid tile name: " + tileName);
    }

    public String getTileName() {
        return tileName;
    }
}
