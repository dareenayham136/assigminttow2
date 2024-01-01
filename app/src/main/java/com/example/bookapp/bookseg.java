package com.example.bookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;



public class bookseg extends AppCompatActivity {
Button listac ;

    public bookseg() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookseg);
        listac = findViewById(R.id.buttonlist );
        listac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentone = new Intent(bookseg.this,booklist.class);
                startActivity(intentone);
            }
        });
    }
}