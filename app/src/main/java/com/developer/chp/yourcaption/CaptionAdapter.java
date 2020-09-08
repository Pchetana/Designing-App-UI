package com.developer.chp.yourcaption;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class CaptionAdapter extends FirebaseRecyclerAdapter<Captions,CaptionAdapter.CaptionViewHolder> {


    public CaptionAdapter(@NonNull FirebaseRecyclerOptions<Captions> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull CaptionViewHolder holder, int position, @NonNull Captions cap) {

        holder.captionn.setText(cap.getCaption());
    }

    @NonNull
    @Override
    public CaptionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.caption,viewGroup,false);

        return new CaptionViewHolder(view);
    }

    class CaptionViewHolder extends RecyclerView.ViewHolder{

        TextView captionn,author;

        public CaptionViewHolder(@NonNull View itemView) {
            super(itemView);

            captionn = itemView.findViewById(R.id.capt);
             }
    }
}
