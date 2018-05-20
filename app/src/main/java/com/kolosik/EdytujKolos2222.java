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

public class EdytujKolos2222 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edytuj_kolos2222);

        Button dodajbtn = (Button) findViewById(R.id.dodajPytaniebtn) ;
        Button usunPytaniebtn = (Button) findViewById(R.id.usunPytanieziomek);
        Button usunkolosbtn = (Button) findViewById(R.id.usunKolosaziomek);
        final EditText etusunpytnie = (EditText) findViewById(R.id.usunPytanieBtn);

        Intent intent = getIntent();
        final String nazwa = intent.getStringExtra("nazwa");

        usunkolosbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(EdytujKolos2222.this, UsunKolos.class);
                intent1.putExtra("nazwa",nazwa);
                startActivity(intent1);

            }
        });

        usunPytaniebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String pytanie = etusunpytnie.getText().toString();
                final String nazwag = nazwa;

                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            AlertDialog.Builder builder = new AlertDialog.Builder(EdytujKolos2222.this);
                            builder.setMessage("Usuwanie pytania nie powiodło się" + response).setNegativeButton("Spróbuj ponownie", null).create().show();

                            JSONObject jeson = new JSONObject(response);


                            boolean success = jeson.getBoolean("success");

                            if (success) {
                                Intent intent = new Intent(EdytujKolos2222.this, EdytujKolos2222.class);
                                EdytujKolos2222.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder1 = new AlertDialog.Builder(EdytujKolos2222.this);
                                builder1.setMessage("Usuwanie pytania nie powiodło się").setNegativeButton("Spróbuj ponownie", null).create().show();

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                };
                UsunPytanieRequest usunPytanieRequest = new UsunPytanieRequest(nazwag, pytanie,  responseListener);
                RequestQueue queue = Volley.newRequestQueue(EdytujKolos2222.this);
                queue.add(usunPytanieRequest);


            }
        });

        dodajbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nazwag = nazwa;
                Intent intent7= new Intent(EdytujKolos2222.this, DodajPytanie.class);
                intent7.putExtra("nazwa", nazwa);
                startActivity(intent7);

            }
        });


    }
}
