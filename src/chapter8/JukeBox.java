package chapter8;

import java.util.ArrayList;
import java.util.Random;

public class JukeBox {
	private enum PlayMode {
		Ascending_Order, Descending_Order, Random_Order;
	}
	private static JukeBox _instance = null;
	private CD current_cd;
	private Music current_music;
	private boolean is_pause;
	private PlayMode play_mode; // 1-ascending order 2-descending order 3-random order
	
	private JukeBox() {
		play_mode = PlayMode.Ascending_Order;
	}
	public static JukeBox getJukeBoxInstance() {
		if (_instance == null) {
			_instance = new JukeBox();
		}
		return _instance;
	}
	
	public void putCD(CD cd) {
		current_cd = cd;
	}
	
	public void play() {
		if (play_mode == PlayMode.Ascending_Order) {
			current_music = current_cd.getMusic(current_music.getIndex() + 1);
			if (current_music == null) stop();
		}
		else if (play_mode == PlayMode.Descending_Order) {
			current_music = current_cd.getMusic(current_music.getIndex() - 1);
			if (current_music == null) stop();
		}
		else {
			Random rand = new Random();
			int rand_index = rand.nextInt(current_cd.getMusicNumber());
			current_music = current_cd.getMusic(rand_index);
		}
		if (current_music != null) playMusic();
	}
	
	public void pause() {
		// pause and resume playing 
		if (is_pause) {
			// resume
		}
		else {
			// pause
		}
		is_pause = !is_pause;
	}
	
	public void stop() {
		current_music = null;
	}

	public boolean isPlaying() {
		return current_music != null;
	}
	
	// ============================================
	
	private void playMusic() {
		// current_music.getData();
	}
	
}

class CD {
	
	private ArrayList<Music> music_list;
	
	public CD() {
		
	}
	
	public Music getMusic(int index) {
		if (index >= music_list.size() || index < 0) {
			return null;
		}
		return music_list.get(index);
	}
	
	public int getMusicNumber() {
		return music_list.size();
	}
}

class Music {
	
	private int index;
	private Object data;
	
	public Music() {
		
	}
	
	public Object getData() {
		return data;
	}
	
	public int getIndex() {
		return index;
	}
}