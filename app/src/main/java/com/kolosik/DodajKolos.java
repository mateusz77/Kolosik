package com.kolosik;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class DodajKolos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_kolos);

        final EditText etnazwaKolosa =  (EditText) findViewById(R.id.nazwaKolosa);
        final Button dodajPytanie =  (Button) findViewById(R.id.dodajPytaniebtn);
        final Intent intent = getIntent();
        final String username = intent.getStringExtra("username");

        dodajPytanie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nazwaKolosa = etnazwaKolosa.getText().toString();
                 nazwaKolosa+= username;
                 final String nazwaKolosa_pop = nazwaKolosa;

                Intent nowePytanieIntent = new Intent(DodajKolos.this, DodajPytanie.class);
                nowePytanieIntent.putExtra("nazwa", nazwaKolosa_pop);                                     ///************tutaj nazwaKolosa
                startActivity(nowePytanieIntent);

                Response.Listener<String> responseListener1 = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        try {
                            JSONObject jeson = new JSONObject(response);
                            boolean success = jeson.getBoolean("success");


                            if(success){
                                AlertDialog.Builder builder1 = new AlertDialog.Builder(DodajKolos.this);
                                builder1.setMessage("Dodanie tabeli wynikow  sie powiodlo")
                                        .setNegativeButton("Spróbuj ponownie", null)
                                        .create()
                                        .show();


                            }else {
                                AlertDialog.Builder builder1 = new AlertDialog.Builder(DodajKolos.this);
                                builder1.setMessage("Dodanie tabeli wynikw nie powiodlo sie ")
                                        .setNegativeButton("Spróbuj ponownie", null)
                                        .create()
                                        .show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                           /* AlertDialog.Builder builder = new AlertDialog.Builder(DodajKolos.this);
                            builder.setMessage("Dodanie kolosa nie powiodło się" + response)
                                    .setNegativeButton("Spróbuj ponownie", null)
                                    .create()
                                    .show();
*/
                            JSONObject jeson = new JSONObject(response);


                            boolean success = jeson.getBoolean("success");

                            if(success){
                                Intent intent = new Intent(DodajKolos.this, DodajPytanie.class);
                                intent.putExtra("nazwa", nazwaKolosa_pop);                                  //////////////////////////////****************intent.putExtra("nazwa", nazwaKolosa);
                                DodajKolos.this.startActivity(intent);


                            }else {
                                AlertDialog.Builder builder1 = new AlertDialog.Builder(DodajKolos.this);
                                builder1.setMessage("Dodanie kolosa nie powiodło się ")
                                        .setNegativeButton("Spróbuj ponownie", null)
                                        .create()
                                        .show();

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };


                DodajKolumneWynikow dodajKolumneWynikow = new DodajKolumneWynikow(nazwaKolosa, responseListener1);
                DodajKolosRequest dodajkolosrequest = new DodajKolosRequest(nazwaKolosa,username, responseListener);
                RequestQueue queue = Volley.newRequestQueue(DodajKolos.this);
                queue.add(dodajkolosrequest);
                queue.add(dodajKolumneWynikow);


                //RequestQueue  kolejka= Volley.newRequestQueue(DodajKolos.this);
                //kolejka.add(dodajKolumneWynikow);


            }


        });




    }
}
