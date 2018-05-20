package com.kolosik;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ciasteczko on 25/04/2018.
 */

public class NowePytanieRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "http://jarekszparekkk12.000webhostapp.com/nowePytanie.php";
    private Map<String, String> params;

    public NowePytanieRequest(String nazwaKolosa, String numerPytania, Response.Listener<String> listener){
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);

        params = new HashMap<>();

        params.put("nazwa", nazwaKolosa);
        params.put("numerPytania", numerPytania);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
