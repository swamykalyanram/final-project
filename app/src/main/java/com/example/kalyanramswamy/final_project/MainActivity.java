package com.example.kalyanramswamy.final_project;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import swarajsaaj.smscodereader.interfaces.OTPListener;
import swarajsaaj.smscodereader.receivers.OtpReader;

public class MainActivity extends ActionBarActivity implements OTPListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OtpReader.bind(this,"51465");
        Toast.makeText(this,"app started",Toast.LENGTH_LONG).show();
    }

    @Override
    public void otpReceived(String smsText) {
        //Do whatever you want to do with the text
        Toast.makeText(this,"Got "+smsText,Toast.LENGTH_LONG).show();
        Log.d("Otp",smsText);
    }
}
