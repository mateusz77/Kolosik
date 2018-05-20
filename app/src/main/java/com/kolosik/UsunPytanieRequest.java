package com.kolosik;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ciasteczko on 16.04.2018.
 */

public class UsunPytanieRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "http://jarekszparekkk12.000webhostapp.com/usunPytanie.php";
    private Map<String, String> params;

    public UsunPytanieRequest(String nazwaKolosa, String nazwaPytania, Response.Listener<String> listener){
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();

        params.put("nazwatb", nazwaKolosa);
        params.put("Pytanie", nazwaPytania);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}
