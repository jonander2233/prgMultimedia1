package com.jonander2233.testspinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Spinner cmbOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.valores_array,android.R.layout.simple_spinner_item);
        //asignamos el spinner del layout a la variable cmbOpciones
        cmbOpciones = (Spinner)findViewById(R.id.CmbOpciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //asignamos el adaptador al spinner
        cmbOpciones.setAdapter(adapter);

        cmbOpciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent,android.view.View v, int position, long id) {
                //no se que coño es un lblMensaje
//                lblMensaje.setText("Seleccionado: " + parent.getItemAtPosition(position));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
//                lblMensaje.setText("Nada seleccionado");
            }
        });
    }
}