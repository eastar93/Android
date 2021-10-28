package com.example.dialogprj2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 창부품을 추가해주세요
    TextView userNameTv, userEmailTv;
    Button OpenDial;
    EditText userName, userEmail;
    View modal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameTv = (TextView) findViewById(R.id.userNameTv);
        userEmailTv = (TextView) findViewById(R.id.userEmailTv);
        OpenDial = (Button) findViewById(R.id.OpenDial);

        OpenDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 클릭하면 모달창같이 userinfo.xml이 열려야 합니다.
                // 다이얼로그 생성, 설정 후 .show()로 보여주는데
                // 단, dialog의 형태를 userinfo.xml에 정의해뒀으므로
                // xml파일을 화면으로 가져오는 inflate()기능을 활용합니다.
                // View 타입을 이용해야 추가 커스텀 창을 정의할 수 있습니다.
                modal = View.inflate(MainActivity.this, R.layout.userinfo, null);

                // AlertDialog객체 생성 후 View를 다어얼로그로 변환
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setView(modal);
                // 창이 떴으니 확인 취소 버튼도 만들어주세요.
                // 1. positive버튼 클릭시 이벤트 발동
                // 2. EditText 2개를 MainActivity에 연결
                // 3. EditText에 있던 요소를 .getText()로 가져와서
                // 4. TextView에 찍히게 만들어주세요.
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // inflate로 만든 커스텀 창의 위젯은
                        // modal명의로 연결해야 합니다.
                        userName = (EditText) modal.findViewById(R.id.userName);
                        userEmail = (EditText) modal.findViewById(R.id.userEmail);

                        userNameTv.setText(userName.getText().toString());
                        userEmailTv.setText(userEmail.getText().toString());
                    }
                });
                dlg.setNegativeButton("취소", null);

                dlg.show();
            }
        });
    }
}