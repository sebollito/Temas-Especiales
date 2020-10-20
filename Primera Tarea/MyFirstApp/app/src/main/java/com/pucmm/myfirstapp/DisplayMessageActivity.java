package com.pucmm.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    private TextView showFirstName;
    private TextView showLastName;
    private TextView showGender;
    private TextView showDate;
    private TextView showOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        showFirstName = findViewById(R.id.showFirstName);
        showLastName = findViewById(R.id.showLastName);
        showGender = findViewById(R.id.showGender);
        showDate = findViewById(R.id.showDate);
        showOption = findViewById(R.id.showOption);

        Intent intent = getIntent();

        String firstMessage = intent.getStringExtra("FIRSTNAME");
        String lastMessage = intent.getStringExtra("LASTNAME");
        String genderMessage = intent.getStringExtra("GENDER");
        String dateMessage = intent.getStringExtra("DATE");
        String siMessage = intent.getStringExtra("SI");
        String noMessage = intent.getStringExtra("NO");



        showFirstName.setText("Hola!, mi nombre es: " + firstMessage);
        showLastName.setText("Y mi apellido es: " + lastMessage);
        showGender.setText("Soy " + genderMessage);
        showDate.setText("Y naci en fecha: "+ dateMessage);

        if (siMessage == "SI"){
            showOption.setText("Me gusta programar.");
        }

        if(noMessage == "NO"){
            showOption.setText("No ne gusta programar.");
    }
    }
}