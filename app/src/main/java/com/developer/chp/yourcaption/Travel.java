package com.developer.chp.yourcaption;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Travel extends Fragment {

    private View travelView;
    private RecyclerView recyclerView;
    private DatabaseReference ref;
    public Travel() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        travelView = inflater.inflate(R.layout.fragment_travel, container, false);

        recyclerView = (RecyclerView) travelView.findViewById(R.id.travelRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ref = FirebaseDatabase.getInstance().getReference().child("Captions");
        return travelView;
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerOptions options =
                new FirebaseRecyclerOptions.Builder<Captions>()
                .setQuery(ref,Captions.class)
                .build();

       final FirebaseRecyclerAdapter<Captions,CaptionViewHolder> adapter
                = new FirebaseRecyclerAdapter<Captions, CaptionViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final CaptionViewHolder holder, int position, @NonNull final Captions cap) {

                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String capt = dataSnapshot.child("Captions").getValue().toString();
                        holder.captionn.setText(capt);
                       // holder.captionn.setText(cap.getCaption());

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }

            @NonNull
            @Override
            public CaptionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.caption,viewGroup,false);
                CaptionViewHolder viewHolder = new  CaptionViewHolder(view);
                return viewHolder;
            }
        };

       recyclerView.setAdapter(adapter);

       adapter.startListening();
    }

    public static class CaptionViewHolder extends RecyclerView.ViewHolder{

        TextView captionn;
        public CaptionViewHolder(@NonNull View itemView) {
            super(itemView);

            captionn = itemView.findViewById(R.id.capt);
        }
    }
}