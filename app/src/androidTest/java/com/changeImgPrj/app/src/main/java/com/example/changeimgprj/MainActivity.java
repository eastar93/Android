package com.example.changeimgprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1, tv2;
    CheckBox cb1;
    RadioGroup rg1;
    RadioButton catBtn, dogBtn, desertfoxBtn, squirrelBtn;
    Button SelComBtn;
    ImageView catImg, dogImg, desertfoxImg, squirrelImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView)findViewById(R.id.AppearApp);
        tv2 = (TextView)findViewById(R.id.ViewAnimal);
        cb1 = (CheckBox)findViewById(R.id.IfCheckV);
        rg1 = (RadioGroup)findViewById(R.id.Animals);
        catBtn = (RadioButton)findViewById(R.id.catBtn);
        dogBtn = (RadioButton)findViewById(R.id.dogBtn);
        desertfoxBtn = (RadioButton)findViewById(R.id.desertfoxBtn);
        squirrelBtn = (RadioButton)findViewById(R.id.squirrelBtn);
        SelComBtn = (Button)findViewById(R.id.SelComBtn);
        catImg = (ImageView)findViewById(R.id.catImg);
        dogImg = (ImageView)findViewById(R.id.dogImg);
        desertfoxImg = (ImageView)findViewById(R.id.desertfoxImg);
        squirrelImg = (ImageView)findViewById(R.id.squirrelImg);

        // 체크박스 클릭을 감지하도록 하려면 setOnCheckedChangeListener를 사용하고
        // 내부에는 new C까지 적고 자동완성을 시키면 쉽게 처리할 수 있습니다.
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // true, false여부를 체크해야함
                Log.d("isChaci", isChecked + "");
                // 클릭해서 true면 어플이 보이게, false면 안보이게 하기 위해
                // if~else분기를 작성해주세요.
                if(isChecked) {
                    // ImageView를 제외한 창부품을 보이도록 전환
                    // android:text=""의 기입내용을 바꿀때 setText()를 썼습니다.
                    // android:visibility를 바꿀때는 setVisibility()를 씁니다.
                    tv2.setVisibility(View.VISIBLE);
                    rg1.setVisibility(View.VISIBLE);
                    catBtn.setVisibility(View.VISIBLE);
                    dogBtn.setVisibility(View.VISIBLE);
                    desertfoxBtn.setVisibility(View.VISIBLE);
                    squirrelBtn.setVisibility(View.VISIBLE);
                    SelComBtn.setVisibility(View.VISIBLE);
                } else {
                    // 창부품이 보이지 않도록 전환
                    tv2.setVisibility(View.INVISIBLE);
                    rg1.setVisibility(View.INVISIBLE);
                    catBtn.setVisibility(View.INVISIBLE);
                    dogBtn.setVisibility(View.INVISIBLE);
                    desertfoxBtn.setVisibility(View.INVISIBLE);
                    squirrelBtn.setVisibility(View.INVISIBLE);
                    SelComBtn.setVisibility(View.INVISIBLE);
                }
            }
        });

        // 어떤 동물의 사진을 보여줄지는, 위의 어플 요소와는 별개로
        // RadioButton에 뭐가 선택되었나만 가지고 판단해야하기 때문에
        // 따로 지정합니다.
        SelComBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 고양이를 찍었나 강아지를 찍었나 사막여우를 찍었나 다람쥐를 찍었나 확인
                // RadioGroup내부의 RadioButton을 감지할때는
                // RadioGroup변수 .getCheckedRadioButtonId()를 쓰면
                // 선택한 버튼의 ID값이 잡혀나옵니다.
                int checked = rg1.getCheckedRadioButtonId();
                Log.d("선택한 버튼은?", checked + "");

                if (checked == 2131230827) {
                    Log.d("안내", checked + "고양이 버튼을 클릭했습니다");
                    catImg.setVisibility(View.VISIBLE);
                    dogImg.setVisibility(View.INVISIBLE);
                    desertfoxImg.setVisibility(View.INVISIBLE);
                    squirrelImg.setVisibility(View.INVISIBLE);
                } else if (checked == 2131230885) {
                    Log.d("안내", checked + "강아지 버튼을 클릭했습니다");
                    catImg.setVisibility(View.INVISIBLE);
                    dogImg.setVisibility(View.VISIBLE);
                    desertfoxImg.setVisibility(View.INVISIBLE);
                    squirrelImg.setVisibility(View.INVISIBLE);
                } else if (checked == 2131230870) {
                    Log.d("안내", checked + "사막여우 버튼을 클릭했습니다");
                    catImg.setVisibility(View.INVISIBLE);
                    dogImg.setVisibility(View.INVISIBLE);
                    desertfoxImg.setVisibility(View.VISIBLE);
                    squirrelImg.setVisibility(View.INVISIBLE);
                } else if (checked == 2131231110) {
                    Log.d("안내", checked + "다람쥐 버튼을 클릭했습니다");
                    catImg.setVisibility(View.INVISIBLE);
                    dogImg.setVisibility(View.INVISIBLE);
                    desertfoxImg.setVisibility(View.INVISIBLE);
                    squirrelImg.setVisibility(View.VISIBLE);
                }
            }
        });


    }
}