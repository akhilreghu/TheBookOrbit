package com.akhilinteractive.thebookorbit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Book_Activity extends AppCompatActivity {

    private TextView tName,tClass,tUni,tLoc;
    private ImageView thimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        tName = (TextView) findViewById(R.id.touchTitle);
        tClass = (TextView) findViewById(R.id.touchClass);
        tUni = (TextView) findViewById(R.id.touchUni);
        tLoc = (TextView) findViewById(R.id.touchLoc);
        thimg = (ImageView) findViewById(R.id.touchImage);

        Intent intent = getIntent();
        String title = intent.getExtras().getString("Title");
        String classname = intent.getExtras().getString("Class");
        String uniname = intent.getExtras().getString("Uni");
        String loc = intent.getExtras().getString("Loc");
        int img  = intent.getExtras().getInt("Img");

        tName.setText(title);
        tClass.setText(classname);
        tUni.setText(uniname);
        tLoc.setText(loc);
        thimg.setImageResource(img);
    }
}
