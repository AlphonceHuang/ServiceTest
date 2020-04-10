package com.example.servicetest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG="Alan";

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        Log.w(TAG, "StaticReceiver: BroadcastReceiver:"+action);

        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            Toast.makeText(context, "MyBroadcastReceiver 收到我的廣播了", Toast.LENGTH_LONG).show();

            // 啟動service
            Intent serviceIntent = new Intent(context, MyService.class);
            context.startService(serviceIntent);
/*
            // 啟動Activity
            Intent activityIntent = new Intent(context, MainActivity.class);
            activityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(activityIntent);
 */
        }
    }
}
