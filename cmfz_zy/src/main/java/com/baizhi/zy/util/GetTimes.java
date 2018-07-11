package com.baizhi.zy.util;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;

import java.io.File;

public class GetTimes {

    public static String getTimes(File file){
        MP3AudioHeader audioHeader = null;
        try {
            MP3File f = (MP3File)AudioFileIO.read(file);
            audioHeader = (MP3AudioHeader)f.getAudioHeader();

        } catch(Exception e) {
            e.printStackTrace();
        }
        return changeTime(audioHeader.getTrackLength());
    }

    public static String changeTime(long time){
        if(time > 60){
            long minutes = time / 60;
            long remainingSeconds = time % 60;
            return minutes+"M"+remainingSeconds+"s";
        }else
            return time+"";

    }


}
