package com.example.loginprj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class LoginSuccessActivity extends Activity {

    Button Logout;
    TextView connectID, SuccessMent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginsuccess);

        Logout = (Button) findViewById(R.id.Logout);
        connectID = (TextView) findViewById(R.id.connectID);
        SuccessMent = (TextView) findViewById(R.id.SuccessMent);

        Intent intent = getIntent();

        String id = intent.getStringExtra("id");

        connectID.setText(id + "님이 접속중");

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
