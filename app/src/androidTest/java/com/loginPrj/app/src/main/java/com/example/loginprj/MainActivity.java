package com.example.loginprj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText ID, PW;
    Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ID = (EditText) findViewById(R.id.InsertID);
        PW = (EditText) findViewById(R.id.InsertPW);
        Login = (Button) findViewById(R.id.Login);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> idList = new ArrayList<>();
                idList.add("android");
                idList.add("spring");
                idList.add("java");
                idList.add("SDK");
                idList.add("eastar93");
                String id = ID.getText().toString();
                String pw = PW.getText().toString();

                if(idList.contains(id) && pw.equals("android")) {
                    Intent intent = new Intent(getApplicationContext(), LoginSuccessActivity.class);

                    intent.putExtra("id", id);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getApplicationContext(), LoginFailActivity.class);

                    startActivity(intent);
                }
            }
        });
    }
}