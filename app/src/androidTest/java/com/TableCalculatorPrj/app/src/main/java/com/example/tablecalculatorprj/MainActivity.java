package com.example.tablecalculatorprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 창 부품 선언하기
    EditText enum1, enum2;
    Button[] numBtns = new Button[10];
    Integer[] numBtnIDs = {R.id.Num0, R.id.Num1, R.id.Num2, R.id.Num3, R.id.Num4, R.id.Num5, R.id.Num6, R.id.Num7, R.id.Num8, R.id.Num9};
    Button SumBtn, SubBtn, MulBtn, DivBtn, ClearBtn;
    TextView ResultV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 10개 버튼이 0~까지 숫자로 배정되어있으므로 반복문 배정
        for(int i=0; i<10; i++) {
            numBtns[i] = (Button) findViewById((numBtnIDs[i]));
        }

        enum1 = (EditText) findViewById(R.id.Enum1);
        enum2 = (EditText) findViewById(R.id.Enum2);
        SumBtn = (Button) findViewById(R.id.SumBtn);
        SubBtn = (Button) findViewById(R.id.SubBtn);
        MulBtn = (Button) findViewById(R.id.MulBtn);
        DivBtn = (Button) findViewById(R.id.DivBtn);
        ClearBtn = (Button) findViewById(R.id.ClearBtn);
        ResultV = (TextView) findViewById(R.id.Result);

        // 부품 배열에 대해서는 이벤트까지 반복문으로 겁니다.
        for(int i = 0; i < numBtns.length; i++) {
            final int index; // *주의! 상수를 하나 선언해줘야 이벤트가 정상적으로 걸림
            index = i;

            numBtns[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 포커스된 EditText에 숫자 입력하기
                    if(enum1.isFocused()) {
                        // 0을 첫글자로 입력하는것을 방지하는 로직 추가 예정
                        if((enum1.getText() + "").equals("0")) {
                            enum1.setText(numBtns[index].getText());
                        } else  {
                            // enum1에 커서가 깜빡이는(즉 선택된)경우
                            enum1.setText(enum1.getText() + "" + numBtns[index].getText());
                        }
                    } else if(enum2.isFocused()) {
                        // 0을 첫글자로 입력하는것을 방지하는 로직 추가 예정
                        if((enum2.getText() + "").equals("0")) {
                            enum2.setText(numBtns[index].getText());
                        } else {
                            // enum2에 커서가 깜빡이는(즉 선택된)경우
                            enum2.setText(enum2.getText() + "" + numBtns[index].getText());
                        }
                    }
                }
            });

            SumBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int Num1 = Integer.parseInt(enum1.getText() + "");
                    int Num2 = Integer.parseInt(enum2.getText() + "");
                    int resultNum = Num1 + Num2;
                    ResultV.setText(resultNum + "");
                }
            });

            SubBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int Num1 = Integer.parseInt(enum1.getText() + "");
                    int Num2 = Integer.parseInt(enum2.getText() + "");
                    int resultNum = Num1 - Num2;
                    ResultV.setText(resultNum + "");
                }
            });

            MulBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int Num1 = Integer.parseInt(enum1.getText() + "");
                    int Num2 = Integer.parseInt(enum2.getText() + "");
                    int resultNum = Num1 * Num2;
                    ResultV.setText(resultNum + "");
                }
            });

            DivBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int Num1 = Integer.parseInt(enum1.getText() + "");
                    int Num2 = Integer.parseInt(enum2.getText() + "");
                    int resultNum = Num1 / Num2;
                    ResultV.setText(resultNum + "");
                }
            });

            ClearBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    enum1.setText("");
                    enum2.setText("");
                    ResultV.setText("");
                }
            });
        }
    }
}