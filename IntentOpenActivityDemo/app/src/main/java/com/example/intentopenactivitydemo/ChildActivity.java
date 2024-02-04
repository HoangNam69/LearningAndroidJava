package com.example.intentopenactivitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChildActivity extends AppCompatActivity {

    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        // Anh xa id cho button
        btnBack = findViewById(R.id.btnBack);
        // Bat su kien click cho button
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ket thuc activity hien tai và quay lai activity truoc do
                finish();
            }
        });
    }
}