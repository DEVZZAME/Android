package com.khs.ex_0813;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PopupMenuActivity extends AppCompatActivity {
    Button btn_show;
    Button anchor;//팝업메뉴를 띄울 기준 객체

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu);

        btn_show = findViewById(R.id.btn_show);
        anchor = findViewById(R.id.anchor);

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu popup = new PopupMenu(
                        PopupMenuActivity.this,//context : 화면제어권자
                        anchor); //anchor : 팝업메뉴를 띄울 기준

                //팝업메뉴에 my_menu.xml 리소스를 참조시킨다
                getMenuInflater().inflate(R.menu.my_menu, popup.getMenu());

                //팝업메뉴에 이벤트 감지자 등록

                popup.setOnMenuItemClickListener( itemClick );

                popup.show();//메뉴호출

            }
        });
    }//onCreate();

    PopupMenu.OnMenuItemClickListener itemClick = new PopupMenu.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {

            switch (item.getItemId( ) ){

                case R.id.menu1:
                    Toast.makeText(PopupMenuActivity.this, "menu1", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.menu2:
                    Toast.makeText(PopupMenuActivity.this, "menu2", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.menu3:
                    finish();
                    break;

            }//switch

            return true;
        }
    };

    //뒤로가기버튼 클릭 감지


    @Override
    public void onBackPressed() {
        Toast.makeText(PopupMenuActivity.this, "종료합니다", Toast.LENGTH_SHORT).show();
        //super.onBackPressed();
        finish();
    }
}