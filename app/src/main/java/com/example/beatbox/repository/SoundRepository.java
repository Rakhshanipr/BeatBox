package com.example.beatbox.repository;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import com.example.beatbox.model.Sound;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SoundRepository {
    public static final String TAG = "BeatBox";
    public static final int SOUND_PRIORITY = 0;

    //region defind variable

    AssetManager mAssetManager;

    SoundPool mSoundPool;

    List<Sound> mSoundList;

    //endregion

    //region defind static method and variable

    private static Context mContext;

    private static String PATH_SOUND = "sample_sound";

    public static SoundRepository sSoundRepository;

    public static SoundRepository getInstance(Context context) {
        if (sSoundRepository == null) {
            sSoundRepository = new SoundRepository(context);
        }
        return sSoundRepository;
    }

    //endregion


    public SoundPool getSoundPool() {
        return mSoundPool;
    }

    private SoundRepository(Context context) {
        //TODO: fill soundList
        mSoundList = new ArrayList<>();
        mContext = context.getApplicationContext();
        mAssetManager = mContext.getAssets();
        mSoundPool = new SoundPool(5, AudioManager.STREAM_NOTIFICATION, 0);

        try {
            String[] sounds = mAssetManager.list(PATH_SOUND);
            for (String soundName : sounds) {
                String path = PATH_SOUND + File.separator + soundName;
                Sound sound = new Sound(path);


                AssetFileDescriptor afd = mAssetManager.openFd(path);

                int soundId = mSoundPool.load(afd, SOUND_PRIORITY);
                sound.setSoundId(soundId);

                mSoundList.add(sound);


                Log.e(TAG, soundName);
            }
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public List<Sound> getSoundList() {
        return mSoundList;
    }

    public void setSoundList(List<Sound> soundList) {
        mSoundList = soundList;
    }


}
