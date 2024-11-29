package com.jonander2233.pruebahilos;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.util.Log;

public class MyService extends Service {
    private Thread hilo;
    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int segundos = intent.getIntExtra("segundos",10);
        ResultReceiver result = intent.getParcelableExtra("receiver");
        if(hilo == null  || !hilo.isAlive()){
            hilo = new Thread(new Runnable() {
                @Override
                public void run() {
                    Bundle bundle = new Bundle();
                    for (int i = 1; i <= segundos ; i++) {
                        try {
                            Log.i("Hilo","Valor de i " + i);
                            Thread.sleep(1000);
                            bundle.putInt("progreso",(100/segundos)*i);
                            result.send(0,bundle);
                        }catch (InterruptedException e){
                            throw new RuntimeException(e);
                        }
                    }
                }
            });
            hilo.start();
        }
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}