package sound;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

	Clip clip;
	URL soundURL[] = new URL[12];
	
	public Sound() {
		soundURL[0] = getClass().getResource("/audio/menuSelectionClick.wav");
		soundURL[1] = getClass().getResource("/audio/sfx_coin_single6.wav");
		soundURL[2] = getClass().getResource("/audio/sfx_coin_single1.wav");
		soundURL[3] = getClass().getResource("/audio/sfx_movement_jump2.wav");
		soundURL[4] = getClass().getResource("/audio/sfx_sounds_fanfare1.wav");
		soundURL[5] = getClass().getResource("/audio/sfx_sound_shutdown2.wav");
		soundURL[6] = getClass().getResource("/audio/sfx_sounds_fanfare1_reverse.wav");
		soundURL[7] = getClass().getResource("/audio/juhani_junkala_retro_bg_lvl1_music.wav");
		soundURL[8] = getClass().getResource("/audio/juhani_junkala_retro_bg_lvl2_music.wav");
		soundURL[9] = getClass().getResource("/audio/juhani_junkala_retro_bg_lvl3_music.wav");
		soundURL[10] = getClass().getResource("/audio/juhani_junkala_title_screen_music.wav");
		soundURL[11] = getClass().getResource("/audio/juhani_junkala_game_over.wav");
	}
	
	public void setFile(int i) {
		try {
			
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
		}
		catch(Exception e){
			
		}
		
	}
	
	public void play() {
		clip.start();
	}
	
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stop() {
		clip.stop();
		
	}
}
