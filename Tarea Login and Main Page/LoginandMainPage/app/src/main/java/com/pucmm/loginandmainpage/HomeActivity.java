package com.pucmm.loginandmainpage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager)getSystemService(HomeActivity.this.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                CharSequence text = "Signing in..";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(HomeActivity.this, text, duration);
                toast.show();
                new Handler().postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        startActivity(new Intent(HomeActivity.this, DrawerActivity.class));
                    }
                }, 2000);

            }
        });

    }
}