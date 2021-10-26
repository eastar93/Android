package com.example.widgetprj7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

// 안 적어도 작동하지만 탭호스트는 업데이트가 중지된 위젯이라
// 경고가 콘솔에 뜰 수 있어서 아래 어노테이션으로 방지
@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 탭 호스트 변수에 XML에서 생성한 탭호스트를 가져옵니다.
        // xml파일에 설정한 TabHost의 id가 tabhost인 경우 가져와짐
        TabHost tabhost = getTabHost();

        // 위쪽 탭 메뉴에 들어갈 메뉴명을 적어줍니다
        // newTabSpec에는 탭의 호출명칭, setIndicator에는 화면에 보여줄 명칭을 적습니다.
        TabHost.TabSpec Tsfk = tabhost.newTabSpec("KOREAN").setIndicator("한식");
        // 1번탭은 한식
        Tsfk.setContent(R.id.t1);
        // 탭호스트에 위에서 추가한 메뉴바 하나를 추가
        tabhost.addTab(Tsfk);

        // newTabSpec에는 탭의 호출명칭, setIndicator에는 화면에 보여줄 명칭을 적습니다.
        TabHost.TabSpec Tsfc = tabhost.newTabSpec("CHINESE").setIndicator("중식");
        // 1번탭은 한식
        Tsfc.setContent(R.id.t2);
        // 탭호스트에 위에서 추가한 메뉴바 하나를 추가
        tabhost.addTab(Tsfc);

        // newTabSpec에는 탭의 호출명칭, setIndicator에는 화면에 보여줄 명칭을 적습니다.
        TabHost.TabSpec Tsfj = tabhost.newTabSpec("JAPANESE").setIndicator("일식");
        // 1번탭은 한식
        Tsfj.setContent(R.id.t3);
        // 탭호스트에 위에서 추가한 메뉴바 하나를 추가
        tabhost.addTab(Tsfj);
    }
}