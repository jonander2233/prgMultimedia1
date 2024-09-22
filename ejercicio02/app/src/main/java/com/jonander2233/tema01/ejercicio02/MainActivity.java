package com.jonander2233.tema01.ejercicio02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jonander2233.tema01.ejercicio02.mathUtils.Meth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText etNumero = findViewById(R.id.etNumero);
        Button button = findViewById(R.id.button);
        TextView result = findViewById(R.id.result);
        button.setOnClickListener(view -> {
            int numero = Integer.parseInt(etNumero.getText().toString());
            long factorial = Meth.factorial(numero);
            result.setText(String.valueOf(factorial));
        });

    }
}