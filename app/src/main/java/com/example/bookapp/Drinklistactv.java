package com.example.bookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Drinklistactv extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinklistactv);
        Intent g = getIntent();
        TextView td = findViewById(R.id.drinklist);
        td.setText( g.getStringExtra("Drinkinfo"));
    }
}