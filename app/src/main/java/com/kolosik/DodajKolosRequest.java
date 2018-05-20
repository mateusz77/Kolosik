package com.kolosik;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ciasteczko on 16.04.2018.
 */

public class DodajKolosRequest extends StringRequest {


    private static final String ADD_TABLE_URL = "http://jarekszparekkk12.000webhostapp.com/dodajtabele.php";
    private Map<String, String> params;

    public DodajKolosRequest(String nazwa,String username, Response.Listener<String> listener){
        super(Request.Method.POST, ADD_TABLE_URL, listener, null);
        params = new HashMap<>();

        params.put("nazwatb", nazwa);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
