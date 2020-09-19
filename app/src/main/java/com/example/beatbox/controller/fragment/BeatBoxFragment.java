package com.example.beatbox.controller.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.beatbox.R;
import com.example.beatbox.model.Sound;
import com.example.beatbox.repository.SoundRepository;

import java.util.List;


public class BeatBoxFragment extends Fragment {
    public static final int SPAN_COUNT = 2;
    //region defind variable
    private RecyclerView mRecyclerView;
    private SoundListAdapter mSoundListAdapter;
    SoundRepository mSoundRepository;

    //endregion

    //regiondefind static method and variable

    public static BeatBoxFragment newInstance() {
        BeatBoxFragment fragment = new BeatBoxFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    //endregion


    public BeatBoxFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSoundRepository = SoundRepository.getInstance(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_beat_box, container, false);
        findViews(view);
        initViews();
        UpdateUI();
        return view;
    }

    void initViews(){
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), SPAN_COUNT));
    }

    private void UpdateUI(){
        List<Sound> sounds=mSoundRepository.getSoundList();
        if (mSoundListAdapter==null){
            mSoundListAdapter=new SoundListAdapter(sounds);
        }else{
            mSoundListAdapter.setSoundList(sounds);
        }
        mRecyclerView.setAdapter(mSoundListAdapter);
        mSoundListAdapter.notifyDataSetChanged();
    }

    private void findViews(View view) {
        mRecyclerView = view.findViewById(R.id.recyclerView_fragmentBeatBox_list);
    }

    class SoundViewHolder extends RecyclerView.ViewHolder {

        Button mButtonSound;

        public SoundViewHolder(@NonNull View itemView) {
            super(itemView);
            mButtonSound = itemView.findViewById(R.id.button_SoundListItem_sound);
        }

        void bind(Sound sound) {
            mButtonSound.setText(sound.getName());
        }
    }

    class SoundListAdapter extends RecyclerView.Adapter<SoundViewHolder> {

        List<Sound> mSoundList;

        public SoundListAdapter(List<Sound> soundList) {
            mSoundList = soundList;
        }

        public List<Sound> getSoundList() {
            return mSoundList;
        }

        public void setSoundList(List<Sound> soundList) {
            mSoundList = soundList;
        }

        @NonNull
        @Override
        public SoundViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext())
                    .inflate(R.layout.sound_list_item, parent, false);
            return new SoundViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull SoundViewHolder holder, int position) {

            holder.bind(mSoundList.get(position));

        }

        @Override
        public int getItemCount() {
            return mSoundList.size();
        }
    }
}