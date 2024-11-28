package com.jonander2233.ejerciciointents;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.File;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_CAMERA_PERMISSION = 100;
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
                    openWeb();
                } else if (view.getId() == R.id.bCountryList) {

                }else if (view.getId() == R.id.bCall) {
                    doCall();
                }else if (view.getId() == R.id.bMaps) {
                    openMaps(view);
                }else if (view.getId() == R.id.bPhoto) {
                    requestCameraPermission();
                }else if (view.getId() == R.id.bSendMail) {
                    sendEmail();
                }
            }
        };
        bOpenWeb.setOnClickListener(listener);
        bCountryList.setOnClickListener(listener);
        bCall.setOnClickListener(listener);
        bMaps.setOnClickListener(listener);
        bPhoto.setOnClickListener(listener);
        bSendMail.setOnClickListener(listener);
    }

    private void sendEmail() {
        String[] recipients = {"destinatario@example.com"}; // Destinatarios del correo
        String subject = "Asunto del correo";
        String body = "Cuerpo del correo.";

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // Asegúrate de usar "mailto:" para las apps de correo
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);

        // Verifica si hay aplicaciones que puedan manejar el Intent
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, "Elige una aplicación para enviar el correo"));
        } else {
            // Maneja el caso en que no haya aplicaciones de correo disponibles
            Toast.makeText(this, "No hay aplicaciones de correo instaladas.", Toast.LENGTH_SHORT).show();
        }
    }

    private void openMaps(View view) {
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
    }
    private void openWeb() {
        String url = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    private void requestCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA_PERMISSION);
        } else {
            openCamera();
        }
    }

    private void openCamera() {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)){
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
            } else {
                Toast.makeText(this, "No se puede abrir la cámara.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            // Obtener el Bitmap de la imagen tomada
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            ImageView imageView = findViewById(R.id.ivPhoto);
            imageView.setImageBitmap(imageBitmap);

            Toast.makeText(this, "Foto tomada con éxito", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "La foto no se tomó.", Toast.LENGTH_SHORT).show();
        }
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