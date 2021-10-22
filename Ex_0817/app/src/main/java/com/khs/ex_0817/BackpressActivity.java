package com.khs.ex_0817;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class BackpressActivity extends AppCompatActivity {

    int num = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backpress);
    }//onCreate()

    @Override
    public void onBackPressed() {
        //뒤로가기 버튼을 감지하면 2초를 카운트 하는 핸들러 호출
        if( num != 2 ){
            finish();
        }else{
            Toast.makeText(BackpressActivity.this, "한 번 더 누르면 종료", Toast.LENGTH_SHORT).show();
            handler.sendEmptyMessage(0);
        }



    }

    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {

            //1초 간격으로 핸들러를 반복적으로 수행
            handler.sendEmptyMessageDelayed(0, 1000);
            
            if( num >= 0 ){
                num--;
            }else{
                num = 2;
                handler.removeMessages(0);
            }

        }
    };

}