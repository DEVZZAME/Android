package com.khs.ex_0823;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class SwipeRefreshActivity extends AppCompatActivity {

    SwipeRefreshLayout swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh);

        swipe = findViewById(R.id.swipe);

        //디스크 배경색 변경
        swipe.setProgressBackgroundColorSchemeColor( Color.parseColor("#aaaaff") );

        swipe.setSize(SwipeRefreshLayout.LARGE);//디스크 사이즈 DEFAULT / LARGE

        //당겨질 최대 좌표값 설정
        //swipe.setProgressViewEndTarget(true, 400);

        //당겼을 때 디스크의 시작 위치 및 끝 위치 설정
        swipe.setProgressViewOffset(false, 200, 400);

        //디스크 안에 그 똥그란거 막 돌아가는거.. 그거 왜 그 똥글뱅이... 그거
        //원래 시커먼거.. 그거 색깔 바꾸는 속성
        swipe.setColorSchemeResources(R.color.c1, R.color.c2, R.color.c3, R.color.c4);

        //이벤트 감지자 등록
        swipe.setOnRefreshListener(r1);

    }//onCreate()

    SwipeRefreshLayout.OnRefreshListener r1 = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            //당겼다가 손을 뗐을 때(로딩 시작) 호출되는 메서드
            //Toast.makeText(SwipeRefreshActivity.this, "로딩시작", Toast.LENGTH_SHORT).show();
            handler.sendEmptyMessageDelayed(0, 3000);//3초 대기 후 핸들러 호출
        }
    };

    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            // 로딩이 끝났다고 가정하자!!
            //로딩이 완료되면 디스크를 제거
            swipe.setRefreshing(false);
        }
    };
}