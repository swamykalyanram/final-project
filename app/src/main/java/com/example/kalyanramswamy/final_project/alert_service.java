package com.example.kalyanramswamy.final_project;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.SystemClock;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.widget.Toast;

import swarajsaaj.smscodereader.interfaces.OTPListener;
import swarajsaaj.smscodereader.receivers.OtpReader;

/**
 * Created by kalyanramswamy on 16/03/17.
 */

public class alert_service extends Service implements OTPListener {

    PowerManager.WakeLock wakeLock;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        OtpReader.bind(this,"51465");
        Toast.makeText(this,"service started!",Toast.LENGTH_LONG).show();
    }

    @Override
    public void otpReceived(String smsText) {
        //Do whatever you want to do with the text
        String[] parts = smsText.split("-");
        String alert = parts[1];

        if (alert.contains("driver is sleepy")) {
            Intent sound = new Intent(this, soundActivity.class);
            sound.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(sound);
        }
    }
}