package com.example.beatbox.utils;

import android.media.SoundPool;

import com.example.beatbox.model.Sound;

public class SoundUtils {
    public static void Play(SoundPool soundPool,Sound sound){
        if (sound.getSoundId()==null)
            return;
        int streamId=soundPool.play(sound.getSoundId(),
                1.0f,
                1.0f,
                0,
                0,
                1.0f);
    }
}
