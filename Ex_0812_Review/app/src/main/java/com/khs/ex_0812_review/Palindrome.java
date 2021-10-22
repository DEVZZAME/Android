package com.khs.ex_0812_review;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Palindrome extends AppCompatActivity {

    EditText et;
    Button btn;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palindrome);

        et = findViewById(R.id.et);
        btn = findViewById(R.id.btn);
        txt = findViewById(R.id.txt);

        btn.setOnClickListener(click);
    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String ori = et.getText().toString();
            String rev = "";

            for(int i = ori.length()-1; i >= 0; i--){
                rev += ori.charAt(i);
            }//for
            if(ori.equals(rev)){
                txt.setText("회문수임");
            }else{
                txt.setText("회문수아님");
            }//if

        }//onClick
    };
}