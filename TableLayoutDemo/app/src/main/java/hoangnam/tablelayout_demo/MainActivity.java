package hoangnam.tablelayout_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //    Khai báo biến giao diện
    private EditText edtDuongLich;
    private EditText edtAmLich;
    private Button btnChuyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Ánh xạ id đến các biến giao diện
        this.edtDuongLich = findViewById(R.id.txtDuongLich);
        this.edtAmLich = findViewById(R.id.txtAmLich);
        this.btnChuyen = findViewById(R.id.btnChuyen);
//        Xử lý sự kiện
        this.btnChuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int namDuong = Integer.parseInt(edtDuongLich.getText().toString());
                int can, chi;
                can = namDuong % 10;
                chi = namDuong % 12;

                String namAm = "";

                switch (can) {
                    case 0:
                        namAm += "Canh ";
                        break;
                    case 1:
                        namAm += "Tân ";
                        break;
                    case 2:
                        namAm += "Nhâm ";
                        break;
                    case 3:
                        namAm += "Quý ";
                        break;
                    case 4:
                        namAm += "Giáp ";
                        break;
                    case 5:
                        namAm += "Ất ";
                        break;
                    case 6:
                        namAm += "Bính ";
                        break;
                    case 7:
                        namAm += "Đinh ";
                        break;
                    case 8:
                        namAm += "Mậu ";
                        break;
                    case 9:
                        namAm += "Kỷ ";
                        break;
                }

                switch (chi) {
                    case 0:
                        namAm += "Thân";
                        break;
                    case 1:
                        namAm += "Dậu";
                        break;
                    case 2:
                        namAm += "Tuất";
                        break;
                    case 3:
                        namAm += "Hợi";
                        break;
                    case 4:
                        namAm += "Tý";
                        break;
                    case 5:
                        namAm += "Sửu";
                        break;
                    case 6:
                        namAm += "Dần";
                        break;
                    case 7:
                        namAm += "Mão";
                        break;
                    case 8:
                        namAm += "Thìn";
                        break;
                    case 9:
                        namAm += "Tỵ";
                        break;
                    case 10:
                        namAm += "Ngọ";
                        break;
                    case 11:
                        namAm += "Mùi";
                        break;
                }

                edtAmLich.setText(namAm);
            }
        });
    }
}