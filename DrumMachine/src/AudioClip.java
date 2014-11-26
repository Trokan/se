import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioClip{
	private Clip clip;
	private int framePosition;
	public void open(File file) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
		framePosition = 0;
		clip = AudioSystem.getClip();
		clip.open(audioInputStream);
	}
	
	
	public void setLoopEnabled(boolean enabled){
		if (enabled == true){
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}
	}
	public void start(){
		clip.setFramePosition(framePosition);
		clip.start();
	}
	public void stop(){
		clip.stop();
		framePosition = 0;
	}
	public void pause(){
		clip.stop();
		framePosition = clip.getFramePosition();
	}
	

	public AudioFormat getFormat() {
		if (clip == null){
			return null;
		}
		return clip.getFormat();
	}
}