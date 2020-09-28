package com.pucmm.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    public static final String FIRSTNAME = "FIRSTNAME";
    public static final String LASTNAME = "LASTNAME";
    public static final String GENDER = "GENDER";
    public static final String DATE = "DATE";
    public static final String SI = "SI";
    public static final String NO = "NO";

    private Button btnSend;
    private EditText firstName;
    private EditText lastName;
    private Spinner gender;
    private EditText date;
    private RadioButton si;
    private RadioButton no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = findViewById(R.id.btnSend);
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        gender = findViewById(R.id.gender);
        date = findViewById(R.id.date);
        si = findViewById(R.id.si);
        no = findViewById(R.id.no);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.select_gender, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        gender.setAdapter(adapter);

    }

    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra(MainActivity.FIRSTNAME, firstName.getText().toString());
        intent.putExtra(MainActivity.LASTNAME, lastName.getText().toString());
        intent.putExtra(MainActivity.GENDER, gender.getSelectedItem().toString());
        intent.putExtra(MainActivity.DATE, date.getText().toString());
        intent.putExtra(MainActivity.SI, si.getText().toString());
        intent.putExtra(MainActivity.NO, no.getText().toString());
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}