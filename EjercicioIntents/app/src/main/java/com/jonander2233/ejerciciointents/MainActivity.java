package com.jonander2233.ejerciciointents;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final int TAG = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createButtons();
    }




    private void createButtons(){
        Button bOpenWeb = findViewById(R.id.bOpenWeb);
        Button bCountryList = findViewById(R.id.bCountryList);
        Button bCall = findViewById(R.id.bCall);
        Button bMaps = findViewById(R.id.bMaps);
        Button bPhoto = findViewById(R.id.bPhoto);
        Button bSendMail = findViewById(R.id.bSendMail);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.bOpenWeb) {
                    String url = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                } else if (view.getId() == R.id.bCountryList) {

                }else if (view.getId() == R.id.bCall) {
                    doCall();
                }else if (view.getId() == R.id.bMaps) {
                    String latitude = "38.78875";
                    String longitude = "0.178611";
                    String uri = "geo:" + latitude + "," + longitude;
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                    intent.setPackage("com.google.android.apps.maps");
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(view.getContext(), "Google Maps no está instalado en este dispositivo.", Toast.LENGTH_SHORT).show();
                    }
                }else if (view.getId() == R.id.bPhoto) {

                }else if (view.getId() == R.id.bSendMail) {

                }
            }
        };
        bOpenWeb.setOnClickListener(listener);
        bCountryList.setOnClickListener(listener);
        bCall.setOnClickListener(listener);
        bMaps.setOnClickListener(listener);
        bPhoto.setOnClickListener(listener);
    }
    private void doCall(){
        String telephoneNumber = "666666666";
        if(ActivityCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},TAG);
        }else {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telephoneNumber));
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == TAG){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                doCall();
            }
        }
    }
}