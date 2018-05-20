package com.kolosik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Wyniki_przejscie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wyniki_przejscie);

        final EditText wyniket = (EditText) findViewById(R.id.wyniki_przejscie_et);
        final EditText klasa = (EditText) findViewById(R.id.nazwa_klasy_wyniki_przejscie);
        Button ok_button = (Button) findViewById(R.id.button_wyniki_przejscie);


        ok_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String nazwaKolosa = wyniket.getText().toString();
                String nazwaKlasy = klasa.getText().toString();

                Intent intent = new Intent(Wyniki_przejscie.this, Wyniki.class);
                intent.putExtra("nazwaKolosa",nazwaKolosa);
                intent.putExtra("klasa",nazwaKlasy);
                startActivity(intent);
            }
        });

    }
}
