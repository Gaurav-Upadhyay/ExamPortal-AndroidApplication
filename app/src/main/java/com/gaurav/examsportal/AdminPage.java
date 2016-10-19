package com.gaurav.examsportal;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminPage extends AppCompatActivity implements View.OnClickListener {
    TextView tv,tv34;
    boolean doubleBackToExitPressedOnce = false;
    int i = 1;
    Button ADD;
    EditText username, u, p;
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_admin_page);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        tv = (TextView) findViewById(R.id.tv12);
        tv34 = (TextView) findViewById(R.id.tv5);
        findViewById(R.id.button31).setOnClickListener(this);
        u = (EditText) findViewById(R.id.tv51);
        p = (EditText) findViewById(R.id.tv61);


    }


    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            Intent intent = new Intent(AdminPage.this, MainActivity.class);
            startActivity(intent);
            finish();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press BACK again for Main Page", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                tv.setText("");
                final LoginDBHelper loginDBHelper = new LoginDBHelper(this);
                Cursor c = loginDBHelper.retrieveAllUser();
                i = 1;
                if (c.moveToFirst()) {
                    do {
                        tv.append(i + ")" + "Username & Password-   " + c.getString(0) + " , " + c.getString(1) + "  \n");
                        i++;
                    }
                    while (c.moveToNext());
                } else {
                    Toast.makeText(this, "No records in the database", Toast.LENGTH_SHORT).show();
                }
                break;


            case R.id.button3:
                final LoginDBHelper loginDBHelper1 = new LoginDBHelper(this);
                username = (EditText) findViewById(R.id.tv5);
                delete = (Button) findViewById(R.id.button3);
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String user_name = username.getText().toString();
                        if (loginDBHelper1.deleteUser(user_name)) {
                            Toast.makeText(getBaseContext(), "Your record has been deleted", Toast.LENGTH_SHORT).show();
                            i = 1;
                            tv.setText("");
                            u.setText("");
                            p.setText("");
                        } else {
                            Toast.makeText(getBaseContext(), "Record does not exist", Toast.LENGTH_SHORT).show();
                        }

                    }

                });


            case R.id.button31:


                if (u.getText().toString().length() == 0 && p.getText().toString().length() == 0) {
                    u.setError("Username cannot be blank");
                    p.setError("Password cannot be blank");
                } else if (u.getText().toString().length() == 0 && p.getText().toString().length() < 5) {
                    u.setError("Username cannot be blank");
                    p.setError("Atleast 5 letters");
                } else if (u.getText().toString().length() == 0 && p.getText().toString().length() > 5) {
                    u.setError("Username cannot be blank");
                } else if (u.getText().toString().length() < 5 && p.getText().toString().length() == 0) {
                    u.setError("Atleast 5 letters");
                    p.setError("Password cannot be blank");
                } else if (u.getText().toString().length() < 5 && p.getText().toString().length() < 5) {
                    u.setError("Atleast 5 letters");
                    p.setError("Atleast 5 letters");
                } else if (u.getText().toString().length() < 5 && p.getText().toString().length() > 5) {
                    u.setError("Atleast 5 letters");
                } else if (u.getText().toString().length() > 5 && p.getText().toString().length() == 0) {
                    p.setError("Password cannot be blank");
                } else if (u.getText().toString().length() > 5 && p.getText().toString().length() < 5) {
                    p.setError("Atleast 5 letters");
                } else if (u.getText().toString().length() >= 5 && p.getText().toString().length() >= 5) {
                    try {
                        final LoginDBHelper userdbhelper = new LoginDBHelper(this);
                        u = (EditText) findViewById(R.id.tv51);
                        p = (EditText) findViewById(R.id.tv61);
                        String usernamee;
                        String pass;
                        usernamee = u.getText().toString();
                        pass = p.getText().toString();
                        long id = userdbhelper.insertUser(usernamee, pass);
                        Toast.makeText(getBaseContext(), "You have been SuccessFully Registered " + usernamee,
                                Toast.LENGTH_SHORT).show();
                        tv34.setText("");
                        tv.setText("");
                        u.setText("");
                        p.setText("");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


                break;

        }
    }
}
