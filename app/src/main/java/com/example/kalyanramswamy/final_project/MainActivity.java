package com.example.kalyanramswamy.final_project;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.PowerManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import static android.Manifest.*;

public class MainActivity extends ActionBarActivity{
    PowerManager.WakeLock wakeLock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PowerManager powermanager =(PowerManager) getSystemService(POWER_SERVICE);
        final PowerManager.WakeLock wakelock=powermanager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,"kalyan ram");
        wakelock.acquire();

        Intent i= new Intent(getApplicationContext(),alert_service.class);
        startService(i);
    }
}
