package com.developer.chp.yourcaption;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Moods extends Fragment {

    private RecyclerView MoodsList;
    private View moodsview;
    CaptionAdapter adapter;
    public Moods() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        moodsview =  inflater.inflate(R.layout.fragment_moods, container, false);

        MoodsList = (RecyclerView)moodsview.findViewById(R.id.RecyclerView);
        MoodsList.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<Captions> options =
                new FirebaseRecyclerOptions.Builder<Captions>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Captions"),Captions.class)
                        .build();

        adapter = new CaptionAdapter(options);
        MoodsList.setAdapter(adapter);
        return moodsview;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}