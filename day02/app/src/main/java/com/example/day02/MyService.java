package com.example.day02;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.day02.bane.Intexiazai;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
       new Thread(){
           @Override
           public void run() {
               new Intexiazai().initdatat();
           }
       }.start();
        super.onCreate();
    }
}
