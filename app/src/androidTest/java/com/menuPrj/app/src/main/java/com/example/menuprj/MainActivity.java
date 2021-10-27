package com.example.menuprj;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    // 창 부품 선언
    // 리니어 레이아웃 1개, 버튼 1개
    LinearLayout OutLiLayout;
    Button NBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 창부품 연결
        OutLiLayout = (LinearLayout) findViewById(R.id.outLayout);
        NBtn = (Button) findViewById(R.id.NormalBtn);
        
        setTitle("화면 상단 이름 바꾸기");
    }

    // 외부 xml파일 추가로 등록하기
    // 커서를 onCreate 바깥에 둔 사음 상단 code -> Override Methodes를 선택하고,
    // onCreatOptionsMenu를 선택해주세요

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        // 메뉴  추가를 위해 inflater를 활용
        MenuInflater mInflater = getMenuInflater();
        // 기존 레이아웃에 메뉴 삽입
        //.inflate(리소스 폴더 내 xml파일 지정, menu);
        mInflater.inflate(R.menu.menu1, menu);

        return true;
    }

    // 옵션 요소가 선택되었을때 실행할 코드 추가
    // code -> Override Methods를 선택하고
    // onOptionsItemSelected()를 자동완성 시킨 후 imte.getItemId() 디버깅을 먼저 해보세요.

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        Log.d("선택한 아이템", item.getItemId() + "");
        if(item.getItemId() == 2131230811) {
            OutLiLayout.setBackgroundColor(Color.RED);
        }
        if(item.getItemId() == 2131230812) {
            OutLiLayout.setBackgroundColor(Color.YELLOW);
        }
        if(item.getItemId() == 2131230809) {
            OutLiLayout.setBackgroundColor(Color.GREEN);
        }
        if(item.getItemId() == 2131230808) {
            OutLiLayout.setBackgroundColor(Color.BLUE);
        }
        if(item.getItemId() == 2131230810) {
            OutLiLayout.setBackgroundColor(Color.MAGENTA);
        }

        return true;
    }
}
