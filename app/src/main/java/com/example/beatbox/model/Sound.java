package com.example.beatbox.model;

public class Sound {
    private String mName;
    private String mAssetPath;

    public Sound(String name, String assetPath) {
        mName = name;
        mAssetPath = assetPath;
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
