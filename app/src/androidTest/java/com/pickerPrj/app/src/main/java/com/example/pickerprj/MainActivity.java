package com.example.pickerprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DatePicker dPicker;
    Button ChInBtn, ChOutBtn;
    TextView ChInT, ChOutT;

    Integer Year, Month, Day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dPicker = (DatePicker) findViewById(R.id.dPicker);
        ChInBtn = (Button) findViewById(R.id.CheckInBtn);
        ChOutBtn = (Button) findViewById(R.id.CheckOutBtn);
        ChInT = (TextView) findViewById(R.id.CheckInTV);
        ChOutT = (TextView) findViewById(R.id.CheckOutTV);

        Year = dPicker.getYear();
        Month = dPicker.getMonth() + 1;
        Day = dPicker.getDayOfMonth();
        
        // 날짜 처리는 DataPicker에 날짜가 변할때마다 변수에 담는것으로 처리합니다.
        // 창이 열리자마자 가져오게 할때는 dPicker.getYear(), getMonthOfYear() 등을 활용
        dPicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view,
                                      int year,
                                      int monthOfYear,
                                      int dayOfMonth) {
                Year = year;
                Month = monthOfYear + 1;
                Day = dayOfMonth;
                Log.d("날짜",
                        year + "년/" + (monthOfYear + 1) + "월/" + dayOfMonth + "일");
            }
        });

        ChInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChInT.setText(Year + "년/" + Month + "월/" + Day + "일");
            }
        }); // 체크인 버틀 눌렀을때

        ChOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChOutT.setText(Year + "년/" + Month + "월/" + Day + "일");
            }
        }); // 체크아웃 버틀 눌렀을때
    }
}