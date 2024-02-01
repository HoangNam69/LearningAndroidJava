package hoangnam.projectinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtFullname, edtIdentify, edtAdditionalInfor;
    private RadioGroup rgCertifycate;
    private CheckBox chbReadBook, chbReadNewsPaper, chbCode;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//       Ánh xạ id cho các biến giao diện
        edtFullname = findViewById(R.id.edtFullname);
        edtIdentify = findViewById(R.id.edtIdentify);
        rgCertifycate = findViewById(R.id.rgCertificate);
        chbReadBook = findViewById(R.id.chbReadBook);
        chbReadNewsPaper = findViewById(R.id.chbReadNewPaper);
        chbCode = findViewById(R.id.chbCode);
        edtAdditionalInfor = findViewById(R.id.edtMultiLineAdditionalnfor);
        btnSend = findViewById(R.id.btnSend);
//        Xử lý sự kiện
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = edtFullname.getText().toString();

                if (fullName.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập họ tên", Toast.LENGTH_SHORT).show();
//                    edtFullname.setError("Vui lòng nhập họ tên");
                    edtFullname.requestFocus();
                    return;
                }

                String identify = edtIdentify.getText().toString();

                if (identify.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập số căn cước công dân", Toast.LENGTH_SHORT).show();
                    edtIdentify.requestFocus();
                    return;
                } else if (identify.length() != 12) {
                    Toast.makeText(MainActivity.this, "Số căn cước công dân phải có 12 chữ số", Toast.LENGTH_SHORT).show();
                    edtIdentify.requestFocus();
                    edtIdentify.selectAll();
                    return;
                }

                String additionalInfor = edtAdditionalInfor.getText().toString();
                String certificate = "";

                if (rgCertifycate.getCheckedRadioButtonId() == R.id.rbIntermediateLevel) {
                    certificate = "Trung cấp";
                } else if (rgCertifycate.getCheckedRadioButtonId() == R.id.rbCollege) {
                    certificate = "Cao đẳng";
                } else if (rgCertifycate.getCheckedRadioButtonId() == R.id.rbUniversity) {
                    certificate = "Đại học";
                }

                String hobby = "";
                if (chbReadBook.isChecked()) {
                    hobby += chbReadBook.getText().toString() + " ";
                } else if (chbReadNewsPaper.isChecked()) {
                    hobby += chbReadNewsPaper.getText().toString() + " ";
                } else if (chbCode.isChecked()) {
                    hobby += chbCode.getText().toString() + " ";
                }


            }
        });
    }
}