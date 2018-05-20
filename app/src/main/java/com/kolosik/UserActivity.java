package com.kolosik;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


        final TextView powitalnytxt = (TextView) findViewById(R.id.powitalnytxt);
        final EditText nazwa_kolosa = (EditText) findViewById(R.id.nazwa_kolosa);
        final Button zaczynajmy = (Button) findViewById(R.id.Zaczynajmybtnnn);




        Intent intent = getIntent();
        String imie = intent.getStringExtra("imie");
        String nazwisko = intent.getStringExtra("nazwisko");
        String klasa = intent.getStringExtra("klasa");
        String id = intent.getStringExtra("id");
        String status = intent.getStringExtra("status");
        final String username = intent.getStringExtra("username");


        String message = imie +" "+ nazwisko +" Witaj w strefie użytkownika. Klasa: "+klasa+  " id: "+id+""+"  " + status;

        /*AlertDialog.Builder builder = new AlertDialog.Builder(UserActivity.this);
        builder.setMessage( id+"")
                .setNegativeButton("Spróbuj ponownie", null)
                .create()
                .show();

        powitalnytxt.setText(message);*/


        zaczynajmy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pokaz_pytanie = new Intent(UserActivity.this, Pokaz_Pytanie.class);
                pokaz_pytanie.putExtra("nazwa", nazwa_kolosa.getText().toString());
                pokaz_pytanie.putExtra("numerPytania", "0");
                pokaz_pytanie.putExtra("punkty", "0");
                pokaz_pytanie.putExtra("username",username);
                startActivity(pokaz_pytanie);
            }
        });

    }
}
