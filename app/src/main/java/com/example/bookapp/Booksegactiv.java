package com.example.bookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import java.util.List;
import org.json.JSONObject;

public class Booksegactiv extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booksegactiv);
        Button listb;
        listb = findViewById(R.id.btnp);
        listb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ptnb_OnClik();
            }
        });
    }
    public void ptnb_OnClik() {
       String url = "https://openlibrary.org/search.json?q=the+lord+of+the+rings";


        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("response", response.toString());
                       Gson gson = new Gson();
                        booklist searchResponse = gson.fromJson(response.toString(), booklist.class);

                        Intent intent1 = new Intent(Booksegactiv.this,BookListActv.class);
                        intent1.putExtra("Bookinfo", searchResponse.toString());
                        startActivity(intent1);
////call the sec actv using intent-and send searchResponse to the new activ using putextra


                        int numFound = searchResponse.getNumFound();
                        int start = searchResponse.getStart();
                        boolean numFoundExact = searchResponse.isNumFoundExact();
                       List<booklist.Doc> docs = searchResponse.getDocs();

                       Log.d("numFound", String.valueOf(numFound));
                        Log.d("start", String.valueOf(start));
                        Log.d("numFoundExact", String.valueOf(numFoundExact));
                     Log.d("docs", docs.toString());
                    }
               },
               new Response.ErrorListener() {
                 @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("error", error.toString());
                   }
                }
      );
      queue.add(jsonObjectRequest);
   }


    }