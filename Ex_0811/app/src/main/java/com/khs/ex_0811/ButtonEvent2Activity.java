package com.khs.ex_0811;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ButtonEvent2Activity extends AppCompatActivity {
    Button btn1, btn2, btn3;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_event2);

        btn1 = findViewById(R.id.btn1);//R.java에는 다른 레이아웃에서 생성한 id도 모두 저장되어 있다. 하지만 현재 레이아웃에서 생성하지 않은 id를 불러오게 되면 오류 발생
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        txt = findViewById(R.id.txt);

        btn1.setOnClickListener(click);
        btn2.setOnClickListener(click);
        btn3.setOnClickListener(click);

    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText( ButtonEvent2Activity.this, "버튼누름", Toast.LENGTH_SHORT ).show();

            String str = "";

            switch ( view.getId() ){

                case R.id.btn1:
                    str = "나는 버튼1";
                    break;

                case R.id.btn2:
                    str = "나는 버튼2";
                    break;

                case R.id.btn3:
                    str = "나는 버튼3";
                    break;

            }//switch
            txt.setText(str);
        }
    };

}