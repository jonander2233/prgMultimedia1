package com.example.tema01.ejercicio03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tema01.ejercicio03.engranajes.Engranajes;

public class MainActivity extends AppCompatActivity {
    boolean eleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button botonHead = findViewById(R.id.buttonHead);
        Button botonTail = findViewById(R.id.buttonTail);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.buttonHead){
                    mostrarResultado(true);
                    //cara será true
                } else if (v.getId() == R.id.buttonTail) {
                    //cruz será false
                    mostrarResultado(false);
                }
            }
        };
        botonHead.setOnClickListener(listener);
        botonTail.setOnClickListener(listener);
    }
    void mostrarResultado(boolean eleccion){
        boolean resultado = Engranajes.caraOCruz();
        TextView result = findViewById(R.id.tvResult);
        ImageView imagen = findViewById(R.id.imageView);

        //resultado será true o false, si es true el resultado será cara, si es false será cruz


        if(resultado){
            imagen.setImageResource(R.drawable.euro_cara);
            imagen.setScaleX(1);
            imagen.setScaleY(1);

//            result.setText("cara");

        }else {
            imagen.setImageResource(R.drawable.euro_cruz);
            imagen.setScaleX(1);
            imagen.setScaleY(1);
//            result.setText("cruz");

        }
        if (resultado == eleccion){
            result.setText(R.string.winText);
        }else{
            result.setText(R.string.loseText);
        }
    }
}