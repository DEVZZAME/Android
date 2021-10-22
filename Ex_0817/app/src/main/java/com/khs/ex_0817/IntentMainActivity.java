package com.khs.ex_0817;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class IntentMainActivity extends AppCompatActivity {

    EditText edit_name, edit_age, edit_tel, edit_bday;
    Button btn_date, btn_send;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_main);

        edit_name = findViewById(R.id.edit_name);
        edit_age = findViewById(R.id.edit_age);
        edit_tel = findViewById(R.id.edit_tel);
        edit_bday = findViewById(R.id.edit_bday);

        btn_date = findViewById(R.id.btn_date);
        btn_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //현재 날짜를 구하자!
                Calendar now = Calendar.getInstance();
                int y = now.get(Calendar.YEAR);//년
                int m = now.get(Calendar.MONTH);//월
                int d = now.get(Calendar.DAY_OF_MONTH);//일

                dialog = new DatePickerDialog(IntentMainActivity.this, dateListener, y, m, d);

                dialog.show();
            }
        });


        btn_send = findViewById(R.id.btn_send);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(IntentMainActivity.this, IntentSubActivity.class);

                //EditText에 담겨진 정보들을 intent에 담아서 SubActivity로 전달
                String name = edit_name.getText().toString();
                String age = edit_age.getText().toString();
                String tel = edit_tel.getText().toString();
                String birth = edit_bday.getText().toString();

                //전달할 값을 intent에 저장
                intent.putExtra("m_name", name);
                intent.putExtra("m_age", age);
                intent.putExtra("m_tel", tel);
                intent.putExtra("m_birth", birth);
                startActivity(intent);

            }
        });
    }//onCreate()

    //달력의 날짜선택을 감지하는 감지자
    DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {

            //파라미터 중 month는
            //1월 -> 0, 8월 ->7

            //2010-05-19
            String strDate = String.format("%d-%02d-%02d", year, month+1, day);

            edit_bday.setText(strDate);
        }
    };
}