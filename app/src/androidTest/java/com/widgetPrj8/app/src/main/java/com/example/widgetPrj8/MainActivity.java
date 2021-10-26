package com.example.widgetPrj8;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

// 액션바는 java코드로만 구현하기때문에 activity_main.xml파일이 필요없습니다.
// MainActivity에서는 탭만 구현하고
//CustomTabFragment 클래스를 만들어 거기서 탭별 화면을 구현합니다.
// MainActivity는 AppCompatActivity를 상속하고
// ActionBar를 구현합니다

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {

    // 탭 갯수만큼 변수 선언(3개)
    ActionBar.Tab tabKOREAN, tabJAPANESE, tabCHINESE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // activity_main을 안쓰므로 필요없음
        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tabKOREAN = bar.newTab();
        tabKOREAN.setText("한식");
        tabKOREAN.setTabListener(this);
        bar.addTab(tabKOREAN);

        tabCHINESE = bar.newTab();
        tabCHINESE.setText("중식");
        tabCHINESE.setTabListener(this);
        bar.addTab(tabCHINESE);

        tabJAPANESE = bar.newTab();
        tabJAPANESE.setText("일식");
        tabJAPANESE.setTabListener(this);
        bar.addTab(tabJAPANESE);
    }

    // 탭이 선택될 때마다 바뀌는 내용을 처리해야 하므로
    // onTabSelected를 재정의해줍니다.
    // CustomFragment 3개를 선언합니다.
    CustomTabFragment customFrags[] = new CustomTabFragment[3];

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        // 아까 만든 커스텀 프래그먼트를 먼저 선언합니다.
        CustomTabFragment cFrag = null;

        // 탭 선택이 된 적이 없다면, 새로 탭을 생성
        if(customFrags[tab.getPosition()] == null) {
            cFrag = new CustomTabFragment();
            Bundle data = new Bundle();
            data.putString("tabName", tab.getText().toString());
            cFrag.setArguments(data);
            customFrags[tab.getPosition()] = cFrag;
        } else {
            // 선택이 된 적이 있다면 선택된 탭으로 교체
            cFrag = customFrags[tab.getPosition()];
        }
        // 화면 교체
        ft.replace(android.R.id.content, cFrag);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

        CustomTabFragment cFrag = null;

        // 탭 선택이 된 적이 없다면, 새로 탭을 생성
        if(customFrags[tab.getPosition()] == null) {
            cFrag = new CustomTabFragment();
            Bundle data = new Bundle();
            data.putString("tabName", tab.getText().toString());
            cFrag.setArguments(data);
            customFrags[tab.getPosition()] = cFrag;
        } else {
            // 선택이 된 적이 있다면 선택된 탭으로 교체
            cFrag = customFrags[tab.getPosition()];
        }
        // 화면 교체
        ft.replace(android.R.id.content, cFrag);
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

        CustomTabFragment cFrag = null;

        // 탭 선택이 된 적이 없다면, 새로 탭을 생성
        if(customFrags[tab.getPosition()] == null) {
            cFrag = new CustomTabFragment();
            Bundle data = new Bundle();
            data.putString("tabName", tab.getText().toString());
            cFrag.setArguments(data);
            customFrags[tab.getPosition()] = cFrag;
        } else {
            // 선택이 된 적이 있다면 선택된 탭으로 교체
            cFrag = customFrags[tab.getPosition()];
        }
        // 화면 교체
        ft.replace(android.R.id.content, cFrag);
    }
}