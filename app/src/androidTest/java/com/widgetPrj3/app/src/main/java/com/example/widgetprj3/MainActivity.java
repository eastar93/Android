package com.example.widgetprj3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 창 부품 선언
    EditText EditT1;
    Button Btn1;
    TextView TextV1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn1 = (Button)findViewById(R.id.Btn1);
        EditT1 = (EditText)findViewById(R.id.EditT1);
        TextV1 = (TextView)findViewById(R.id.EditT1);

        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("click", "클릭됨");
                // EditText내부 부품 값을 얻어주세요.
                String result = EditT1.getText().toString();
                // 얻어온 값을 로그로 찍어주세요.
                Log.i("detect",result);
                // 얻어온 값을 토스트로 찍어보세요.
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
            }
        });
    }
}