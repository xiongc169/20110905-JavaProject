package com.yoong.designPattern.struct.ch06adapter.player02;

public class Mp4MediaPlayer implements AdvancedMediaPlayer {

	@Override
	public void playVlc(String fileName) {

	}

	@Override
	public void playMp4(String fileName) {
		System.out.println("Mp4MediaPlayer.Playing mp4 file. Name: " + fileName);
	}

}
