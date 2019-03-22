package org.practice.designPattern.struct.ch06adapter;

import org.practice.designPattern.struct.ch06adapter.player01.MediaPlayer;
import org.practice.designPattern.struct.ch06adapter.player02.AdvancedMediaPlayer;
import org.practice.designPattern.struct.ch06adapter.player02.Mp4MediaPlayer;
import org.practice.designPattern.struct.ch06adapter.player02.VlcMediaPlayer;

/**
 * MediaPlayer 接口的适配器类
 * 
 * @author Administrator
 *
 */
public class MediaAdapter implements MediaPlayer {

	private AdvancedMediaPlayer advancedMusicPlayer;

	public MediaAdapter(String audioType) {
		if (audioType.equalsIgnoreCase("vlc")) {
			advancedMusicPlayer = new VlcMediaPlayer();
		} else if (audioType.equalsIgnoreCase("mp4")) {
			advancedMusicPlayer = new Mp4MediaPlayer();
		}
	}

	@Override
	public void play(String audioType, String fileName) {
		if (audioType.equalsIgnoreCase("vlc")) {
			advancedMusicPlayer.playVlc(fileName);
		} else if (audioType.equalsIgnoreCase("mp4")) {
			advancedMusicPlayer.playMp4(fileName);
		}
	}

}
