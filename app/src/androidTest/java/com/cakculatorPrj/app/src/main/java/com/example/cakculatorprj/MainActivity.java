package com.example.cakculatorprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText Num1, Num2;
    Button Sum, Sub, Mul, Div;
    TextView TextV, Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Num1 = (EditText)findViewById(R.id.EditT1);
       Num2 = (EditText)findViewById(R.id.EditT2);
       Sum = (Button)findViewById(R.id.SumBtn);
       Sub = (Button)findViewById(R.id.SubBtn);
       Mul = (Button)findViewById(R.id.MulBtn);
       Div = (Button)findViewById(R.id.DivBtn);
       Result = (TextView)findViewById(R.id.Result);

       Sum.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              int num1 = Integer.parseInt(Num1.getText().toString());
              int num2 = Integer.parseInt(Num2.getText().toString());
              int resultInt = num1 + num2;
              Result.setText(resultInt + "");
              Num1.setText("");
              Num2.setText("");
           }
       });

       Sub.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int num1 = Integer.parseInt(Num1.getText().toString());
               int num2 = Integer.parseInt(Num2.getText().toString());
               int resultInt = num1 - num2;
               // int를 String으로 바꾸는 가장 쉬운 방법은 그냥 빈 문자열을 더하는것.
               Result.setText(resultInt + "");
               Num1.setText("");
               Num2.setText("");
           }
       });

        Mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(Num1.getText().toString());
                int num2 = Integer.parseInt(Num2.getText().toString());
                int resultInt = num1 * num2;
                Result.setText(resultInt + "");
                Num1.setText("");
                Num2.setText("");
            }
        });

        Div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(Num1.getText().toString());
                int num2 = Integer.parseInt(Num2.getText().toString());
                int resultInt = num1 / num2;
                Result.setText(resultInt + "");
                Num1.setText("");
                Num2.setText("");
            }
        });

    }
}