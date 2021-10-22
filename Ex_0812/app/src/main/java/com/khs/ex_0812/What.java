package com.khs.ex_0812;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Random;

public class What extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn_restart;
    TextView txt_result;
    int n;//난수발생용 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn_restart = findViewById(R.id.btn_restart);
        txt_result = findViewById(R.id.txt_result);

        setRandom();//난수발생

        btn1.setOnClickListener( click );
        btn2.setOnClickListener( click );
        btn3.setOnClickListener( click );
        btn4.setOnClickListener( click );

        btn_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRandom();
                txt_result.setText("결과");
            }
        });



    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //view객체는 현재 이벤트를 발생시킨 버튼객체
            String str = ((Button)view).getText().toString();
            int res = Integer.parseInt(str);

            if(res == n){
                txt_result.setText("당첨");
            }else{
                txt_result.setText("안당첨");
            }
        }
    };

    //난수를 발생시키는 메서드
    public void setRandom(){
        n = new Random().nextInt(4)+1;
    }
    
}
