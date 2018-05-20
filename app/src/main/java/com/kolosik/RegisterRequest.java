package com.kolosik;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ciasteczko on 28.03.2018.
 */

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://jarekszparekkk12.000webhostapp.com/register.php";
    private Map<String, String> params;

    public RegisterRequest(String imie, String nazwisko, String klasa, String id, String username, String status,String haslo, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();

        params.put("imie", imie);
        params.put("nazwisko", nazwisko);
        params.put("klasa", klasa);
        params.put("id", id);
        params.put("username", username);
        params.put("status", status);
        params.put("haslo", haslo);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
