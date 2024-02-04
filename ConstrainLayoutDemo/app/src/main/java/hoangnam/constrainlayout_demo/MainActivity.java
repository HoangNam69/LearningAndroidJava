/*
 * @ (#) MainActivity.java 1.0 29-Jan-24
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package hoangnam.constrainlayout_demo;
/*
 * @description: xử lý code mẫu bài tính tổng
 * @author: Le Hoang Nam
 * @date:   29-Jan-24
 * @version: 1.0
 */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edtA;
    private EditText edtB;
    private EditText edtResult;
    private Button btnPlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Ánh xạ id cho các biến giao diện
        this.edtA = findViewById(R.id.edtA);
        this.edtB = findViewById(R.id.edtB);
        this.edtResult = findViewById(R.id.edtResult);
        this.btnPlus = findViewById(R.id.btnPlus);
//        Xử lý sự kiện giao diện
        this.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                int result = a + b;
                edtResult.setText(result + "");
            }
        });
    }
}