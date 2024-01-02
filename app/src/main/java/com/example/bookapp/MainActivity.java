package com.example.bookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;


import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {

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
       sharedPreferences = getSharedPreferences("",MODE_PRIVATE);
        String name = sharedPreferences.getString("",null);
        if(name != null){
            Intent intent = new Intent(MainActivity.this,Booksegactiv.class);
           Toast.makeText(this, "login success",Toast.LENGTH_SHORT).show();

       }
       SharedPreferences.Editor editor = sharedPreferences.edit();
     editor.putString("",unam.getText().toString());
     editor.putString("",pass.getText().toString());
     editor.apply();

    login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
     String username = unam.getText().toString();
     String password = pass.getText().toString();
    if(username.equals("dareenayham")&& password.equals("dareen123")){

        Intent intent1 = new Intent(MainActivity.this,Booksegactiv.class);
        startActivity(intent1);

    }
        }
    });




    }

    @Override
    protected void onDestroy() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("",unam.getText().toString());
        editor.putString("",pass.getText().toString());
        editor.apply();
        super.onDestroy();
    }
    //    public void ptnb_OnClik() {
//        String url = "https://openlibrary.org/search.json?q=the+lord+of+the+rings";
//
//
//        RequestQueue queue = Volley.newRequestQueue(this);
//
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
//                Request.Method.GET, url, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.d("response", response.toString());
//                        Gson gson = new Gson();
//                        booklist searchResponse = gson.fromJson(response.toString(), booklist.class);
//
//                        Intent intent1 = new Intent(MainActivity.this,BookListActv.class);
//                        intent1.putExtra("info", searchResponse.toString());
//                        startActivity(intent1);
////call the sec actv using intent-and send searchResponse to the new activ using putextra
//
//
//                        int numFound = searchResponse.getNumFound();
//                        int start = searchResponse.getStart();
//                        boolean numFoundExact = searchResponse.isNumFoundExact();
//                        List<booklist.Doc> docs = searchResponse.getDocs();
//
//                        Log.d("numFound", String.valueOf(numFound));
//                        Log.d("start", String.valueOf(start));
//                        Log.d("numFoundExact", String.valueOf(numFoundExact));
//                        Log.d("docs", docs.toString());
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.d("error", error.toString());
//                    }
//                }
//        );
//        queue.add(jsonObjectRequest);
//    }

}