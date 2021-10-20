package com.example.lottoprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.*;


public class MainActivity extends AppCompatActivity {

    TextView RFNum, BNum;
    Button RafBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RFNum = (TextView)findViewById(R.id.RaffleNum);
        BNum = (TextView)findViewById(R.id.BonusNum);
        RafBtn = (Button)findViewById(R.id.RafBtn);

        RafBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 로또번호 6개를 담아둘 ArrayList 생성
                List<Integer> RaffleNums = new ArrayList<>();

                while(RaffleNums.size() < 6) {
                    // Math.random()의 결과값이 0보다 크고 1보다 작으므로
                    // 0.999999 * 45 결과 값이 무조건 45보다 작으므로
                    // 정수 변환시 무조건 0~44범위를 가지게 됨
                    // 그래서 마지막에 1을 더해서 1~45범위로 교체해주고
                    int getNum = (int)(Math.random() * 45) + 1;

                    // 기존 당첨번호에 중복되는지 여부 확인해서 없는 번호인 경우만 넣기
                    // RaffleNums가 소유하지 않은 번호라면
                    if(!RaffleNums.contains(getNum)) {
                        RaffleNums.add(getNum);
                    }
                }
                // 번호를 보기 좋게 정렬
                Collections.sort(RaffleNums);

                // 2등 번호 추첨
                int bonusNum = 0;
                // bonusNum이 0이거나 (보너스 번호 추첨한적 없음)
                // 0이 아니어도
                while(bonusNum == 0 || RaffleNums.contains(bonusNum)) {
                    bonusNum = (int)(Math.random() * 45) + 1;
                }

                // 모든 추첨이 끝난 후 결과페이지 출력하기
                RFNum.setText(RaffleNums + "");
                BNum.setText(bonusNum + "");
            }
        });
    }
}