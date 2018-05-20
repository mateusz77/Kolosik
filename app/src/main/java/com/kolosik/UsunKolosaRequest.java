package com.kolosik;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ciasteczko on 16.04.2018.
 */

public class UsunKolosaRequest extends StringRequest{
    private static final String USUN_KOLOS_REQUEST_URL = "http://jarekszparekkk12.000webhostapp.com/usunTabele.php";
    private Map<String, String> params;

    public UsunKolosaRequest(String nazwatb, Response.Listener<String> listener){
        super(Request.Method.POST, USUN_KOLOS_REQUEST_URL, listener, null);
        params = new HashMap<>();

        params.put("nazwatb", nazwatb);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}
