package com.codecool.dungeoncrawl.logic;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundPlayer {
    private MediaPlayer mediaPlayer;
    private SOUND_TYPES sound_type;
    private Media sound;

        public SoundPlayer(SOUND_TYPES sound_type) {
           this.sound_type = sound_type;
            try {
                // Load the sound file from the resources folder
                 sound = new Media(getClass().getResource(sound_type.getSource()).toString());
                mediaPlayer = new MediaPlayer(sound);
            } catch (Exception e) {
                System.out.println("Error loading sound file: " + e.getMessage());
                e.printStackTrace();
            }
        }

        // Method to play the sound
        public void play() {
            mediaPlayer.play();
        }

        // Method to stop the sound
        public void stop() {
            mediaPlayer.stop();
        }
    }


