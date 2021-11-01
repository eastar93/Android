package com.example.listviewprj1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView ListV1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListV1 = (ListView) findViewById(R.id.ListV1);

        // 리스트뷰에 적용할 목록
        final String[] trips = {"뉴욕", "파리", "독일", "네덜란드", "태국",
                                "싱가폴", "러시아", "인도", "일본", "하와이",
                                "덴마크", "캘리포니아", "영국", "체코", "우수아이아"};
        // 리스트뷰는 AdapterView를 상속해 만들어졌음
        // 생성시 스타일 출력될 .xml화면(this를 주면 자동으로 setContentView에서 설정한 파일로 잡힙니다.)
        // 스타일, 그리고 출력자료를 파라미터로 순서대로 넣습니다.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                                            android.R.layout.simple_list_item_1, trips);
        // ListV1에 adapter내용을 적용
        ListV1.setAdapter(adapter);

        // 위임식 클릭 이벤트 처리
        ListV1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("parent확인", parent + "");
                Log.d("view확인", view + "");
                Log.d("position확인", position + "");
                Log.d("id확인", id + "");

                // 인덱스번호를 이용해 클릭하면 Toast형태로 클릭한 도시명이 뜨도록 만들어주세요.
                Toast.makeText(getApplicationContext(),
                        trips[position] + "", Toast.LENGTH_SHORT).show();
            }
        });
    }
}