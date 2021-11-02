package com.example.movieprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.movieprj.retrofit.RetrofitClient;
import com.example.movieprj.retrofit.RetrofitInterface;
import com.example.movieprj.vo.Example;

import org.ict.movieprj.R;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    // 비동기 요청을 담당하는 Retrofit관련 변수들 선언
    private RetrofitClient retrofitClient;
    private RetrofitInterface retrofitInterface;

    // 비동기 요청 이벤트를 발동시킬 버튼 선언
    Button asyncBtn;

    // 상수로 본인 key값을 저장합니다.
    final String KEY = "d4b5d4f06341660ffa10ff2f89722250";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 레트로핏 요소들을 모두 연결합니다.
        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();

        // 버튼 클릭시 비동기 요청 넣기
        asyncBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrofitInterface.getBoxOffice(KEY, "20211101")
                        // 요청에 따른 성공/실패 시나리오별 코드를 작성합니다.
                        .enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        // 성공했을때 실행할 메서드
                        Example result = response.body();
                        Log.d("받아온 데이터 체크", result.getBoxOfficeResult().getDailyBoxOfficeList() + "");
                    }

                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {
                        // 실패했을때 실행할 메서드
                        Log.d("실패했습니다", "실패함");
                    }
                });
            }
        });
    }
}