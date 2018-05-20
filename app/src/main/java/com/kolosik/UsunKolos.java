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

public class UsunKolos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usun_kolos);

        Button usun = (Button) findViewById(R.id.usunKolosaUkbtn);

        final EditText nazwa = (EditText) findViewById(R.id.nazwakolosaUKAA);

        //final String nazwatb = nazwa.getText().toString();

        usun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String nazwatb = nazwa.getText().toString();
                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {


                        try {
                          /*AlertDialog.Builder builder = new AlertDialog.Builder(UsunKolos.this);
                            builder.setMessage("Usuwanie nie powiodło się" + response)
                                    .setNegativeButton("Spróbuj ponownie", null)
                                    .create()
                                    .show();
*/
                            JSONObject jeson = new JSONObject(response);


                            boolean success = jeson.getBoolean("success");

                            if(success){
                                Intent intent = new Intent(UsunKolos.this, UsunKolos.class);
                                UsunKolos.this.startActivity(intent);
                            }else {
                                AlertDialog.Builder builder1 = new AlertDialog.Builder(UsunKolos.this);
                                builder1.setMessage("Usuwanie nie powiodło się")
                                        .setNegativeButton("Spróbuj ponownie", null)
                                        .create()
                                        .show();

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                UsunKolosaRequest registerRequest = new UsunKolosaRequest(nazwatb, responseListener);
                RequestQueue queue = Volley.newRequestQueue(UsunKolos.this);
                queue.add(registerRequest);



            }
        });
    }
}
