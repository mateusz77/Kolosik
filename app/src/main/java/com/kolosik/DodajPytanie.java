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

public class DodajPytanie extends AppCompatActivity {
    String prawidlowaOdpowiedz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_pytanie);

        final Button zatwierdzpytaniebtn = (Button) findViewById(R.id.zatwierdzpytaniebtn);

        final EditText etpytanie = (EditText) findViewById(R.id.trescPytania);
        final EditText etodpowiedzA = (EditText) findViewById(R.id.odpowiedzA);
        final EditText etodpowiedzB  = (EditText) findViewById(R.id.odpowiedzB);
        final EditText etodpowiedzC = (EditText) findViewById(R.id.odpowiedzC);
        final EditText etodpowiedzD  = (EditText) findViewById(R.id.odpowiedzD);


        Button buttona = (Button) findViewById(R.id.buttona);
        Button buttonb = (Button) findViewById(R.id.buttonb);
        Button buttonc = (Button) findViewById(R.id.buttonc);
        Button buttond = (Button) findViewById(R.id.buttond);




        buttona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prawidlowaOdpowiedz = etodpowiedzA.getText().toString();
            }
        });

        buttonb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prawidlowaOdpowiedz = etodpowiedzB.getText().toString();
            }
        });
        buttonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prawidlowaOdpowiedz = etodpowiedzC.getText().toString();
            }
        });
        buttond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prawidlowaOdpowiedz = etodpowiedzD.getText().toString();
            }
        });

        Intent intent = getIntent();
        final String nazwa = intent.getStringExtra("nazwa");
   //     final String username = intent.getStringExtra("username");
        zatwierdzpytaniebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pytanie = etpytanie.getText().toString();
                String odpowiedzA = etodpowiedzA.getText().toString();
                String odpowiedzB = etodpowiedzB.getText().toString();
                String odpowiedzC = etodpowiedzC.getText().toString();
                String odpowiedzD = etodpowiedzD.getText().toString();



                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {



                            JSONObject jeson = new JSONObject(response);


                            boolean success = jeson.getBoolean("success");

                            if (success) {
                                Intent intent = new Intent(DodajPytanie.this, DodajPytanie.class);
                                intent.putExtra("nazwa", nazwa);
                                DodajPytanie.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder1 = new AlertDialog.Builder(DodajPytanie.this);
                                builder1.setMessage("Dodawanie pytania nie powiodło się").setNegativeButton("Spróbuj ponownie", null).create().show();

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                };
                DodajPytanieRequest dodajpytanie = new DodajPytanieRequest(nazwa, pytanie, odpowiedzA, odpowiedzB, odpowiedzC, odpowiedzD, prawidlowaOdpowiedz, responseListener);
                RequestQueue queue = Volley.newRequestQueue(DodajPytanie.this);
                queue.add(dodajpytanie);


            }
        });



    }

}
