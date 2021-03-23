package firdaus.rizkika.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
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
                validasi();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mnDaftar){
            Intent i = new Intent(MainActivity.this,Pendaftaran.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }


    private boolean validasi(){
        MAIL= edtEML.getText().toString();
        Password = edtpass.getText().toString();

        if(Patterns.EMAIL_ADDRESS.matcher(MAIL).matches() && PASSWORD_PATTERN.matcher(Password).matches()){
            Toast.makeText(MainActivity.this,"Login Berhasil",Toast.LENGTH_LONG).show();
            Bundle F = new Bundle();

            F.putString("e",MAIL.trim());
            F.putString("p",Password.trim());

            Intent intent = new Intent(MainActivity.this,masuk.class);
            intent.putExtras(F);

            startActivity(intent);
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
            Toast.makeText(MainActivity.this,"Email atau Password Salah",Toast.LENGTH_LONG).show();

            return false;
        }
        //End
    }

}

