package com.gaurav.examsportal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    Button add_user;
    EditText username, password;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SignUp.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sign_up);
        final LoginDBHelper userdbhelper = new LoginDBHelper(this);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        add_user = (Button) findViewById(R.id.addUser);
        add_user.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (username.getText().toString().length() == 0 && password.getText().toString().length() == 0) {
                    username.setError("Username cannot be blank");
                    password.setError("Password cannot be blank");
                } else if (username.getText().toString().length() == 0 && password.getText().toString().length() < 5) {
                    username.setError("Username cannot be blank");
                    password.setError("Atleast 5 letters");
                } else if (username.getText().toString().length() == 0 && password.getText().toString().length() > 5) {
                    username.setError("Username cannot be blank");
                } else if (username.getText().toString().length() < 5 && password.getText().toString().length() == 0) {
                    username.setError("Atleast 5 letters");
                    password.setError("Password cannot be blank");
                } else if (username.getText().toString().length() < 5 && password.getText().toString().length() < 5) {
                    username.setError("Atleast 5 letters");
                    password.setError("Atleast 5 letters");
                } else if (username.getText().toString().length() < 5 && password.getText().toString().length() > 5) {
                    username.setError("Atleast 5 letters");
                } else if (username.getText().toString().length() > 5 && password.getText().toString().length() == 0) {
                    password.setError("Password cannot be blank");
                } else if (username.getText().toString().length() > 5 && password.getText().toString().length() < 5) {
                    password.setError("Atleast 5 letters");
                } else if (username.getText().toString().length() >= 5 && password.getText().toString().length() >= 5) {
                    Toast.makeText(getApplicationContext(), "Validated Succesfully", Toast.LENGTH_LONG).show();
                    try {
                        String usernamee;
                        String pass;
                        usernamee = username.getText().toString();
                        pass = password.getText().toString();
                        long id = userdbhelper.insertUser(usernamee, pass);
                        Toast.makeText(getBaseContext(), "You have been SuccessFully Registered, Welcome " + usernamee,
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUp.this, MainPage.class);
                        intent.putExtra("gaggy", "17");
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


            }
        });
    }


}