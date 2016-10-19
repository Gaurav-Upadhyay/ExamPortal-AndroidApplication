package com.gaurav.examsportal;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.facebook.FacebookSdk;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    CallbackManager callbackManager;
    EditText user_name;
    EditText user_pass;
    private static final String TAG = "SignInActivity";
    private static final int RC_SIGN_IN = 9001;
    private GoogleApiClient mGoogleApiClient;


    public void onRegister(View view) {
        Intent intent = new Intent(MainActivity.this, SignUp.class);
        startActivity(intent);
        finish();
    }

    public void onAdminLogIn(View view) {
        Intent intent = new Intent(MainActivity.this, AdminLogin.class);
        startActivity(intent);
        finish();
    }

    protected void facebookSDKInitialize() {

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
    }

    protected void getLoginDetails(LoginButton login_button) {

        // Callback registration
        login_button.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult login_result) {
                Intent intent = new Intent(MainActivity.this, MainPage.class);
                intent.putExtra("gaggy", "18");
                startActivity(intent);
                finish();


            }

            @Override
            public void onCancel() {
                // code for cancellation
                Toast.makeText(getBaseContext(), "Operation Canceled", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException exception) {
                //  code to handle error
                Toast.makeText(getBaseContext(), "Oops, Something went wrong\ncheck your internet connection", Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
        callbackManager.onActivityResult(requestCode, resultCode, data);
        Log.e("data", data.toString());
    }


    @Override
    protected void onResume() {
        super.onResume();
        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        facebookSDKInitialize();
        setContentView(R.layout.activity_main);
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");
        getLoginDetails(loginButton);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();


        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, null /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();


        SignInButton signInButton = (SignInButton) findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_WIDE);
        signInButton.setScopes(gso.getScopeArray());


        user_name = (EditText) findViewById(R.id.username22);
        user_pass = (EditText) findViewById(R.id.password22);
        findViewById(R.id.button_sign_in).setOnClickListener(this);
        findViewById(R.id.sign_in_button).setOnClickListener(this);
    }


    private void handleSignInResult(GoogleSignInResult result) {
        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();
            updateUI(true);
        } else {
            Toast.makeText(getBaseContext(), "Oops, something went wrong\ncheck internet connection", Toast.LENGTH_LONG).show();
            Log.d("Tag4", "Tag4");
            // Signed out, show unauthenticated UI.
        }
    }

    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void updateUI(boolean signedIn) {
        if (signedIn) {
            Intent intent = new Intent(MainActivity.this, MainPage.class);
            intent.putExtra("gaggy", "17");
            startActivity(intent);
            finish();
        } else {
            findViewById(R.id.sign_in_button).setVisibility(View.VISIBLE);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_button:
                signIn();
                break;


            case R.id.button_sign_in:

                if (user_name.getText().toString().length() == 0 && user_pass.getText().toString().length() == 0) {
                    user_name.setError("Username cannot be blank");
                    user_pass.setError("Password cannot be blank");
                } else if (user_name.getText().toString().length() == 0 && user_pass.getText().toString().length() < 5) {
                    user_name.setError("Username cannot be blank");
                    user_pass.setError("Atleast 5 letters");
                } else if (user_name.getText().toString().length() == 0 && user_pass.getText().toString().length() > 5) {
                    user_name.setError("Username cannot be blank");
                } else if (user_name.getText().toString().length() < 5 && user_pass.getText().toString().length() == 0) {
                    user_name.setError("Atleast 5 letters");
                    user_pass.setError("Password cannot be blank");
                } else if (user_name.getText().toString().length() < 5 && user_pass.getText().toString().length() < 5) {
                    user_name.setError("Atleast 5 letters");
                    user_pass.setError("Atleast 5 letters");
                } else if (user_name.getText().toString().length() < 5 && user_pass.getText().toString().length() > 5) {
                    user_name.setError("Atleast 5 letters");
                } else if (user_name.getText().toString().length() > 5 && user_pass.getText().toString().length() == 0) {
                    user_pass.setError(" Password cannot be blank");
                } else if (user_name.getText().toString().length() > 5 && user_pass.getText().toString().length() < 5) {
                    user_pass.setError("Atleast 5 letters");
                } else if (user_name.getText().toString().length() >= 5 && user_pass.getText().toString().length() >= 5) {

                    final LoginDBHelper usrdb = new LoginDBHelper(this);
                    String userd = user_name.getText().toString();
                    String userp = user_pass.getText().toString();
                    Cursor c = usrdb.retrieveUser(userd);
                    if (c.moveToFirst()) {
                        Log.d("Tag", "Tag");
                        if (userp.equals(c.getString(1))) {
                            Intent intent = new Intent(MainActivity.this, MainPage.class);
                            intent.putExtra("gaggy", "17");
                            startActivity(intent);

                            finish();
                        } else {
                            Toast.makeText(getBaseContext(), "Incorrect Password", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getBaseContext(), "No  Record Found", Toast.LENGTH_SHORT).show();
                    }


                }
                break;

        }
    }

}
