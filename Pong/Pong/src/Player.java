import javax.swing.*;
import javax.sound.sampled.*;
import java.io.*;

public class Player
{
	
	public void bounce(String bounce) {
		File soundFile = new File(bounce);
		try {
			Clip clip = AudioSystem.getClip();
			AudioInputStream inputStream= AudioSystem.getAudioInputStream(soundFile);
			clip.open(inputStream);
			clip.start();
		}
	catch(Exception e)
		{
		System.out.println(e);
		}
	}
	
	public void win(String win) {
		File soundFile = new File(win);
		try {
			Clip clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(soundFile);
			clip.open(inputStream);
			clip.start();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void loss(String loss) {
		File soundFile = new File (loss);
		try {
			Clip clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(soundFile);
			clip.open(inputStream);
			clip.start();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}