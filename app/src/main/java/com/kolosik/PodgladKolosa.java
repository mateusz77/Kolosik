package com.kolosik;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PodgladKolosa extends AppCompatActivity {
    private static final String wyniki_URL = "http://jarekszparekkk12.000webhostapp.com/Podglad.php";


    List<Pytanie_class> listaPytan = new ArrayList<Pytanie_class>();
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podglad_kolosa);



        recyclerView = (RecyclerView) findViewById(R.id.Podglad_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        load_Pytania();




    }

    private void load_Pytania(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, wyniki_URL, new Response.Listener<String>() {




            @Override
            public void onResponse(String response) {
                try {

                    /*AlertDialog.Builder builder = new AlertDialog.Builder(PodgladKolosa.this);
                    builder.setMessage( "opopo" + response)
                            .setNegativeButton("Spróbuj ponownie", null)
                            .create()
                            .show();*/

                    JSONArray pytania = new JSONArray(response);

                    for(int i = 0 ; i<pytania.length();i++){

                        JSONObject pytanie_object = pytania.getJSONObject(i);

                        String pytanie = pytanie_object.getString("Pytanie");
                        String odpA = pytanie_object.getString("OdpowiedzA");
                        String odpB = pytanie_object.getString("OdpowiedzB");
                        String odpC = pytanie_object.getString("OdpowiedzC");
                        String odpD = pytanie_object.getString("OdpowiedzD");
                        String odpra = pytanie_object.getString("PrawidlowaO");


                        Pytanie_class nowe_pytanie = new Pytanie_class(pytanie,odpA,odpB,odpC,odpD,odpra);
                        listaPytan.add(nowe_pytanie);
                    }

                    Pytanie_class_adapter adapter = new Pytanie_class_adapter(PodgladKolosa.this, listaPytan);
                    recyclerView.setAdapter(adapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(PodgladKolosa.this);
                        builder.setMessage( "Nie ma takiego Kolosa" + error)
                                .setNegativeButton("Spróbuj ponownie", null)
                                .create()
                                .show();
                    }
                }){
            @Override
            public Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params = new HashMap<>();
                Intent intent = getIntent();
                final String nazwaKolosa = intent.getStringExtra("nazwaKolosa");
                params.put("nazwaKolosa", nazwaKolosa);
                return params;
            }

        };



        Volley.newRequestQueue(this).add(stringRequest);
    }

}

