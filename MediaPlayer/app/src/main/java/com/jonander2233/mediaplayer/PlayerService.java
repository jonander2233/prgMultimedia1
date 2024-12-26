package com.jonander2233.mediaplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class PlayerService extends Service {
    private final PlayerBinder playerBinder = new PlayerBinder();
    private MediaPlayer player;
    public PlayerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return playerBinder;
    }
    public void play(){
        if(player == null){
            player = MediaPlayer.create(this,R.raw.alarm);
        }
        player.start();

    }
    public void pause(){
        player.pause();
    }
    public boolean isPlaying(){
        return player != null && player.isPlaying();
    }

    public class PlayerBinder extends Binder{
        public PlayerService getService(){
            return PlayerService.this;
        }
    }
}