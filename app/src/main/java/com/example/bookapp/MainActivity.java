package com.example.bookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static class booklist extends AppCompatActivity {
    Button drinklist ;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_booklist);
            drinklist = findViewById(R.id.drinklist);
            drinklist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentone = new Intent(booklist.this,drinklist.class);
                    startActivity(intentone);
                }
            });
        }
    }

    public static class mainActivity extends AppCompatActivity {
//    private RequestQueue qu1;
//        private RequestQueue qu2;
        private ListView drink;
        private ListView book;
    Button login;
    SharedPreferences sharedPreferences ;
    EditText unam , pass;

    Intent intent;

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            unam=findViewById(R.id.username);
            pass = findViewById(R.id.password);
            login = findViewById(R.id.btnlog);
            sharedPreferences =getSharedPreferences("user_info ",MODE_PRIVATE);
            intent = new Intent(mainActivity.this,userinfo.class);
    if(sharedPreferences.contains("username")&&sharedPreferences.contains("password")){
        startActivity(intent);
    }
    login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
     String username = unam.getText().toString();
     String password = pass.getText().toString();
     if(username.equals("dareenayham")&& password.equals("dareen123")){
      //   sharedPreferences.Editor editor = sharedPreferences.edit();

     }
        }
    });

    //        login = findViewById(R.id.btnlog );
    //        login.setOnClickListener(new View.OnClickListener() {
    //            @Override
    //            public void onClick(View v) {
    //                Intent intentone = new Intent(MainActivity.this,bookseg.class);
    //                startActivity(intentone);
    //            }
    //        });
    //        qu1 = Volley.newRequestQueue(context.this);
    //        drink = findViewById(R.id.drink);
    //        qu2 = Volley.newRequestQueue(context.this);
    //        book = findViewById(R.id.texttView);

        }
        public void ptnd_OnClik(View view){
            String urld = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=margarita";

        }
        public void ptnb_OnClik(View view){
            String urld = "https://openlibrary.org/search.json?q=the+lord+of+the+rings";

        }

    }
}