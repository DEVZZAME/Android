package com.khs.ex_0810;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //onCreate() : 앱 실행시 액티비티에서 가장 먼저 호출되는 메서드
        Log.i("MY", "--onCreate()--");
    }//onCreate()

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MY", "--onStart()--");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MY", "--onResume()--");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MY", "--onStop()--");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MY", "--onPause()--");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MY", "--onRestart()--");
        //Toast가 파라미터로 요구하는 Context는 현재 액티비티의 정보를 담고 있는 화면 제어권자
        Toast.makeText(MainActivity.this, "저는 토스트에요", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MY", "--onDestroy()--");
    }
    
    //onCreate() : 앱이 처음 실행됐을 때 딱 한번 호출되는 메서드

    //현재 액티비티가 눈으로 직접 확인 가능한 상황일 때
    //onStart()
    //onResume()

    //현재 액티비티가 눈에 보이지 않는 상황(일시정지)
    //onPause()
    //onStop()

    //일시정지 상태에서 다시 앱으로 복귀했을 때
    //onRestart()
    //onStart()
    //onResume()

    //앱을 완전히 종료하면
    //onPause()
    //onStop()
    //onDestroy() : 앱이 완전히 종료될 때 딱 한번 호출되는 메서드
}

