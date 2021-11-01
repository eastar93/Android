package org.ict.listviewprj2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 부품들 선언
    Button addBtn;
    ListView lv1;
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 부품 연결
        addBtn = (Button) findViewById(R.id.addBtn);
        lv1 = (ListView) findViewById(R.id.lv1);
        et1 = (EditText) findViewById(R.id.et1);

        // 리스트 생성
        // 리스트로 올 수 있는것은 배열([]), ArrayList등입니다.
        // 가변적으로 변동을 주기 위해서는 ArrayList가 옵니다.
        final ArrayList<String> trips = new ArrayList<String>();

        // 위의 목록을 토대로 자료가들어갈 Adapter 생성
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                                        android.R.layout.simple_list_item_1, trips);

        lv1.setAdapter(adapter);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // addBtn 클릭시, et1에 있던 요소를 ArrayList에 .add()로 넣습니다.
                trips.add(et1.getText().toString());
                // 어댑터에 추가된 리스트로 갱신 반영해주기.
                adapter.notifyDataSetChanged();
            }
        });

        // 삭제는 추가된 요소를 길게 클릭하면(Long click) 삭제되도록 처리
        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // 위쪽 파라미터들을 토대로 trips.remove()를 이용해
                // 길게 클릭한 요소가 삭제되게 완성해보세요.
                trips.remove(position);

                // 삭제된 리스트를 어댑터에 반영
                adapter.notifyDataSetChanged();

                // false로 두면 됨
                return false;
            }
        });

    }
}