package com.codecool.dungeoncrawl.logic;

public enum SOUND_TYPES {
    WINNER("/sound/free-music-in-my-mind-remake-26367.mp3"),
    START("/sound/robotic-countdown-43935.mp3"),
    GAME_OVER("/sound/stinger-3-38177.mp3"),
    MONSTER_ROAR("/sound/low-monster-roar-97413.mp3"),
    NEW_MAP("/sound/get_ready_to_the_next_fight_sielxm3d-83870.mp3");


    private String source;

    SOUND_TYPES(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }
}
