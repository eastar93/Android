package com.example.widgetPrj8;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

// androidx.fragment.app.Fragment를 상속합니다
public class CustomTabFragment extends androidx.fragment.app.Fragment {
    // 탭 이름을 감지해 어떤 탭을 보여줘야 하는지 확인을 위한 변수
    String tabName;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 탭 이름 감지 관련 코드세팅
        Bundle data = getArguments();
        tabName = data.getString("tabName");
    }

    // 화면이 변경될 때마다 처리할 로직 작성
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // java코드에서 LinearLayout을 생성
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );

        // baseLayout은 탭 하단에 실제로 바뀔 화면
        LinearLayout baseLayout = new LinearLayout(super.getActivity());
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setLayoutParams(params);

        ImageView img = new ImageView(super.getActivity());

        if(tabName == "한식") {
            baseLayout.setBackgroundColor(Color.RED);
            img.setImageResource(R.drawable.ic_launcher_foreground);
        }
        if(tabName == "중식") {
            baseLayout.setBackgroundColor(Color.YELLOW);
            img.setImageResource(R.drawable.ic_launcher_foreground);
        }
        if(tabName == "일식") {
            baseLayout.setBackgroundColor(Color.BLUE);
            img.setImageResource(R.drawable.ic_launcher_foreground);
        }

        // 하단 코드를 응용해 한식, 중식, 일식 사진을 화면에 띄워주세요.
        // 만약에 그림을 넣고 싶다면
        // 위젯 생성
        /*
        ImageView img = new ImageView(super.getActivity());
        // 위젯에 필요한 경로 등을 지정해준 다음
        img.setImageResource(R.drawable.ic_launcher_foreground);
        // baseLayout의 내부 위젯으로 .addView()를 통해 등록하면 됩니다.
        baseLayout.addView(img);
        */
        return baseLayout;

    }
}
