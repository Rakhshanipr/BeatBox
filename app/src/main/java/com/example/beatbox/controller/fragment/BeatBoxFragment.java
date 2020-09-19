package com.example.beatbox.controller.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.beatbox.R;


public class BeatBoxFragment extends Fragment {
    private RecyclerView mRecyclerView;

    public BeatBoxFragment() {
        // Required empty public constructor
    }


    public static BeatBoxFragment newInstance() {
        BeatBoxFragment fragment = new BeatBoxFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_beat_box, container, false);
        findViews(view);
        return view;
    }

    private void findViews(View view) {
        mRecyclerView=view.findViewById(R.id.recyclerView_fragmentBeatBox_list);
    }

    class SoundViewHolder extends RecyclerView.ViewHolder{

        public SoundViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    class SoundListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }
}