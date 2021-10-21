package com.example.changeimgprj2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Switch As;
    TextView VA, AA;
    RadioGroup ARG;
    RadioButton CatBtn, DogBtn, DesertfoxBtn, SquirrelBtn;
    ImageView AniImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        As = (Switch)findViewById(R.id.ApperS);
        VA = (TextView)findViewById(R.id.ViewAnimal);
        ARG = (RadioGroup)findViewById(R.id.Animals);
        CatBtn = (RadioButton)findViewById(R.id.catBtn);
        DogBtn = (RadioButton)findViewById(R.id.dogBtn);
        DesertfoxBtn = (RadioButton)findViewById(R.id.desertfoxBtn);
        SquirrelBtn = (RadioButton)findViewById(R.id.squirrelBtn);
        AniImg = (ImageView)findViewById(R.id.AniImg);

        As.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("디버깅", isChecked + "");

                if(isChecked) {
                    ARG.setVisibility(View.VISIBLE);
                    VA.setVisibility(View.VISIBLE);
                    CatBtn.setVisibility(View.VISIBLE);
                    DogBtn.setVisibility(View.VISIBLE);
                    DesertfoxBtn.setVisibility(View.VISIBLE);
                    SquirrelBtn.setVisibility(View.VISIBLE);
                    AniImg.setVisibility(View.VISIBLE);
                } else {
                    ARG.setVisibility(View.INVISIBLE);
                    VA.setVisibility(View.INVISIBLE);
                    CatBtn.setVisibility(View.INVISIBLE);
                    DogBtn.setVisibility(View.INVISIBLE);
                    DesertfoxBtn.setVisibility(View.INVISIBLE);
                    SquirrelBtn.setVisibility(View.INVISIBLE);
                    AniImg.setVisibility(View.INVISIBLE);
                }
            }
        });

        // 1.CatBtn, DogBtn, DesertfoxBtn, SquirrelBtn에 onClick이벤트를 걸어서 처리
        // 2. ARG를 이용해서 CatBtn, DogBtn, DesertfoxBtn, SquirrelBtn 중 어떤게 클릭되었는지 감지해 처리
        CatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AniImg.setImageResource(R.drawable.cat);
            }
        });
        DogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AniImg.setImageResource(R.drawable.dog);
            }
        });
        DesertfoxBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AniImg.setImageResource(R.drawable.desertfox);
            }
        });
        SquirrelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AniImg.setImageResource(R.drawable.squirrel);
            }
        });
    }
}