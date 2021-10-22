package com.khs.ex_0812_review;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Random extends AppCompatActivity {
    TextView txt_result;
    Button btn1, btn2, btn3, btn4, btn_restart;
    int n; //난수 발생용 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        txt_result = findViewById(R.id.txt_result);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn_restart = findViewById(R.id.btn_restart);

        setRandom();

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

    //난수를 발생시키는 메서드
    public void setRandom(){
        n = new java.util.Random().nextInt(4)+1;
    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String str = ((Button)view).getText().toString();
            int res = Integer.parseInt(str);

            if(res == n){
                txt_result.setText("당첨");
            }else{
                txt_result.setText("안당첨");
            }
        }//onClick
    };
}