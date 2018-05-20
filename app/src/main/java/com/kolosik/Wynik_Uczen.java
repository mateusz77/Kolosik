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

public class Wynik_Uczen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wynik__uczen);

        TextView wynik = (TextView) findViewById(R.id.wyniktw);
        Button zakoncz = (Button) findViewById(R.id.zakonczbtnek);

        Intent intent =  getIntent();
        final String nazwa = intent.getStringExtra("nazwa");
        final String punkty =intent.getStringExtra("punkty");
        final String username = intent.getStringExtra("username");

        wynik.setText( username + "!!! UZYSKAŁEŚ/ŁAŚ AŻ " + punkty + " punktów"  );

    zakoncz.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            Response.Listener<String> responseListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    try {

                        JSONObject jeson = new JSONObject(response);


                        boolean success = jeson.getBoolean("success");

                        if(success){
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(Wynik_Uczen.this);
                            builder1.setMessage("Dodawanie wiersza wynikow OK")
                                    .setNegativeButton("Spróbuj ponownie", null)
                                    .create()
                                    .show();

                            Intent powrot = new Intent(Wynik_Uczen.this, UserActivity.class);

                            startActivity(powrot);
                        }else {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(Wynik_Uczen.this);
                            builder1.setMessage("Dodawanie wiersza wynikow nie powiodło się"+ response)
                                    .setNegativeButton("Spróbuj ponownie", null)
                                    .create()
                                    .show();

                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            };

            ZapiszWynikDoBazyREQUEST request = new ZapiszWynikDoBazyREQUEST(nazwa,username,punkty,responseListener );
            RequestQueue queue = Volley.newRequestQueue(Wynik_Uczen.this);
            queue.add(request);

        }
    });



    }

}
