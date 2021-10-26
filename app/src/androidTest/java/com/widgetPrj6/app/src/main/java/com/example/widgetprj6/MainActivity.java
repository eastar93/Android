package com.example.widgetprj6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    // 부품 생성
    // 뷰플리퍼 변수 하나, 버튼 2개, 뷰플리퍼는 final도 붙여야함
    Button PBtn, NBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        // 뷰 플리퍼는 final로 선언해야 제대로 돌아가기 때문에 onCreate안쪽에 선언
        // 다른 브픔들은 일반적으로 선언 위치를 따로 정해져있지 않습니다.
        final ViewFlipper VF;
        VF = (ViewFlipper) findViewById(R.id.VFlipper);
        PBtn = (Button) findViewById(R.id.PBtn);
        NBtn = (Button) findViewById(R.id.NBtn);

        PBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VF.showPrevious(); // 전 페이지 넘어가기
            }
        });

        NBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VF.showNext();
            }
        });
    }
}