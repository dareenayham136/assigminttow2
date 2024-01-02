package com.example.bookapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.List;

public class BookListActv extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list_actv);

      Button listd ;
        listd = findViewById(R.id.btnd);
        TextView tb = findViewById(R.id.textbookv);
        Intent i = getIntent();
        tb.setText( i.getStringExtra("Bookinfo"));


 listd.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

         ptnd_OnClik();
     }
 });
   }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences sharedPreferences = getSharedPreferences("bookinfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Intent i = getIntent();
        String bookInfo = i.getStringExtra("Bookinfo");

        editor.putString("bookinfo", bookInfo);
        editor.apply();
    }

    public void ptnd_OnClik() {
        String url = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=margarita";


        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("response", response.toString());
                        Gson gson = new Gson();
                        drinklist searchResponse = gson.fromJson(response.toString(),drinklist.class);

                        Intent intent1 = new Intent(BookListActv.this,Drinklistactv.class);
                        intent1.putExtra("Drinkinfo", searchResponse.toString());
                        startActivity(intent1);
//call the sec actv using intent-and send searchResponse to the new activ using putextra


                        int IdDrink = searchResponse.getIdDrink();
                      String strDrink = searchResponse.getStrDrink();
                        String strAlcoholic = searchResponse.getStrAlcoholic();
                        String strCategory = searchResponse.getStrCategory();

                        Log.d("IdDrink", String.valueOf(IdDrink));
                        Log.d("strDrink", String.valueOf(strDrink));
                        Log.d("strAlcoholic", String.valueOf(strAlcoholic));
                        Log.d("strCategory", String.valueOf(strCategory));
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