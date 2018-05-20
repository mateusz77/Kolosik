package com.kolosik;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.widget.TextView;


public class Activity2 extends Activity {
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        String username = getIntent().getStringExtra("username");
        String haslo = getIntent().getStringExtra("haslo");

        TextView info1 = (TextView) findViewById(R.id.informacja1);

        info1.setText("Sprawdzam użytkownika: "+username+" o haśle "+haslo);
/*

*/     mHandler.postDelayed(new Runnable() {
            public void run() {

                doStuff();
            }
        }, 3000);
    }

    private void doStuff() {


        Intent intent = new Intent(Activity2.this, UserActivity.class);

        startActivity(intent);



    }



}