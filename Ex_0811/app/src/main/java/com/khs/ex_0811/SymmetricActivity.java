package com.khs.ex_0811;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SymmetricActivity extends AppCompatActivity {
    EditText et;
    Button btn;
    TextView txt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symmetric);

        et = findViewById(R.id.et);
        btn = findViewById(R.id.btn);
        txt = findViewById(R.id.txt);
        btn.setOnClickListener(click);
    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String t1 = et.getText().toString();
            String t2 = "";
            int len = t1.length();

            for(int i = len-1; i >= 0; i--){
                t2 = t2 + t1.charAt(i);
            }//for

            if(t1.equals(t2)){
                txt.setText("회문수가 맞습니다");
            }else{
                txt.setText("회문수가 아닙니다");
            }

        }//onClick

    };
}