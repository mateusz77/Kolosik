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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Pokaz_Pytanie extends AppCompatActivity {

    String zaznaczonaOdpowiedz = null;
    String prawidlowaO = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokaz__pytanie);

        final TextView pytanie = (TextView) findViewById(R.id.pytanietww);
        final TextView testt = (TextView) findViewById(R.id.testttt);
        final Button odpA = (Button) findViewById(R.id.odpAbtn);
        final Button odpB = (Button) findViewById(R.id.odpBbtn);
        final Button odpC = (Button) findViewById(R.id.odpCbtn);
        final Button odpD = (Button) findViewById(R.id.odpDbtn);
        final Button nastepne = (Button) findViewById(R.id.nastbtn);


        final Intent intent = getIntent();
        final String nazwa = intent.getStringExtra("nazwa");
        final String numerPytania = intent.getStringExtra("numerPytania");
        final String punkty = intent.getStringExtra("punkty");
        final String username = intent.getStringExtra("username");
        //final String y = intent.getStringExtra("y");


        //testt.setText(y);








        odpA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zaznaczonaOdpowiedz = odpA.getText().toString();

            }
        });

        odpB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zaznaczonaOdpowiedz = odpB.getText().toString();
            }
        });
        odpC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zaznaczonaOdpowiedz = odpC.getText().toString();
            }
        });

        odpD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zaznaczonaOdpowiedz = odpD.getText().toString();
            }
        });




         Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
               /* AlertDialog.Builder builder = new AlertDialog.Builder(Pokaz_Pytanie.this);
                builder.setMessage("prawidlowa" + prawidlowaO + response)
                        .setNegativeButton("Spróbuj ponownie", null)
                        .create()
                        .show();*/

                try {

                    JSONObject jsonResponse = new JSONObject(response);


                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {


                        String pytanie1 = jsonResponse.getString("Pytanie");
                        String odpowiedzA = jsonResponse.getString("OdpowiedzA");
                        String odpowiedzB = jsonResponse.getString("OdpowiedzB");
                        String odpowiedzC = jsonResponse.getString("OdpowiedzC");
                        String odpowiedzD = jsonResponse.getString("OdpowiedzD");
                        prawidlowaO = jsonResponse.getString("PrawidlowaO");


                        pytanie.setText(pytanie1);
                        odpA.setText(odpowiedzA);
                        odpB.setText(odpowiedzB);
                        odpC.setText(odpowiedzC);
                        odpD.setText(odpowiedzD);

                        /*AlertDialog.Builder builder2 = new AlertDialog.Builder(Pokaz_Pytanie.this);
                        builder2.setMessage("prawidlowa  " + zaznaczonaOdpowiedz+"  teraaaaaaaaaaaaa"+ response)
                                .setNegativeButton("Spróbuj ponownie", null)
                                .create()
                                .show();*/


                    } else {
                       Intent koniec = new Intent(Pokaz_Pytanie.this, Wynik_Uczen.class);


                        int punkty1 = Integer.parseInt(punkty);

                        if (prawidlowaO!=null && prawidlowaO.equals(zaznaczonaOdpowiedz) ){
                            punkty1 = punkty1+1;
                        }else {
                            AlertDialog.Builder builder2 = new AlertDialog.Builder(Pokaz_Pytanie.this);
                            builder2.setMessage("tutaj mamy nulllla"+ " prawidlowa "+ prawidlowaO+" zazn: "+zaznaczonaOdpowiedz)
                                    .setNegativeButton("Spróbuj ponownie", null)
                                    .create()
                                    .show();
                        }
                        final String punkty2 =Integer.toString(punkty1);

                        koniec.putExtra("nazwa", nazwa);
                       /* koniec.putExtra("numerPytania", numerPytania);*/
                        koniec.putExtra("punkty", punkty2);
                        koniec. putExtra("username", username);
                        startActivity(koniec);


                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


        };

        NowePytanieRequest nowePytanieRequest = new NowePytanieRequest(nazwa,numerPytania, responseListener);
        RequestQueue queue = Volley.newRequestQueue(Pokaz_Pytanie.this);
                queue.add(nowePytanieRequest);

        nastepne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numer_pytania = Integer.parseInt(numerPytania);
                numer_pytania = numer_pytania+1;
                final String numerer_pytania =Integer.toString(numer_pytania);

                int punkty1 = Integer.parseInt(punkty);

                if ( prawidlowaO!= null && prawidlowaO.equals(zaznaczonaOdpowiedz)){
                    punkty1 = punkty1+1;
                }else {
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(Pokaz_Pytanie.this);
                    builder2.setMessage("tutaj mamy nulllla button"+" zazn: "+zaznaczonaOdpowiedz+ " prawidlowa "+ prawidlowaO)
                            .setNegativeButton("Spróbuj ponownie", null)
                            .create()
                            .show();
                }


                final String punkty2 =Integer.toString(punkty1);

                Intent intent = new Intent(Pokaz_Pytanie.this, Pokaz_Pytanie.class);
                intent.putExtra("nazwa", nazwa);
                intent.putExtra("numerPytania", numerer_pytania);
                intent.putExtra("punkty", punkty2);
                intent.putExtra("username",username);
                intent.putExtra("y", prawidlowaO);

                AlertDialog.Builder builder = new AlertDialog.Builder(Pokaz_Pytanie.this);
                builder.setMessage("punkty: " + punkty2+ " prawidlowa "+ prawidlowaO +" nazwa "+nazwa +" zazn: "+zaznaczonaOdpowiedz )
                        .setNegativeButton("Spróbuj ponownie", null)
                        .create()
                        .show();

                Pokaz_Pytanie.this.startActivity(intent);






            }
        });

    }
}
