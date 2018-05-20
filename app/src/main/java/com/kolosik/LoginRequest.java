package com.kolosik;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ciasteczko on 11.04.2018.
 */

public class LoginRequest extends StringRequest{
    private static final String LOGIN_REQUEST_URL = "http://jarekszparekkk12.000webhostapp.com/login.php";
    private Map<String, String> params;

    public LoginRequest(String username, String haslo, Response.Listener<String> listener){
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);

        params = new HashMap<>();

        params.put("username", username);
        params.put("haslo", haslo);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}
