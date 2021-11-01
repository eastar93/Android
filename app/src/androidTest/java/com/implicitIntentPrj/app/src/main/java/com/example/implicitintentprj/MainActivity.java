package com.example.implicitintentprj;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button CallBtn, WebBtn, GoogleBtn, SearchBtn, smsBtn, PhotoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CallBtn = (Button) findViewById(R.id.CallBtn);
        WebBtn = (Button) findViewById(R.id.WebBtn);
        GoogleBtn = (Button) findViewById(R.id.GoogleBtn);
        SearchBtn = (Button) findViewById(R.id.SearchBtn);
        smsBtn = (Button) findViewById(R.id.smsBtn);
        PhotoBtn = (Button) findViewById(R.id.PhotoBtn);

        CallBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:01088990785");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                // 보낸적 없는 전화번호가 같이 달려서 넘어갑니다.
                startActivity(intent);
            }
        });

        WebBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.naver.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        GoogleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.google.com/maps?rlz=1C1IBEF_koKR957KR957&sxsrf=AOaemvI3LXWYdL_1KYni2cymceJeURXo7A:1635736115464&q=%ED%95%9C%EA%B5%ADICT%EC%9D%B8%EC%9E%AC%EA%B0%9C%EB%B0%9C%EC%9B%90&biw=2560&bih=969&dpr=1&um=1&ie=UTF-8&sa=X&ved=2ahUKEwjvhYDyl_bzAhXGc3AKHdR1AG4Q_AUoA3oECAEQBQ");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        SearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "안드로이드");
                startActivity(intent);
            }
        });

        smsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body", "안녕하세요?");
                intent.setData(Uri.parse("smsto:" + Uri.encode("01088990785")));
                startActivity(intent);
            }
        });

        PhotoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });
    }
}