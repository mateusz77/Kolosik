package com.kolosik;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Nauczyciel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nauczyciel);




        final TextView powitalnytxt = (TextView) findViewById(R.id.witajNauczycielu);
        final Button dodajKolos = (Button) findViewById(R.id.dodajKolosbtn);
        final Button usunKolos = (Button) findViewById(R.id.usunKolosbtn);
        final Button podgladKolos = (Button) findViewById(R.id.podgladbtn);
        final Button sprawdzKolos = (Button) findViewById(R.id.sprawdzWynikbtn);
        final Button edytujKolos = (Button) findViewById(R.id.edytujKolos);
        final Button twojeKolosy = (Button) findViewById(R.id.twojeKolosybtn);


        final Intent intent = getIntent();
        String imie = intent.getStringExtra("imie");
        String nazwisko = intent.getStringExtra("nazwisko");
        final String username = intent.getStringExtra("username");
        final String status = intent.getStringExtra("status");


        String message = imie +" "+ nazwisko +" Witaj w strefie nauczyciela. " + username +" o statusie "+status;

        /*AlertDialog.Builder builder = new AlertDialog.Builder(UserActivity.this);
        builder.setMessage( id+"")
                .setNegativeButton("Spróbuj ponownie", null)
                .create()
                .show();
*/
        powitalnytxt.setText(message);


        dodajKolos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dodajKolosIntent = new Intent(Nauczyciel.this, DodajKolos.class);
                dodajKolosIntent.putExtra("username", username);
                startActivity(dodajKolosIntent);
            }
        });

        usunKolos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent usunKolosIntent = new Intent(Nauczyciel.this, UsunKolos.class);
                usunKolosIntent.putExtra("username", username);
                startActivity(usunKolosIntent);
            }
        });

        podgladKolos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent podgladKolosIntent = new Intent(Nauczyciel.this, Podglad_kolosa_przejscie.class);
                podgladKolosIntent.putExtra("username", username);
                startActivity( podgladKolosIntent);
            }
        });


        sprawdzKolos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sprawdzKolosIntent = new Intent(Nauczyciel.this, Wyniki_przejscie.class);
                sprawdzKolosIntent.putExtra("username", username);
                startActivity(sprawdzKolosIntent);
            }
        });

        edytujKolos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edytujIntent= new Intent(Nauczyciel.this, EdytujKolos.class);
                edytujIntent.putExtra("username", username);
                startActivity(edytujIntent);
            }
        });

        twojeKolosy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent twojekolosyintent = new Intent(Nauczyciel.this, TwojeKolosy.class);
                twojekolosyintent.putExtra("username", username);
                startActivity(twojekolosyintent);
            }
        });





    }
}
