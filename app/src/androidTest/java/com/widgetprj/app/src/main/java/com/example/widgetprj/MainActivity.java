package com.example.widgetprj;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // 창부품 TextView 3개 선언
    TextView tv1, tv2, tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TextView 3개를 연결해보세요
        tv1 = (TextView)findViewById(R.id.textView7);
        tv2 = (TextView)findViewById(R.id.textView8);
        tv3 = (TextView)findViewById(R.id.textView9);

        // TextView1의 문장을 변환하기.
        tv1.setText("안녕하세요 TextView1입니다.");
        tv1.setTextColor(Color.MAGENTA);

        // TextView2의 글씨 크기를 크게 키워주세요.
        // 글꼴은 Serif로, 스타일은 italic으로 해 주세요.
        tv2.setTextSize(50);
        tv2.setTypeface(Typeface.SERIF, Typeface.ITALIC);

        // TextView3의 문장을 100글자 이상으로 늘려주세요.
        tv3.setText("길을 오아이스도 그들에게 가장 살았으며, 주는 약동하다 가슴이 가는 그것은 인류의 듣기만 석가는 거선의 열락의 지혜는 위하여서 갑 청춘이 두기 때에, 거선의 고행을 봄바람이다 청춘 더운지라 두기 그들의 산야에 구할 곳으로 것이다");
    }
}