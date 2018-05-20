package com.kolosik;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ciasteczko on 16.04.2018.
 */

public class DodajPytanieRequest extends StringRequest { private static final String ADD_TABLE_URL = "http://jarekszparekkk12.000webhostapp.com/dodajpytanie.php";
    private Map<String, String> params;

    public DodajPytanieRequest(String nazwa,String pytanie, String odpowiedzA, String odpowiedzB, String odpowiedzC, String odpowiedzD, String prawidlowaO, Response.Listener<String> listener){
        super(Request.Method.POST, ADD_TABLE_URL, listener, null);

        params = new HashMap<>();

        params.put("nazwatb", nazwa);
        params.put("Pytanie", pytanie);
        params.put("OdpowiedzA", odpowiedzA);
        params.put("OdpowiedzB", odpowiedzB);
        params.put("OdpowiedzC", odpowiedzC);
        params.put("OdpowiedzD", odpowiedzD);
        params.put("PrawidlowaO", prawidlowaO);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
