package com.example.pickerprj2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    DatePicker dPicker;
    TimePicker tPicker;
    Button ChInBtn, ChOutBtn;
    TextView ChInT, ChOutT;

    Integer Year, Month, Day, CheckInHour, CheckInMinute, CheckOutHour, CheckOutMinute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dPicker = (DatePicker) findViewById(R.id.dPicker);
        tPicker = (TimePicker) findViewById(R.id.tPicker);
        ChInBtn = (Button) findViewById(R.id.CheckInBtn);
        ChOutBtn = (Button) findViewById(R.id.CheckOutBtn);
        ChInT = (TextView) findViewById(R.id.CheckInTV);
        ChOutT = (TextView) findViewById(R.id.CheckOutTV);

        Year = dPicker.getYear();
        Month = dPicker.getMonth() + 1;
        Day = dPicker.getDayOfMonth();
        CheckInHour = tPicker.getHour();
        CheckInMinute = tPicker.getMinute();
        CheckOutHour = tPicker.getHour();
        CheckOutMinute = tPicker.getMinute();


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

        tPicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                CheckInHour = hourOfDay;
                CheckInMinute = minute;
            }
        });

        ChInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChInT.setText(Year + "년/" + Month + "월/" + Day + "일/" + CheckInHour + "시:" + CheckInMinute + "분");
                ChOutBtn.setEnabled(true);
                ChInBtn.setEnabled(false);
            }
        }); // 체크인 버틀 눌렀을때

        tPicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                CheckOutHour = hourOfDay;
                CheckOutMinute = minute;
            }
        });

        ChOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChOutT.setText(Year + "년/" + Month + "월/" + Day + "일" + CheckOutHour + "시:" + CheckOutMinute + "분");
                ChOutBtn.setEnabled(false);
            }
        }); // 체크아웃 버틀 눌렀을때
    }
}