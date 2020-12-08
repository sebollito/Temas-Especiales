package com.pucmm.permissionsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PermissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        Button phoneButton = findViewById(R.id.phoneButton);

        phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(PermissionActivity.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(PermissionActivity.this, "Calling KFC", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:+8095080000")));
                }
                else{
                    Toast.makeText(PermissionActivity.this, "Phone permission isn't granted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button storageButton = findViewById(R.id.storageButton);

        storageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(PermissionActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(PermissionActivity.this, "Opening Downloads", Toast.LENGTH_SHORT).show();
                    Uri selected = Uri.parse(Environment.getExternalStorageState());
                    Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                    intent.addCategory(Intent.CATEGORY_OPENABLE);
                    intent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(PermissionActivity.this, "Storage permission isn't granted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button cameraButton = findViewById(R.id.cameraButton);

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(PermissionActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(PermissionActivity.this, "Opening Camera", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent("android.media.action.IMAGE_CAPTURE"));
                }
                else{
                    Toast.makeText(PermissionActivity.this, "Camera permission isn't granted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button locationButton = findViewById(R.id.locationButton);

        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(PermissionActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(PermissionActivity.this, "Displaying Location", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:18.463207, -69.929365")));
                }
                else{
                    Toast.makeText(PermissionActivity.this, "Location permission isn't granted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button contactsButton = findViewById(R.id.contactsButton);

        contactsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(PermissionActivity.this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(PermissionActivity.this, "Displaying Contacts", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Intent.ACTION_VIEW, ContactsContract.Contacts.CONTENT_URI));
                }
                else{
                    Toast.makeText(PermissionActivity.this, "Contacts permission isn't granted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 4) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Storage Permission Granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Storage Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}