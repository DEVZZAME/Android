package com.khs.ex_0816;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HandlerWhatActivity extends AppCompatActivity {

    Button btn0, btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_what);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);

        btn0.setOnClickListener( click );
        btn1.setOnClickListener( click );

    }//onClick()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()){

                case R.id.btn0:
                    handler.sendEmptyMessage(0);
                    break;

                case R.id.btn1:
                    handler.sendEmptyMessage(1);
                    break;


            }//switch


        }
    };

    Handler handler = new Handler(){

        @Override
        public void handleMessage(@NonNull Message msg) {

            if(msg.what == 0){

                Toast.makeText(HandlerWhatActivity.this, "what 0", Toast.LENGTH_SHORT).show();

            }else if(msg.what == 1){

                Toast.makeText(HandlerWhatActivity.this, "what 1", Toast.LENGTH_SHORT).show();

            }

        }
    };
}