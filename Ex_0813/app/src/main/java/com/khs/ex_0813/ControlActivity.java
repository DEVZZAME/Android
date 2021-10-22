package com.khs.ex_0813;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class ControlActivity extends AppCompatActivity {
    Button btn;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        btn = findViewById(R.id.btn);
        img = findViewById(R.id.img);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(ControlActivity.this, btn);

                getMenuInflater().inflate(R.menu.controlmenu, popup.getMenu());

                popup.setOnMenuItemClickListener( menuClick );

                popup.show();
            }
        });
    }//onCreate()

    PopupMenu.OnMenuItemClickListener menuClick = new PopupMenu.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {

            AlertDialog.Builder dialog = new AlertDialog.Builder(ControlActivity.this);

            dialog.setTitle("개발자솔짜미");
            dialog.setMessage("개발중인 앱입니다. \n평가를 해주세요");

            if(img.getVisibility() == View.VISIBLE){
                dialog.setPositiveButton("Invisible", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        img.setVisibility(View.INVISIBLE);
                    }
                });
            }else{
                dialog.setPositiveButton("Visible", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        img.setVisibility(View.VISIBLE);
                    }
                });
            }



            dialog.show();
            return true;
        }
    };
}