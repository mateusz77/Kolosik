package com.kolosik;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ciasteczko on 26/04/2018.
 */

public class ZapiszWynikDoBazyREQUEST extends StringRequest {

    private static final String LOGIN_REQUEST_URL = "http://jarekszparekkk12.000webhostapp.com/zapiszWynik.php";
    private Map<String, String> params;

    public ZapiszWynikDoBazyREQUEST(String nazwaKolosa, String nazwaUzytkownika,String punkty, Response.Listener<String> listener){
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);

        params = new HashMap<>();

        params.put("nazwaKolosa", nazwaKolosa);
        params.put("username",nazwaUzytkownika );
        params.put("punkty",punkty );

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
