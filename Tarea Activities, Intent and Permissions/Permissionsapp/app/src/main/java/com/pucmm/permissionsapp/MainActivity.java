package com.pucmm.permissionsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CAMERA;

public class MainActivity extends AppCompatActivity {

    private int STORAGE_PERMISSION_CODE = 1;
    private int LOCATION_PERMISSION_CODE = 2;
    private int CAMERA_PERMISSION_CODE = 3;
    private int PHONE_PERMISSION_CODE = 4;
    private int CONTACTS_PERMISSION_CODE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonRequest = findViewById(R.id.continueButton);
        buttonRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        final Switch firstSwitch = findViewById(R.id.switch1);
        int granted = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE);
        if(granted == PackageManager.PERMISSION_GRANTED){
            firstSwitch.setChecked(true);
        }
        if(granted == PackageManager.PERMISSION_DENIED){
            firstSwitch.setChecked(false);
        }
        firstSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int granted = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE);
                if(granted == PackageManager.PERMISSION_GRANTED){
                    firstSwitch.setChecked(true);
                }

                if(ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(MainActivity.this, "You cannot remove a granted permission", Toast.LENGTH_SHORT).show();
                }
                else{
                    requestStoragePermission(Manifest.permission.READ_EXTERNAL_STORAGE, STORAGE_PERMISSION_CODE);
                }
            }
        });


        final Switch secondSwitch = findViewById(R.id.switch2);
        granted = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION);
        if(granted == PackageManager.PERMISSION_GRANTED){
            secondSwitch.setChecked(true);
        }
        if(granted == PackageManager.PERMISSION_DENIED){
            secondSwitch.setChecked(false);
        }
        secondSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int granted = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION);
                if(granted == PackageManager.PERMISSION_GRANTED){
                    secondSwitch.setChecked(true);
                }

                if(ContextCompat.checkSelfPermission(getApplicationContext(),
                        ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(MainActivity.this, "You cannot remove a granted permission", Toast.LENGTH_SHORT).show();
                }
                else{
                    requestStoragePermission(Manifest.permission.ACCESS_FINE_LOCATION, LOCATION_PERMISSION_CODE);
                }
            }
        });

        final Switch thirdSwitch = findViewById(R.id.switch3);
        granted = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA);
        if(granted == PackageManager.PERMISSION_GRANTED){
            thirdSwitch.setChecked(true);
        }
        if(granted == PackageManager.PERMISSION_DENIED){
            thirdSwitch.setChecked(false);
        }
        thirdSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int granted = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA);
                if(granted == PackageManager.PERMISSION_GRANTED){
                    thirdSwitch.setChecked(true);
                }

                if(ContextCompat.checkSelfPermission(getApplicationContext(),
                        CAMERA) == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(MainActivity.this, "You cannot remove a granted permission", Toast.LENGTH_SHORT).show();
                }
                else{
                    requestStoragePermission(Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE);
                }
            }
        });

        final Switch fourthSwitch = findViewById(R.id.switch4);
        granted = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE);
        if(granted == PackageManager.PERMISSION_GRANTED){
            fourthSwitch.setChecked(true);
        }
        if(granted == PackageManager.PERMISSION_DENIED){
            fourthSwitch.setChecked(false);
        }
        fourthSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int granted = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE);
                if(granted == PackageManager.PERMISSION_GRANTED){
                    fourthSwitch.setChecked(true);
                }

                if(ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(MainActivity.this, "You cannot remove a granted permission", Toast.LENGTH_SHORT).show();
                }
                else{
                    requestStoragePermission(Manifest.permission.CALL_PHONE, PHONE_PERMISSION_CODE);
                }
            }
        });

        final Switch fifthSwitch = findViewById(R.id.switch5);
        granted = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_CONTACTS);
        if(granted == PackageManager.PERMISSION_GRANTED){
            fifthSwitch.setChecked(true);
        }
        if(granted == PackageManager.PERMISSION_DENIED){
            fifthSwitch.setChecked(false);
        }
        fifthSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int granted = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_CONTACTS);
                if(granted == PackageManager.PERMISSION_GRANTED){
                    fifthSwitch.setChecked(true);
                }

                if(ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(MainActivity.this, "You cannot remove a granted permission", Toast.LENGTH_SHORT).show();
                }
                else{
                    requestStoragePermission(Manifest.permission.READ_CONTACTS, CONTACTS_PERMISSION_CODE);
                }
            }
        });

        Button continueButton = findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPermissionsScreen();
            }
        });
    }

    public void requestStoragePermission(final String permission, final int CODE) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)){
            new AlertDialog.Builder(this)
                    .setTitle("Permission needed")
                    .setMessage("Permission is needed for app to work.")
                    .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{permission}, CODE);
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create()
                    .show();
        }
        else{
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{permission},CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == STORAGE_PERMISSION_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Storage Permission Granted", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Storage Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
        if (requestCode == LOCATION_PERMISSION_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Location Permission Granted", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Location Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
        if (requestCode == CAMERA_PERMISSION_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Camera Permission Granted", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Camera Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
        if (requestCode == PHONE_PERMISSION_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Phone Permission Granted", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Phone Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
        if (requestCode == CONTACTS_PERMISSION_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Contacts Permission Granted", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Contacts Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void openPermissionsScreen(){
        Intent intent =  new Intent(this, PermissionActivity.class);
        startActivity(intent);
    }
}