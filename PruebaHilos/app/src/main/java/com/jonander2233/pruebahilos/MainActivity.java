package com.jonander2233.pruebahilos;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ProgressBar bar;
    private TextView tvHilo;
    private ResultReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bTarea = findViewById(R.id.bTarea);
        bar = findViewById(R.id.pbLoad);
        tvHilo = findViewById(R.id.tvHilo);
        bar.setMin(0);
        bar.setMax(100);
        receiver = new ResultReceiver(null);

        bTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tareaLarga1(10);
                Toast.makeText(MainActivity.this, "Tarea terminada", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void tareaLarga1(int segundos){
        bar.setProgress(0);
        Intent intent= new Intent(this,MyService.class);
        intent.putExtra("reciver",receiver);
        startService(intent);
        intent.putExtra("segundos",segundos);
    }


    public void tareaLarga(int segundos){
        bar.setProgress(0);
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < segundos ; i++) {
                    try {
                        Thread.sleep(1000);
                        bar.incrementProgressBy(100/segundos);
                        int finalI = i;
                        tvHilo.post(new Runnable() {
                            @Override
                            public void run() {
                                tvHilo.setText(String.valueOf(finalI));
                            }
                        });
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        hilo.start();
    }
    public class MyResultReceiver extends ResultReceiver{

        public MyResultReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            switch (resultCode){
                case 0:
                    Log.i("ResultCode",String.valueOf(resultData.getInt("progreso")));
                    bar.setProgress(resultData.getInt("progreso"));
                    break;
                case 1:
                    break;
                default:
                    break;
            }
        }
    }
}