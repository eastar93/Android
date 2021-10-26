package com.example.pickerprj2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Date;

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
                Log.d("날짜",
                        year + "년/" + (monthOfYear + 1) + "월/" + dayOfMonth + "일");
            }
        });

        tPicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

            }
        });


        ChInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                long now = System.currentTimeMillis();
                Date date = new Date(now);

                dPicker.updateDate((date.getYear()+1900),
                                    (date.getMonth()),
                                    date.getDate());
                tPicker.setHour(date.getHours());
                tPicker.setMinute(date.getMinutes());

                int year = dPicker.getYear();
                int month = (dPicker.getMonth() + 1);
                int day = dPicker.getDayOfMonth();
                int hour = tPicker.getHour();
                int min = tPicker.getMinute();

                ChInT.setText(year + "년/" + month + "월/" + day + "일/" + hour + "시:" + min + "분");
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

                long now = System.currentTimeMillis();
                Date date = new Date(now);

                dPicker.updateDate((date.getYear()+1900),
                        (date.getMonth()),
                        date.getDate());
                tPicker.setHour(date.getHours());
                tPicker.setMinute(date.getMinutes());

                int year = dPicker.getYear();
                int month = (dPicker.getMonth() + 1);
                int day = dPicker.getDayOfMonth();
                int hour = tPicker.getHour();
                int min = tPicker.getMinute();

                ChOutT.setText(year + "년/" + month + "월/" + day + "일/" + hour + "시:" + min + "분");
                ChOutBtn.setEnabled(false);
            }
        }); // 체크아웃 버틀 눌렀을때
    }
}