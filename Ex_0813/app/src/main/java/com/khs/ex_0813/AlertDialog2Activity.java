package com.khs.ex_0813;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AlertDialog2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog2);

    }//onCreate()



    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(AlertDialog2Activity.this);

        dialog.setTitle("개발자솔짜미");
        dialog.setMessage("종료?");

        //alertDialog에서 사용 가능한 버튼1
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        //alertDialog에서 사용 가능한 버튼2
        dialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        //alertDialog에서 사용 가능한 버튼3
        dialog.setNeutralButton("LATER", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                AlertDialog.Builder dialog2 = new AlertDialog.Builder(AlertDialog2Activity.this);
                dialog2.setTitle("개발자솔짜미");
                dialog2.setMessage("개미지옥에 오신걸 환영합니다");
                dialog2.show();
            }

        });

        dialog.setCancelable(false);
        dialog.show();//다이얼로그 노출

    }
}