package com.khs.ex_0816;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class IntentMainActivity extends AppCompatActivity {

    Button btn_link, btn_call, btn_sms, btn_camera, btn_gallery, btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_main);

        btn_link = findViewById(R.id.btn_link);
        btn_call = findViewById(R.id.btn_call);
        btn_sms = findViewById(R.id.btn_sms);
        btn_camera = findViewById(R.id.btn_camera);
        btn_gallery = findViewById(R.id.btn_gallery);
        btn_next = findViewById(R.id.btn_next);

        btn_link.setOnClickListener(click);
        btn_call.setOnClickListener(click);
        btn_sms.setOnClickListener(click);
        btn_camera.setOnClickListener(click);
        btn_gallery.setOnClickListener(click);
        btn_next.setOnClickListener(click);

    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Intent는 액티비티간의 화면 전환을 위해서만 사용되는 클래스
            Intent intent = null;

                switch (view.getId()){

                    case R.id.btn_link:
                        //Intent.ACTION_VIEW : 웹페이지로 화면 전환
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https:www.naver.com"));
                        startActivity(intent);//화면전환
                        break;

                    case R.id.btn_call:
                        //다이얼 화면으로 전환
                        // intent = new Intent(Intent.ACTION_DIAL);
                        //intent.setData(Uri.parse("tel:+821054084279"));
                        //startActivity(intent);

                        //전화를 즉시 걸어주는 기능( 권한설정 필요 )
                        intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:+1054084279"));
                        startActivity(intent);
                        break;

                    case R.id.btn_sms:
                        //문자를 전송하기 위한 페이지
                        intent = new Intent(Intent.ACTION_SENDTO);
                        intent.setData(Uri.parse("smsto:01054084279"));
                        intent.putExtra("sms_body", "개발자솔짜미입니다");
                        startActivity(intent);
                        break;

                    case R.id.btn_camera:
                        //내장 카메라로 연결
                        //intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        //startActivity(intent);//화면전환

                        //동영상 촬영 페이지로 연결
                        intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                        startActivity(intent);
                        break;

                    case R.id.btn_gallery:
                        //갤러리로 연결
                        intent = new Intent(Intent.ACTION_GET_CONTENT);
                        intent.setType("image/*"); //("*/*")모든 파일 보기
                        startActivity(intent);
                        break;

                    case R.id.btn_next:
                        //개발자가 생성한 액티비티로 화면 전환
                        intent = new Intent(IntentMainActivity.this, IntentSubActivity.class);
                        startActivity(intent);
                        break;


                }//switch
            


        }
    };
}