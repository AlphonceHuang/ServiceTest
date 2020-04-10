package com.example.servicetest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private final String TAG = "Alan";

    private boolean running = false;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){

        running = true;
        Log.w(TAG, "onStartCommand");

        new Thread() {
            @Override
            public void run() {
                super.run();

                while (running) {
                    Log.i(TAG, "Service running!!");
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Log.i(TAG, "Service stop!!");
            }
        }.start();

        return super.onStartCommand(intent, flags, startId);
    }
}
