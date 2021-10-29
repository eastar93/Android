package com.example.activity2prj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button GoSub1Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GoSub1Btn = (Button) findViewById(R.id.GoSub1);

        GoSub1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent로 sub1으로 넘어가도록 설정
                // 목적지는 SubActivity1
                Intent intent = new Intent(getApplicationContext(), SubActivity1.class);

                startActivity(intent);
            }
        });

    }
}