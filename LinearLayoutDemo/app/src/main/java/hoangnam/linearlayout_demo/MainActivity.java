package hoangnam.linearlayout_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText edtFarenheit;
    private EditText edtCelsius;
    private Button btnToCelsius;
    private Button btnToFarenheit;
    private Button btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Ánh xạ id cho các biến giao diện
        this.edtFarenheit = findViewById(R.id.edtFarenheit);
        this.edtCelsius = findViewById(R.id.edtCelsius);
        this.btnToCelsius = findViewById(R.id.btnToCelsius);
        this.btnToFarenheit = findViewById(R.id.btnToFarenheit);
        this.btnClear = findViewById(R.id.btnClear);
//        Xử lý sự kiện
//        Chuyển đổi từ Farenheit sang Celsius
        this.btnToCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtFarenheit.getText().equals("")) {
                    double f = Double.parseDouble(edtFarenheit.getText().toString());
                    double result = ((f - 32) * 5) / 9;
                    DecimalFormat df = new DecimalFormat("00.00");
                    edtCelsius.setText(df.format(result));
                }
            }
        });
//        Chuyển đổi từ Celsius sang Farenheit
        this.btnToFarenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtCelsius.getText().equals("")) {
                    double c = Double.parseDouble(edtCelsius.getText().toString());
                    double result = (c * 9) / 5 + 32;
                    DecimalFormat df = new DecimalFormat("00.00");
                    edtFarenheit.setText(df.format(result));
                }
            }
        });
//        Xóa trắng
        this.btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtCelsius.setText("");
                edtFarenheit.setText("");
            }
        });
    }
}