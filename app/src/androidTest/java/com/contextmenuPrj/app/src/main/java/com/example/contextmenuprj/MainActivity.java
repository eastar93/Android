package com.example.contextmenuprj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    // 창 부품(리니어 레이아웃, 버튼 2개)
    LinearLayout BackgroundLi;
    Button ChangeBC, ChangeSB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BackgroundLi = (LinearLayout) findViewById(R.id.BgL);
        ChangeBC = (Button) findViewById(R.id.ChangeBC);
        ChangeSB = (Button) findViewById(R.id.ChangeSB);
        // ChangeBC, ChangeSB를 클릭했을때 컨텍스트 메뉴가 뜨도록 연결
        registerForContextMenu(ChangeBC);
        registerForContextMenu(ChangeSB);
    }

    // 각각 버튼을 클릭했을때 menu1, menu2가 조건에 맞게 표출되도록 설정
    // onCreateContextMenu를 Override를 통해 구현합니다.
    // 상단 Code -> Override Methods 들어가서 위 메서드를 구현해주세요.

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater mInflater = getMenuInflater();
        Log.d("태그", v + "");

        // v는 아까 추가한 registerForContextMenu에 등록된 요소입니다
        // 롱클릭이므로 길게 눌러야 나옵니다.
        if(v == ChangeBC) {
            // ChangeBC에는 menu1.xml을 연결
            mInflater.inflate(R.menu.menu1, menu);
        }
        if(v == ChangeSB) {
            mInflater.inflate(R.menu.menu2, menu);
        }
    }

    // menu1, menu2 내부의 옵션을 클릭했을때 실행할 내용들을
    // onContextItemSeleted를 Override를 통해 구현합니다.

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        super.onContextItemSelected(item);
        Log.d("선택한 아이템", item.getItemId() + "");
        if(item.getItemId() == 2131230729) {
            BackgroundLi.setBackgroundColor(Color.RED);
        }
        if(item.getItemId() == 2131230730) {
            BackgroundLi.setBackgroundColor(Color.YELLOW);
        }
        if(item.getItemId() == 2131230727) {
            BackgroundLi.setBackgroundColor(Color.GREEN);
        }
        if(item.getItemId() == 2131230726) {
            BackgroundLi.setBackgroundColor(Color.BLUE);
        }
        if(item.getItemId() == 2131230728) {
            BackgroundLi.setBackgroundColor(Color.MAGENTA);
        }
        if(item.getItemId() == 2131231062) {
            ChangeBC.setRotation(30);
            ChangeSB.setRotation(30);
        }
        if(item.getItemId() == 2131231061) {
            ChangeBC.setRotation(-30);
            ChangeSB.setRotation(-30);
        }
        if(item.getItemId() == 2131231064) {
            ChangeBC.setRotation(45);
            ChangeSB.setRotation(45);
        }
        if(item.getItemId() == 2131231063) {
            ChangeBC.setRotation(-45);
            ChangeSB.setRotation(-45);
        }
        if(item.getItemId() == 2131231066) {
            ChangeBC.setRotation(60);
            ChangeSB.setRotation(60);
        }
        if(item.getItemId() == 2131231065) {
            ChangeBC.setRotation(-60);
            ChangeSB.setRotation(-60);
        }
        if(item.getItemId() == 2131231068) {
            ChangeBC.setRotation(90);
            ChangeSB.setRotation(90);
        }
        if(item.getItemId() == 2131231067) {
            ChangeBC.setRotation(-90);
            ChangeSB.setRotation(-90);
        }
        if(item.getItemId() == 2131230741) {
            ChangeBC.setScaleX(2);
            ChangeBC.setScaleY(2);
            ChangeSB.setScaleX(2);
            ChangeSB.setScaleY(2);
        }
        if(item.getItemId() == 2131230735) {
            ChangeBC.setRotation(0);
            ChangeSB.setRotation(0);
            ChangeBC.setScaleX(1);
            ChangeBC.setScaleY(1);
            ChangeSB.setScaleX(1);
            ChangeSB.setScaleY(1);
        }


        return true;

    }
}