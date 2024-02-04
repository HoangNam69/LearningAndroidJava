package com.example.intentopenactivitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      Anh xa id cho button
        btnOpen = findViewById(R.id.btnOpen);
//      Bat su kien click cho button
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              Tao doi tuong Intent
                Intent myIntent = new Intent(MainActivity.this, ChildActivity.class); // Intent công khai
//                Khởi động intent
                startActivity(myIntent);
            }
        });
    }
}