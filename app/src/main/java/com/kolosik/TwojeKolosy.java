package com.kolosik;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TwojeKolosy extends AppCompatActivity {
    private static final String wyniki_URL = "http://jarekszparekkk12.000webhostapp.com/twojeKolosy.php";


    List<Kolos> kolosList = new ArrayList<Kolos>();
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twoje_kolosy);

        recyclerView = (RecyclerView) findViewById(R.id.twojeKolosy_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        load_Kolosy();
    }

    private void load_Kolosy(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, wyniki_URL, new Response.Listener<String>() {




            @Override
            public void onResponse(String response) {
                try {

                    /*AlertDialog.Builder builder = new AlertDialog.Builder(PodgladKolosa.this);
                    builder.setMessage( "opopo" + response)
                            .setNegativeButton("Spróbuj ponownie", null)
                            .create()
                            .show();*/

                    JSONArray kolosy = new JSONArray(response);

                    for(int i = 0 ; i<kolosy.length();i++){

                        JSONObject kolos_object = kolosy.getJSONObject(i);

                        String nazwaKolosa = kolos_object.getString("nazwaKolosa");


                        Kolos kolosik = new Kolos(nazwaKolosa);
                        kolosList.add(kolosik);
                    }

                    Kolos_adapter adapter = new Kolos_adapter(TwojeKolosy.this, kolosList);
                    recyclerView.setAdapter(adapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(TwojeKolosy.this);
                        builder.setMessage( "Nie ma takiego Kolosa" + error)
                                .setNegativeButton("Spróbuj ponownie", null)
                                .create()
                                .show();
                    }
                }){
            @Override
            public Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params = new HashMap<>();

                final Intent intent = getIntent();
                final String usernamet = intent.getStringExtra("username");


                params.put("username", usernamet);
                return params;
            }

        };



        Volley.newRequestQueue(this).add(stringRequest);
    }

}
