package com.khs.ex_0816;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HandlerActivity extends AppCompatActivity {

    TextView txt_count;
    Button btn_start, btn_stop;
    int n = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        txt_count = findViewById(R.id.txt_count);
        btn_start = findViewById(R.id.btn_start);
        btn_stop = findViewById(R.id.btn_stop);

        btn_start.setOnClickListener(click);
        btn_stop.setOnClickListener(click);
    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()){
                case R.id.btn_start:
                    //핸들러(의 handleMessage()메서드)호출
                    handler.sendEmptyMessage(0);

                    //stop버튼 활성화
                    btn_stop.setEnabled(true);

                    //start버튼 비활성화
                    btn_start.setEnabled(false);

                    break;

                case R.id.btn_stop:
                    //핸들러 정지
                    handler.removeMessages(0);
                    //stop버튼 활성화
                    btn_stop.setEnabled(false);

                    //start버튼 비활성화
                    btn_start.setEnabled(true);
                    break;

            }//switch

        }
    };

    //핸들러 : 액티비티의 순환주기와는 별개로 독립적인 작업을 반복할 수 있도록 하는
    //       백그라운드의 실행 영역
    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            //handlerMessage 영역에서 작성된 코드는
            //액티비티와는 상관 없이 백그라운드에서 실행된다.
            handler.sendEmptyMessageDelayed(0, 1000);//1초 대기(1000)

            ++n;
            txt_count.setText("" + n);//setText메서드에는 정수값만 입력하면 오류가 난다
        }
    };

}