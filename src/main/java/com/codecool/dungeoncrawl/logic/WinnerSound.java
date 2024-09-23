//package com.codecool.dungeoncrawl.logic;
//
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//
//public class WinnerSound {
//    private MediaPlayer mediaPlayer;
//
//    public WinnerSound(String s) {
//        try {
//            // Load the sound file from the resources folder
//            Media sound = new Media(getClass().getResource("/sound/free-music-in-my-mind-remake-26367.mp3").toString());
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
