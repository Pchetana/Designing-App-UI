package com.developer.chp.yourcaption;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.List;

public class WriteCapActivity extends AppCompatActivity {

    EditText writecaption,captionAuthor;
    Button submitbtn;
    FirebaseDatabase db;
    DatabaseReference ref;
    Captions captions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_cap);

        writecaption = findViewById(R.id.capWrite);
        captionAuthor = findViewById(R.id.capAuthor);
        submitbtn = findViewById(R.id.submitCap);


        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,Object> key = new HashMap<>();
                key.put("caption",writecaption.getText().toString());
                key.put("Author",captionAuthor.getText().toString());


                FirebaseDatabase.getInstance().getReference().child("Caption").push()
                        .setValue(key)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Log.i("fddf","On Complete");
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i("fddf","OnFailure:"+e.toString());
                    }
                });
            }
        });
    }
    }

