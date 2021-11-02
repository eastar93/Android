package org.ict.movieprj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;


import org.ict.movieprj.retrofit.MovieAdapter;
import org.ict.movieprj.retrofit.RetrofitClient;
import org.ict.movieprj.retrofit.RetrofitInterface;
import org.ict.movieprj.vo.Example;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    // 비동기 요청을 담당하는 Retrofit관련 변수들 선언
    private RetrofitClient retrofitClient;
    private RetrofitInterface retrofitInterface;

    // 리사이클러뷰 부품 선언
    RecyclerView recyclerView;
    // 리사이클러 어댑터 부품 선언
    RecyclerView.Adapter mAdapter;

    // 상수로 본인 key값을 저장합니다.
    final String KEY = "4a2860caa73529bf11194c5ef37d2dff";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 레트로핏 요소들도 모두 연결합니다.
        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();

        // 리사이클러뷰 요소를 먼저 연결합니다.
        recyclerView = (RecyclerView) findViewById(R.id.recyView);
        // 리사이클러뷰는 레이아웃 설정을 자바쪽에서 받아야 표현됩니다.
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                                                    getApplicationContext(),
                                                    LinearLayoutManager.VERTICAL,
                                                    false);
        recyclerView.setLayoutManager(layoutManager);

        // 화면이 켜졌을때 비동기 요청으로 데이터를 받아오고,
        // 받아온 데이터를 리사이클러 뷰 내부에 세팅하도록 처리
        retrofitInterface.getBoxOffice(KEY, "20211101")
                .enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        // 비동기 요청 성공시 처리할 내역
                        // 비동기 데이터 저장
                        Example result = response.body();
                        // result 내부의 영화정보를 얻어서 MovieAdapter 생성자에 전달
                        mAdapter = new MovieAdapter(result
                                                .getBoxOfficeResult()
                                                .getDailyBoxOfficeList());
                        // 리사이클러 뷰에 MovieAdapter를 전달해서
                        // 카드뷰 양식으로 반복하도록 처리
                        recyclerView.setAdapter(mAdapter);
                    }

                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {
                        // 비동기 요청 실패시 처리할 내역
                        Log.d("요청실패", "요청실패했습니다.");
                    }
                });


    }
}














