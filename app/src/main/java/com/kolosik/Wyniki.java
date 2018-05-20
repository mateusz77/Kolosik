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

public class Wyniki extends AppCompatActivity {


    private static final String wyniki_URL = "http://jarekszparekkk12.000webhostapp.com/wyniki1.php";


    List<Student_Wyniki> student_wyniki_list = new ArrayList<Student_Wyniki>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wyniki);



        recyclerView = (RecyclerView) findViewById(R.id.Wyniki_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        load_Students();




    }

    private void load_Students(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, wyniki_URL, new Response.Listener<String>() {




            @Override
            public void onResponse(String response) {
                try {
                   /* AlertDialog.Builder builder1 = new AlertDialog.Builder(Wyniki.this);
                    builder1.setMessage("odpowiedz dżejsona ze strony :"+ response)
                            .setNegativeButton("Spróbuj ponownie", null)
                            .create()
                            .show();*/

                    AlertDialog.Builder builder = new AlertDialog.Builder(Wyniki.this);
                    JSONArray students = new JSONArray(response);
                    for(int i = 0 ; i<students.length();i++){

                        JSONObject student_object = students.getJSONObject(i);

                        String imie = student_object.getString("imie");
                        String nazwisko = student_object.getString("nazwisko");
                        String klasa = student_object.getString("klasa");
                        String punkty = student_object.getString("punkty");

                        Student_Wyniki student_wyniki = new Student_Wyniki(imie,nazwisko,klasa,punkty);
                        student_wyniki_list.add(student_wyniki);
                    }

                    Student_Wyniki_Adapter adapter = new Student_Wyniki_Adapter(Wyniki.this, student_wyniki_list);
                    recyclerView.setAdapter(adapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },
        new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Wyniki.this, error.getMessage(),Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(Wyniki.this);
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
                final String nazwaKlasy = intent.getStringExtra("klasa");


                params.put("nazwaKolosa", nazwaKolosa);
                params.put("klasa", nazwaKlasy);
                return params;
            }

        };



        Volley.newRequestQueue(this).add(stringRequest);
    }



}
