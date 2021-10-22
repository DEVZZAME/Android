package com.khs.ex_0812;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Palindrome extends AppCompatActivity {
    EditText et;
    Button btn_start;
    TextView txt_result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palindrome);

        et = findViewById(R.id.et);
        btn_start = findViewById(R.id.btn_start);
        txt_result = findViewById(R.id.txt_result);

        //ok버튼에 이벤트 감지자 등록
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p1 = et.getText().toString();
                String p2 = "";
                
                int leng = p1.length();
                
                for(int i = leng-1; i>=0; i--){
                    p2 += p1.charAt(i);
                }//for
                if(p1.equals(p2)){
                    txt_result.setText("회문수가 맞습니다");
                }else{
                    txt_result.setText("회문수가 아닙니다");
                }//if
            }//onClick()
        });
    }//onCreate()
}