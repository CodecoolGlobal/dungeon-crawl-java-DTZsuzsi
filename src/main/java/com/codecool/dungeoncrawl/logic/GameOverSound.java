//package com.codecool.dungeoncrawl.logic;
//
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//
//public class GameOverSound {
//
//    private MediaPlayer mediaPlayer;
//
//    // Constructor to load and prepare the sound file
//    public GameOverSound(String s) {
//        try {
//            // Load the sound file from the resources folder
//            Media sound = new Media(getClass().getResource("/stinger-3-38177.mp3").toString());
//            mediaPlayer = new MediaPlayer(sound);
//        } catch (Exception e) {
//            System.out.println("Error loading sound file: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//    // Method to play the sound
//    public void play() {
//        mediaPlayer.play();
//    }
//
//    // Method to stop the sound
//    public void stop() {
//        mediaPlayer.stop();
//    }
//}