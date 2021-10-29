package com.example.explicitintentprj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SubActivity2 extends Activity {

    TextView message;
    Button GoBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub2);

        GoBack = (Button) findViewById(R.id.GoBack);
        message = (TextView) findViewById(R.id.message);

        Intent intent = getIntent();

        String getData = intent.getStringExtra("text");

        message.setText(getData);

        GoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
