package org.practice.designPattern.struct.ch06adapter;

import org.practice.designPattern.struct.ch06adapter.player01.MediaPlayer;
import org.practice.designPattern.struct.ch06adapter.player02.AdvancedMediaPlayer;
import org.practice.designPattern.struct.ch06adapter.player02.Mp4MediaPlayer;
import org.practice.designPattern.struct.ch06adapter.player02.VlcMediaPlayer;

/**
 * @Desc 适配器模式
 * http://www.runoob.com/design-pattern/adapter-pattern.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012年7月4日
 * <p>
 * @Version 1.0
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
