package com.gaurav.examsportal;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.facebook.login.LoginManager;

public class MainPage extends AppCompatActivity {
    boolean doubleBackToExitPressedOnce = false;


    public void onHtml(View view) {
        String a1 = "1";
        Intent i = new Intent(MainPage.this, Level.class);
        i.putExtra("b1", a1);
        startActivity(i);
    }

    public void onJava(View view) {
        String a1 = "2";
        Intent i = new Intent(MainPage.this, Level.class);
        i.putExtra("b1", a1);
        startActivity(i);
    }

    public void onPhp(View view) {
        String a1 = "3";
        Intent i = new Intent(MainPage.this, Level.class);
        i.putExtra("b1", a1);
        startActivity(i);
    }

    public void onMath(View view) {
        String a1 = "4";
        Intent i = new Intent(MainPage.this, Level.class);
        i.putExtra("b1", a1);
        startActivity(i);
    }

    public void onEnglish(View view) {
        String a1 = "5";
        Intent i = new Intent(MainPage.this, Level.class);
        i.putExtra("b1", a1);
        startActivity(i);
    }

    public void onSql(View view) {
        String a1 = "6";
        Intent i = new Intent(MainPage.this, Level.class);
        i.putExtra("b1", a1);
        startActivity(i);
    }

    public void onPhysics(View view) {
        String a1 = "7";
        Intent i = new Intent(MainPage.this, Level.class);
        i.putExtra("b1", a1);
        startActivity(i);
    }

    public void onChemistry(View view) {
        String a1 = "8";
        Intent i = new Intent(MainPage.this, Level.class);
        i.putExtra("b1", a1);
        startActivity(i);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }


    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            finish();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press BACK again to exit...", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sign_out) {
            Intent intent = getIntent();
            Log.d("14", "14");
            String z = intent.getExtras().getString("gaggy");
            Log.d("13", "13");
            if (z.equals("18")) {
                Log.d("11", "11");
                LoginManager.getInstance().logOut();
                Intent intent3 = new Intent(MainPage.this, MainActivity.class);
                startActivity(intent3);
                finish();
            } else if (z.equals("17")) {
                Log.d("12", "12");
                Intent intent1 = new Intent(MainPage.this, MainActivity.class);
                startActivity(intent1);
                finish();
            }


            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
