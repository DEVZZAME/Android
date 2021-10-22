package com.khs.ex_0817;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SharedPreferencesActivity extends AppCompatActivity {
    Button btn_top_p, btn_top_m, btn_bottom_p, btn_bottom_m, btn_reset;
    TextView txt_top, txt_bottom;

    int numTop, numBottom;

    //프로그래밍을 하다보면 간혹 아주 간단한 정보를 저장해야 할 일이 있다.
    //일반적으로 데이터의 저장은 DB를 사용하지만, DB를 사용하기에는 너무 작은 데이터여서
    //오히려 낭비다 라고 생각될 때 사용해 볼 수 있는 객체
    
    //SharedPreferences를 통해 저장된 값은 내부적으로 파일형식으로 기록되기 때문에
    //애플리케이션이 종료되거나 휴대폰이 재부팅돼도 파일형태로 기록된 값은 계속 남아있는 형태가 된다
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        pref = getSharedPreferences("SHARE", MODE_PRIVATE);

        btn_top_p = findViewById(R.id.btn_top_plus);
        btn_top_m = findViewById(R.id.btn_top_minus);

        btn_bottom_p = findViewById(R.id.btn_bottom_plus);
        btn_bottom_m = findViewById(R.id.btn_bottom_minus);

        btn_reset = findViewById(R.id.btn_reset);

        txt_top = findViewById(R.id.txt_top);
        txt_bottom = findViewById(R.id.txt_bottom);

        //저장된 데이터가 있다면 로드
        numTop = pref.getInt("s1", 0);
        numBottom = pref.getInt("s2", 0);

        txt_top.setText("" + numTop);
        txt_bottom.setText("" + numBottom);

        btn_top_p.setOnClickListener( topClick );
        btn_top_m.setOnClickListener( topClick );

        btn_bottom_p.setOnClickListener( botClick);
        btn_bottom_m.setOnClickListener( botClick);
        btn_reset.setOnClickListener( botClick);


    }//onCreate()

    View.OnClickListener topClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if( view == btn_top_p ){

                txt_top.setText("" + ++numTop);

            }else if( view == btn_top_m){

                txt_top.setText("" + --numTop);

            }//if

        }
    };


    View.OnClickListener botClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()){

                case R.id.btn_bottom_plus:
                    txt_bottom.setText("" + ++numBottom);
                    break;
                case R.id.btn_bottom_minus:
                    txt_bottom.setText("" + --numBottom);
                    break;
                case R.id.btn_reset:
                    numTop = 0;
                    numBottom = 0;

                    txt_top.setText("" + numTop);
                    txt_bottom.setText("" + numBottom);
                    break;

            }//switch

        }
    };

    @Override
    protected void onPause() {
        super.onPause();

        //애플리케이션이 일시정지 상태가 됐을 때
        //numTop, numBottom 값을 pref에 저장
        SharedPreferences.Editor edit = pref.edit();
        edit.putInt("s1", numTop);
        edit.putInt("s2", numBottom);
        edit.commit();//put으로 지정한 값을 물리적으로 파일형태로 저장

    }
}