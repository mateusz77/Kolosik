package com.kolosik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EdytujKolos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edytuj_kolos);

        Button dalej = (Button) findViewById(R.id.daleEDIT222jbtn);
        final EditText nazwa = (EditText) findViewById(R.id.nazwaEditKolos);


        dalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String nazwatb = nazwa.getText().toString();

                Intent intent = new Intent(EdytujKolos.this, EdytujKolos2222.class);
                intent.putExtra("nazwa", nazwatb);
                startActivity(intent);

            }
        });


    }
}
