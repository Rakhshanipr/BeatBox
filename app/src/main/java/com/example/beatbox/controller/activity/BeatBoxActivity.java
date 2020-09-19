package com.example.beatbox.controller.activity;

import androidx.fragment.app.Fragment;

import com.example.beatbox.R;
import com.example.beatbox.controller.fragment.BeatBoxFragment;

public class BeatBoxActivity extends SingleFragmentActivity {


    @Override
    public Fragment createFragment() {
        return BeatBoxFragment.newInstance();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_beat_box;
    }
}