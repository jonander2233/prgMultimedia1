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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ElementosJuego jugada;
    private Partida partida;
    private Button bJugar;
    private ImageView imagencpu;
    private ImageView imagenjugador;
    private TextView tvResult;
    private Momento estadoActual = Momento.INICIO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bPierda = findViewById(R.id.bPiedra);
        Button bPapel = findViewById(R.id.bPapel);
        Button bTijeras = findViewById(R.id.bTijeras);
        imagencpu= findViewById(R.id.ivCpu);
        imagenjugador = findViewById(R.id.ivJugador);
        tvResult = findViewById(R.id.tvResult);


        bJugar  = findViewById(R.id.bJugar);
        bPierda.setOnClickListener(this);
        bPapel.setOnClickListener(this);
        bTijeras.setOnClickListener(this);
        bJugar.setOnClickListener(this);
    }

    private void reiniciar(){
        imagencpu.setImageResource(R.drawable.question);
        imagenjugador.setImageResource(R.drawable.question);
        tvResult.setText("");
        bJugar.setText(R.string.play);
        jugada = null;
        imagencpu.setRotation(0);
        imagenjugador.setRotation(0);
    }

    private void jugar(){
        partida = CuerdasYPoleas.jugarVsCpu(jugada);
        bJugar.setText(R.string.reset);
        switch (partida.getSeleccionCpu()){
            case PAPEL:
                imagencpu.setImageResource(R.drawable.paper);
                imagencpu.setRotation(90);
                break;
            case PIEDRA:
                imagencpu.setImageResource(R.drawable.pedra);
                imagencpu.setRotation(-90);

                break;
            case TIJERA:
                imagencpu.setImageResource(R.drawable.tisores);
                imagencpu.setRotation(90);

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

    @Override
    public void onClick(View v) {
            if(v.getId() == R.id.bJugar){
                if(jugada != null){
                    if(estadoActual == Momento.INICIO){
                        jugar();
                        estadoActual = Momento.FIN;
                    } else {
                        reiniciar();
                        estadoActual = Momento.INICIO;
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Primero selecciona una opción", Toast.LENGTH_SHORT).show();
                }
            } else if (v.getId() == R.id.bPapel) {
                imagenjugador.setImageResource(R.drawable.paper);
                imagenjugador.setRotation(-90);
                jugada = ElementosJuego.PAPEL;
            } else if (v.getId() == R.id.bTijeras) {
                imagenjugador.setImageResource(R.drawable.tisores);
                imagenjugador.setRotation(90);
                jugada = ElementosJuego.TIJERA;
            } else if (v.getId() == R.id.bPiedra) {
                imagenjugador.setImageResource(R.drawable.pedra);
                imagenjugador.setRotation(90);
                jugada = ElementosJuego.PIEDRA;
            }
    }
}