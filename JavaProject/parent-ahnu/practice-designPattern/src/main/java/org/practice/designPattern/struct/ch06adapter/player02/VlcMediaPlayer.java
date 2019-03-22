package org.practice.designPattern.struct.ch06adapter.player02;

public class VlcMediaPlayer implements AdvancedMediaPlayer {

	@Override
	public void playVlc(String fileName) {
		System.out.println("VlcMediaPlayer.Playing vlc file. Name: " + fileName);
	}

	@Override
	public void playMp4(String fileName) {

	}

}
