package hoangnam.projectinformation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
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
//               Lấy họ và tên, kiểm tra
                String fullName = edtFullname.getText().toString();
                if (fullName.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập họ tên", Toast.LENGTH_SHORT).show();
//                    edtFullname.setError("Vui lòng nhập họ tên");
                    edtFullname.requestFocus();
                    return;
                }

//                Lấy số căn cước công dân, kiểm tra
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

//                Lấy id của radio button được chọn
                int idCertificate = rgCertifycate.getCheckedRadioButtonId();
                RadioButton rbSelected = findViewById(idCertificate); // Tìm ra radio button được chọn
                String certificate = rbSelected.getText().toString();

//                Lấy sở thích được chọn
                String hobby = "";
                if (chbReadBook.isChecked()) {
                    hobby += chbReadBook.getText().toString() + " ";
                } else if (chbReadNewsPaper.isChecked()) {
                    hobby += chbReadNewsPaper.getText().toString() + " ";
                } else if (chbCode.isChecked()) {
                    hobby += chbCode.getText().toString() + " ";
                }

                String additionalInfor = edtAdditionalInfor.getText().toString();

                String popup = "Họ và tên: " + fullName + "\n" +
                        "Số căn cước công dân: " + identify + "\n" +
                        "Bằng cấp: " + certificate + "\n" +
                        "Sở thích: " + hobby + "\n" +
                        "Thông tin bổ sung: " + additionalInfor;

//                Tạo Dialog thông báo
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông tin cá nhân");
                builder.setMessage(popup);
                builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.create().show();
            }
        });
    }
}