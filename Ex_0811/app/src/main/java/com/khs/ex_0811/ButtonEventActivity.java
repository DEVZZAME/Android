package com.khs.ex_0811;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ButtonEventActivity extends AppCompatActivity {

    Button red, green, blue;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_event);

        //이벤트 처리에 사용될 버튼들과 텍스트뷰를 검색
        red = findViewById(R.id.btn_red);
        green = findViewById(R.id.btn_green);
        blue = findViewById(R.id.btn_blue);
        txt = findViewById(R.id.txt);

        //버튼 이벤트 감지자 등록
       red.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               //클릭이벤트 발생시 처리하고자 하는 코드
               txt.setBackgroundColor(Color.parseColor("#ff0000"));
               txt.setText("빨강");
               Log.i("MY", "--onClickRed");
           }
       });
       green.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               txt.setBackgroundColor(Color.parseColor("#00ff00"));
               txt.setText("초록");
               Log.i("MY", "--onClickGreen");
           }
       });
       blue.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               txt.setBackgroundColor(Color.parseColor("#0000ff"));
               txt.setText("파랑");
               Log.i("MY", "--onClickBlue");
           }
       });
       txt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               txt.setBackgroundColor(Color.parseColor("#000000"));
               txt.setText("TEST");
               Log.i("MY", "--onClickTXT");
           }
       });
    }//onCreate()

}