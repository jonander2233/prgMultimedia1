package com.jonander2233.tema01.ejercicio04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jonander2233.tema01.ejercicio04.cuerdasYPoleas.*;

public class MainActivity extends AppCompatActivity {
    private ElementosJuego jugada;
    private Partida partida;
    private Button bJugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bPierda = findViewById(R.id.bPiedra);
        Button bPapel = findViewById(R.id.bPapel);
        Button bTijeras = findViewById(R.id.bTijeras);
        bJugar  = findViewById(R.id.bJugar);
        ImageView imagencpu= findViewById(R.id.ivCpu);
        ImageView imagenjugador = findViewById(R.id.ivJugador);
        TextView tvResult = findViewById(R.id.tvResult);
        boolean reset = false;
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.bJugar){
                    if(jugada != null){

                    } else {
                        Toast.makeText(MainActivity.this, "Primero selecciona una opción", Toast.LENGTH_SHORT).show();
                    }
                } else if (v.getId() == R.id.bPapel) {
                    jugada = ElementosJuego.PAPEL;
                } else if (v.getId() == R.id.bTijeras) {
                    jugada = ElementosJuego.TIJERA;
                } else if (v.getId() == R.id.bPiedra) {
                    jugada = ElementosJuego.PIEDRA;
                }
            }
        };
    }
    private void jugar(){
        partida = CuerdasYPoleas.jugarVsCpu(jugada);
        switch (partida.getSeleccionCpu()){
            case PAPEL:
                imagencpu.setImageResource(R.drawable.paper);
                break;
            case PIEDRA:
                imagencpu.setImageResource(R.drawable.pedra);
                break;
            case TIJERA:
                imagencpu.setImageResource(R.drawable.tisores);
                break;
            default:
                break;
        }


        switch (partida.getSeleccionJugador()){
            case TIJERA:
                imagenjugador.setImageResource(R.drawable.tisores);
                break;
            case PAPEL:
                imagenjugador.setImageResource(R.drawable.paper);
                break;
            case PIEDRA:
                imagenjugador.setImageResource(R.drawable.pedra);
                break;
            default:
                break;
        }

        switch (partida.getResultado()){
            case GANAR:
                tvResult.setText(R.string.resultWin);
                break;
            case EMPATAR:
                tvResult.setText(R.string.resultDraw);
                break;
            case PERDER:
                tvResult.setText(R.string.resultLose);
                break;
            default:
                break;
        }
    }
}