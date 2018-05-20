package com.kolosik;

import android.content.DialogInterface;
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

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText etimie= (EditText) findViewById(R.id.imietxt);
        final EditText etnazwisko= (EditText) findViewById(R.id.nazwiskotxt);
        final EditText etklasa= (EditText) findViewById(R.id.klasatxt);
        final EditText etid= (EditText) findViewById(R.id.idnumber);
        final EditText etusername= (EditText) findViewById(R.id.username);
        final EditText etstatus= (EditText) findViewById(R.id.statustxt);
        final EditText ethaslo= (EditText) findViewById(R.id.haslotxt);
        final Button bzarejestruj = (Button) findViewById(R.id.zarejestrujbtn);
        final Button nauczycielbtn = (Button) findViewById(R.id.nauczycelbtn);
        final Button uczenbtn = (Button) findViewById(R.id.uczenbtn);

        nauczycielbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etstatus.setText("nauczyciel");

            }
        });

        uczenbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              etstatus.setText("uczen");

                final String username1 = etusername.getText().toString();
                final String imie1 = etimie.getText().toString();
                final String nazwisko1 = etnazwisko.getText().toString();
                final String klasa1 = etklasa.getText().toString();

              Response.Listener<String> responseListener1 = new Response.Listener<String>() {
                  @Override
                  public void onResponse(String response) {
                      try {

                          JSONObject jeson = new JSONObject(response);


                          boolean success = jeson.getBoolean("success");

                          if(success){
                              AlertDialog.Builder builder1 = new AlertDialog.Builder(Register.this);
                              builder1.setMessage("Dodawanie wiersza wynikow OK")
                                      .setNegativeButton("Spróbuj ponownie", null)
                                      .create()
                                      .show();
                          }else {
                              AlertDialog.Builder builder1 = new AlertDialog.Builder(Register.this);
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

                dodajWierszWynikow dowynik = new dodajWierszWynikow(username1,imie1,nazwisko1,klasa1, responseListener1);
                RequestQueue queue = Volley.newRequestQueue(Register.this);
                queue.add(dowynik);

            }
        });


        bzarejestruj.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final String imie = etimie.getText().toString();
                final String nazwisko = etnazwisko.getText().toString();
                final String klasa = etklasa.getText().toString();
                final String id = etid.getText().toString();
                final String username = etusername.getText().toString();
                final String status = etstatus.getText().toString();
                final String haslo = ethaslo.getText().toString();



                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                          /* AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);
                            builder.setMessage("Rejestracja nie powiodła się" + response)
                                    .setNegativeButton("Spróbuj ponownie", null)
                                    .create()
                                    .show();*/

/////////////////////////////////////
                        /*    response = response.replaceFirst("<font>.*?</font>", "");
                            int jsonStart = response.indexOf("{");
                            int jsonEnd = response.lastIndexOf("}");

                            if (jsonStart >= 0 && jsonEnd >= 0 && jsonEnd > jsonStart) {
                                response = response.substring(jsonStart, jsonEnd + 1);
                            } else {
                                // deal with the absence of JSON content here
                            }
                        */
///////////////////////////////////


                                JSONObject jeson = new JSONObject(response);


                            boolean success = jeson.getBoolean("success");

                            if(success){
                                Intent intent = new Intent(Register.this, LoginActivity.class);
                                Register.this.startActivity(intent);
                            }else {
                                AlertDialog.Builder builder1 = new AlertDialog.Builder(Register.this);
                                builder1.setMessage("Rejestracja nie powiodła się")
                                        .setNegativeButton("Spróbuj ponownie", null)
                                        .create()
                                        .show();

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                RegisterRequest registerRequest = new RegisterRequest(imie, nazwisko,klasa, id, username, status, haslo, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Register.this);
                queue.add(registerRequest);
            }
        });
    }

    public void sprawdzam(View view) {
        AlertDialog.Builder wiadomosc = new AlertDialog.Builder(this);
        wiadomosc.setTitle("Zacząłem działać")
                .setMessage("ale coś jest nie tak ")
                .setPositiveButton("Continue..", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        wiadomosc.show();

    }
}
