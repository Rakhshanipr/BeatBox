package com.example.beatbox.model;

import java.io.File;

public class Sound {
    private String mName;
    private String mAssetPath;
    private Integer soundId;

    public Sound(String assetPath) {
        mAssetPath = assetPath;
        mName= extractNameFromAssetPath(assetPath);
    }

    private String extractNameFromAssetPath(String assetPath) {
        String fileName=assetPath.split(File.separator)[1];
        fileName=fileName.substring(0,fileName.lastIndexOf('.'));
        return fileName;
    }

    public Integer getSoundId() {
        return soundId;
    }

    public void setSoundId(int soundId) {
        this.soundId = soundId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getAssetPath() {
        return mAssetPath;
    }

    public void setAssetPath(String assetPath) {
        mAssetPath = assetPath;
    }
}
