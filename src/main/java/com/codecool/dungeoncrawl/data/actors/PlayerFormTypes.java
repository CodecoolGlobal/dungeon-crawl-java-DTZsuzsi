package com.codecool.dungeoncrawl.data.actors;

public enum PlayerFormTypes {
    PLAYER_SHIELD_SWORD("playerShieldSword"),
    PLAYER_BASIC("playerBasic"),
    PLAYER_SWORD("playerSword"),
    PLAYER_SWORD_SHIELD_HELMET("playerSwordShieldHelmet"),
    PLAYER_SUPERSWORD_SHIELD_HELMET("playerSuperSwordShieldHelmet"),
    PLAYER_HELMET("playerHelmet"),
    PLAYER_SUPER("playerSuper");

    private String tileName;

    PlayerFormTypes(String tileName) {
        this.tileName = tileName;
    }

    public static PlayerFormTypes getEnumByTileName(String tileName) {
        for (PlayerFormTypes value : PlayerFormTypes.values()) {
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
