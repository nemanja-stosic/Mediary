package main.model;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MusicPlayer {

	private Queue<Path> musicList = new LinkedList<>();
	
	private MediaPlayer mediaPlayer;

	public MusicPlayer() {

	}

	private void setupMusic() {
		if(musicList.peek() == null) return;
		
		mediaPlayer = new MediaPlayer(new Media(musicList.poll().toUri().toString()));
		
		mediaPlayer.setOnReady(() -> mediaPlayer.play());
		mediaPlayer.setOnEndOfMedia(() -> {
			mediaPlayer.dispose();
			setupMusic();
		});
		
	}
	
	public void playMusic(String folderUrl) {
		try {
			
			Files.find(Paths.get(folderUrl), 100, (p, a) -> p.toString().toLowerCase().endsWith(".mp3")).forEach(musicList::add);
			
			setupMusic();
		} catch (IOException e) {
			Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, "Failed Media player", e);
		} 
	}
	
	public void stopMusic() {
		if (mediaPlayer != null) {
			mediaPlayer.stop();
			mediaPlayer.dispose();
		}
	}
	
}
