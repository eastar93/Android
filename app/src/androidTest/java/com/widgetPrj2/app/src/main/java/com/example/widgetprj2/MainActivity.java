package com.example.widgetprj2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button Btn1;
    TextView TextView1;
    // 클릭할때마다 색상 변경을 위한 if문 처리용 논리변수
    Boolean bool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 초기화
        bool = true;

        // 선언된 창부품 연결
        Btn1 = (Button)findViewById(R.id.Btn1);
        TextView1 = (TextView)findViewById(R.id.TextView1);


        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 콘솔 디버깅1
                System.out.println("버튼 클릭됨");
                // 콘솔 디버깅 2 - cncjsc
                Log.i("태그명", "로깅할 내용");
                // 토스트 디버깅
                Toast.makeText(getApplicationContext(), "토스트로 디버깅 가능", Toast.LENGTH_SHORT).show();
                if (bool) {
                    TextView1.setTextSize(50);
                    TextView1.setTextColor(Color.BLUE);
                    TextView1.setTypeface(Typeface.SERIF);

                    TextView1.setText("On-ffice조 신동규");
                    bool = false;
                } else {
                    TextView1.setTextColor(Color.RED);
                    bool = true;
                }
            }
        });
    }
}

