package com.kolosik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Podglad_kolosa_przejscie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podglad_kolosa_przejscie);
        final EditText wyniket = (EditText) findViewById(R.id.podglad_kollosa_przejscie_et);
        Button ok_button = (Button) findViewById(R.id.button_podglad_przejscie);


        ok_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String nazwaKolosa = wyniket.getText().toString();

                Intent intent = new Intent(Podglad_kolosa_przejscie.this, PodgladKolosa.class);
                intent.putExtra("nazwaKolosa",nazwaKolosa);
                startActivity(intent);
            }
        });

    }
}
