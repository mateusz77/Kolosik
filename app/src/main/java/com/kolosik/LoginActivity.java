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

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button zalogujbtn  =(Button) findViewById(R.id.zalogujbtn);
        Button rejestrujbtn = (Button) findViewById(R.id.rejestrbtn);

        final EditText identyfikator   = (EditText) findViewById(R.id.identyfikator);
        final EditText haslo =(EditText) findViewById(R.id.haslo);

        /*String login = identyfikator.getText().toString();
        final String hasloo = haslo.getText().toString();*/


  /*      zalogujbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Activity2.class);


                intent.putExtra("username",identyfikator.getText().toString());
                intent.putExtra("haslo",haslo.getText().toString());
                startActivity(intent);
            }
        });*/

        rejestrujbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rejestrujIntent = new Intent(LoginActivity.this, Register.class);
                startActivity(rejestrujIntent);
            }
        });

        zalogujbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = identyfikator.getText().toString();
                final String haselko = haslo.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                          /*  AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                            builder.setMessage("Logowanie nie powiodło się" + response)
                                    .setNegativeButton("Spróbuj ponownie", null)
                                    .create()
                                    .show();*/

                            JSONObject jsonResponse = new JSONObject(response);

                            boolean success = jsonResponse.getBoolean("success");
                            if(success){

                                String imie = jsonResponse.getString("imie");
                                String nazwisko = jsonResponse.getString("nazwisko");
                                String klasa = jsonResponse.getString("klasa");
                                String id = jsonResponse.getString("id");
                                String username = jsonResponse.getString("username");
                                String status = jsonResponse.getString("status");
                                String haslo = jsonResponse.getString("haslo");


                                ////////////////////////////////////////////////////////
                                if("uczen".equalsIgnoreCase(status)){
                                    Intent intent = new Intent(LoginActivity.this, UserActivity.class);
                                    intent.putExtra("imie", imie);
                                    intent.putExtra("nazwisko", nazwisko);
                                    intent.putExtra("klasa", klasa);
                                    intent.putExtra("id", id);
                                    intent.putExtra("status", status);
                                    intent.putExtra("username", username);

                                    LoginActivity.this.startActivity(intent);


                                }else if ( "nauczyciel".equalsIgnoreCase(status)){

                                    Intent intent = new Intent(LoginActivity.this, Nauczyciel.class);
                                    intent.putExtra("imie", imie);
                                    intent.putExtra("nazwisko", nazwisko);
                                    intent.putExtra("username", username);
                                    intent.putExtra("status", status);


                                    LoginActivity.this.startActivity(intent);

                                }else{
                                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                    builder.setMessage("kim ty kurwa jesteś????/" +status)
                                            .setNegativeButton("Spróbuj ponownie", null)
                                            .create()
                                            .show();
                                }


                                //////////////////////////////////////////////

                            }else {
                                AlertDialog.Builder builder1 = new AlertDialog.Builder(LoginActivity.this);
                                builder1.setMessage("Logowanie nie powiodło się")
                                        .setNegativeButton("Spróbuj ponownie", null)
                                        .create()
                                        .show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(username, haselko, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });


    }
}
