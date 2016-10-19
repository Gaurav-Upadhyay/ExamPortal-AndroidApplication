package com.gaurav.examsportal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {
    EditText Adminname, Adminpassword;
    Button AdminLogin2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_admin_login);

        Adminname = (EditText) findViewById(R.id.Adminname);
        Adminpassword = (EditText) findViewById(R.id.logPassword);
        AdminLogin2 = (Button) findViewById(R.id.logAdmin);
        AdminLogin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Adminname.getText().toString().length() == 0 && Adminpassword.getText().toString().length() == 0) {
                    Adminname.setError("Username cannot be blank");
                    Adminpassword.setError("Password cannot be blank");
                } else if (Adminname.getText().toString().length() == 0 && Adminpassword.getText().toString().length() < 5) {
                    Adminname.setError("Username cannot be blank");
                    Adminpassword.setError("Atleast 5 letters");
                } else if (Adminname.getText().toString().length() == 0 && Adminpassword.getText().toString().length() > 5) {
                    Adminname.setError("Username cannot be blank");
                } else if (Adminname.getText().toString().length() < 5 && Adminpassword.getText().toString().length() == 0) {
                    Adminname.setError("Atleast 5 letters");
                    Adminpassword.setError("Password cannot be blank");
                } else if (Adminname.getText().toString().length() < 5 && Adminpassword.getText().toString().length() < 5) {
                    Adminname.setError("Atleast 5 letters");
                    Adminpassword.setError("Atleast 5 letters");
                } else if (Adminname.getText().toString().length() < 5 && Adminpassword.getText().toString().length() > 5) {
                    Adminname.setError("Atleast 5 letters");
                } else if (Adminname.getText().toString().length() > 5 && Adminpassword.getText().toString().length() == 0) {
                    Adminpassword.setError("Password cannot be blank");
                } else if (Adminname.getText().toString().length() > 5 && Adminpassword.getText().toString().length() < 5) {
                    Adminpassword.setError("Atleast 5 letters");
                } else if (Adminname.getText().toString().length() >= 5 && Adminpassword.getText().toString().length() >= 5) {

                    try {
                        String usernameed;
                        String pass;
                        usernameed = Adminname.getText().toString();
                        pass = Adminpassword.getText().toString();
                        if (usernameed.equals("gaurav") && pass.equals("123456")) {
                            Intent i = new Intent(AdminLogin.this, AdminPage.class);
                            startActivity(i);
                            finish();
                        }
                        else {
                            Toast.makeText(getBaseContext(),"Incorrect Username or Password",Toast.LENGTH_LONG).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }
            }

        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AdminLogin.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

