package com.gaurav.examsportal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Level extends AppCompatActivity {
    String a3;

    public void onButton1(View view) {
        String a2 = "1";
        Intent i = new Intent(Level.this, Paper.class);
        i.putExtra("b1", a3);
        i.putExtra("b2", a2);
        startActivity(i);

    }

    public void onButton2(View view) {
        String a2 = "2";
        Intent i = new Intent(Level.this, Paper.class);
        i.putExtra("b1", a3);
        i.putExtra("b2", a2);
        startActivity(i);

    }

    public void onButton3(View view) {
        String a2 = "3";
        Intent i = new Intent(Level.this, Paper.class);
        i.putExtra("b1", a3);
        i.putExtra("b2", a2);
        startActivity(i);

    }

    public void onButton4(View view) {
        String a2 = "4";
        Intent i = new Intent(Level.this, Paper.class);
        i.putExtra("b1", a3);
        i.putExtra("b2", a2);
        startActivity(i);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_level);
        Intent intent = getIntent();
        a3 = intent.getExtras().getString("b1");
    }
}
