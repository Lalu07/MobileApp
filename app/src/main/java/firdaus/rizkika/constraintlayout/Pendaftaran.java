package firdaus.rizkika.constraintlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Pendaftaran extends AppCompatActivity {
    EditText edtNama, edtAlamat, edtEmail, edtPassword, edtrePass;
    FloatingActionButton clap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran);
        edtNama = findViewById(R.id.editNama);
        edtAlamat = findViewById(R.id.editAlamat);
        edtEmail = findViewById(R.id.editEmail);
        edtPassword = findViewById(R.id.editPass);
        edtrePass = findViewById(R.id.rePass);
        clap = findViewById(R.id.pop);

        clap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (edtNama.getText().toString().isEmpty() || edtAlamat.getText().toString().isEmpty() ||
                edtEmail.getText().toString().isEmpty() || edtPassword.getText().toString().isEmpty() ||
                edtrePass.getText().toString().isEmpty()){
                    Snackbar.make(view,"Data Wajib di isi!!!", Snackbar.LENGTH_SHORT).show();
                }

                else{
                    if(edtPassword.getText().toString().equals(edtrePass.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Pendaftaran berhasill",Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                    else {
                        Snackbar.make(view,"Password dan repassword harus sama!",Snackbar.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}