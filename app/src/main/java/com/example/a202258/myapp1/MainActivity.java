package com.example.a202258.myapp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn_simple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButtonListeners();
    }
    public void sendMessage(View view) {
        // Do something in response to button
    }
    private void addButtonListeners() {
        btn_simple = (Button) findViewById(R.id.btn_simple);
        btn_simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent simpleCalcIntent = new Intent(MainActivity.this, SimpleCalcActivity.class);
                startActivity(simpleCalcIntent);
            }
        });
    }
}
