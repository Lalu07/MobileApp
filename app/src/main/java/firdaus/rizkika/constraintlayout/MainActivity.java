package firdaus.rizkika.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtUSER, editpass;
    Button SIGNIN;
    String Nama, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show();
    }

    public void show(){
        edtUSER = findViewById(R.id.editUser);
        editpass = findViewById(R.id.editPass);
        SIGNIN = findViewById(R.id.bttnMasuk);

        SIGNIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nama = edtUSER.getText().toString();
                Password = editpass.getText().toString();

                Toast T = Toast.makeText(getApplicationContext(), "Username anda :"+Nama+"Password anda :"+Password+"", Toast.LENGTH_LONG);
                T.show();
            }
        });
    }


}