package com.developer.chp.yourcaption;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

Button findcap,writecapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    findcap = findViewById(R.id.button_find);
    writecapt = findViewById(R.id.buttn_write);
    findcap.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent i = new Intent(MainActivity.this, CaplistActivity.class);
            startActivity(i);
        }
    });


        writecapt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, WriteCapActivity.class);
                startActivity(i);
            }
        });
    }


}
