package com.example.layoutprj5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    Button startBtn, stopBtn, resetBtn;
    Chronometer cm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        startBtn = (Button) findViewById(R.id.StartBtn);
        stopBtn = (Button) findViewById(R.id.StopBtn);
        resetBtn = (Button) findViewById(R.id.ResetBtn);
        cm = (Chronometer) findViewById(R.id.cm);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cm.start();
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cm.stop();
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               cm.setBase(SystemClock.elapsedRealtime());
               cm.stop();
            }
        });
    }
}