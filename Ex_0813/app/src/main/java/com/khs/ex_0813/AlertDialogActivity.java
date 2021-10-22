package com.khs.ex_0813;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlertDialogActivity extends AppCompatActivity {

    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener( click );


    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            //간단한 경고창을 띄워주는 다이얼로그(팝업창)이며 최대 세개까지 버튼을 가질 수 있다.
            AlertDialog.Builder dialog = new AlertDialog.Builder(AlertDialogActivity.this);

            dialog.setTitle("개발자솔짜미");
            dialog.setMessage("개발중인 앱입니다. \n평가를 해주세요");

            //alertDialog에서 사용 가능한 버튼1
            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(AlertDialogActivity.this, "OK누름", Toast.LENGTH_SHORT).show();
                }
            });

            //alertDialog에서 사용 가능한 버튼2
            dialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(AlertDialogActivity.this, "NO누름", Toast.LENGTH_SHORT).show();
                }
            });

            //alertDialog에서 사용 가능한 버튼3
            dialog.setNeutralButton("LATER", null);

            //다이얼로그 주변의 빈공간, 뒤로가기 버튼 클릭 등으로
            //다이얼로그가 종료되는 것을 방지
            dialog.setCancelable(false);

            dialog.show();//다이얼로그 노출

        }//onClick
    };
}