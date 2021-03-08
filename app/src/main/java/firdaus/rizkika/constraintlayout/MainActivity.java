package firdaus.rizkika.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private static final  Pattern PASSWORD_PATTERN = Pattern.compile("^" +
            "(?=.*[0-9])" +
            //"(?=.*[a-z])" +
            //"(?=.*[A-Z])" +
            "(?=.*[a-zA-Z])" +
            //"(?=.*[@#$%^&+=])" +
            //"(?=\\S+$)" +
            ".{6,}" +
            "$");
    EditText edtEML, edtpass;
    Button SIGNIN;
    String MAIL, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEML = findViewById(R.id.editEmail);
        edtpass = findViewById(R.id.editPass);
        SIGNIN = findViewById(R.id.bttnMasuk);

        SIGNIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validasiEmail(edtEML);
            }
        });
    }

    private boolean validasiEmail(EditText edtEML){
        MAIL= edtEML.getText().toString();
        Password = edtpass.getText().toString();

        if(Patterns.EMAIL_ADDRESS.matcher(MAIL).matches() && PASSWORD_PATTERN.matcher(Password).matches()){
            Toast.makeText(MainActivity.this,"Login Berhasil",Toast.LENGTH_LONG).show();
            return true;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(MAIL).matches()){
            Toast.makeText(MainActivity.this, "Email Salah",Toast.LENGTH_LONG).show();
            return true;
        }
        else if(!PASSWORD_PATTERN.matcher(Password).matches()){
            Toast.makeText(MainActivity.this,"Password Salah",Toast.LENGTH_LONG).show();
            return true;
        }
        else {
            Toast.makeText(MainActivity.this,"Email dan Password Salah",Toast.LENGTH_LONG).show();
            return false;
        }

    }

}

