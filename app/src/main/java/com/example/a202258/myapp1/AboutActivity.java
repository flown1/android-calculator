package com.example.a202258.myapp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    private TextView aboutText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

    //    aboutText.setText("MyCalc3000\nis a simple calculator with two modes: simple and advanced.\n" +
    //            "\n\n Author: Wiktor Pabich \nAll rights reserved \n2018 Lodz, Poland");
    }
}
