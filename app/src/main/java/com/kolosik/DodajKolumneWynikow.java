package com.kolosik;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ciasteczko on 17/05/2018.
 */

public class DodajKolumneWynikow extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "http://jarekszparekkk12.000webhostapp.com/dodajKolumneWynikow.php";
    private Map<String, String> params;

    public DodajKolumneWynikow(String nazwaKolosa, Response.Listener<String> listener){
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);

        params = new HashMap<>();

        params.put("nazwaKolosa", nazwaKolosa);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
