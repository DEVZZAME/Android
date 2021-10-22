package com.khs.ex_0816;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button show_menu;
    ImageView img;
    AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show_menu = findViewById(R.id.show_menu);
        img = findViewById(R.id.img);
        dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("앱 제목");

        show_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu popup = new PopupMenu(MainActivity.this, view); //show_menu 앵커
                getMenuInflater().inflate(R.menu.my_menu, popup.getMenu());

                popup.setOnMenuItemClickListener( popupListener );
                popup.show();
            }
        });
    }//onCreate()

    PopupMenu.OnMenuItemClickListener popupListener = new PopupMenu.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            String str = "";

            if(img.getVisibility() == View.VISIBLE){
                str = "INVISIBLE";
                dialog.setPositiveButton(str, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        img.setVisibility(View.INVISIBLE);
                    }
                });
            }else {
                str = "VISIBLE";
                dialog.setPositiveButton(str, new DialogInterface.OnClickListener() {
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