package com.example.beatbox.repository;

import com.example.beatbox.model.Sound;

import java.util.ArrayList;
import java.util.List;

public class SoundRepository {

    //region defind variable
    List<Sound> mSoundList;

    //endregion

    //region defind static method and variable

    public static SoundRepository sSoundRepository;

    public static SoundRepository getInstance(){
        if (sSoundRepository==null){
            sSoundRepository=new SoundRepository();
        }
        return  sSoundRepository;
    }

    //endregion

    private SoundRepository(){
        //TODO: fill soundList
        mSoundList=new ArrayList<>();
    }

    public List<Sound> getSoundList() {
        return mSoundList;
    }

    public void setSoundList(List<Sound> soundList) {
        mSoundList = soundList;
    }
}
