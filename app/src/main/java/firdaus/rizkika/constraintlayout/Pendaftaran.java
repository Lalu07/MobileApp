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

public class Pendaftaran extends AppCompatActivity {
    EditText edtNama, edtAlamat, edtEmail, edtPassword, edtrePass;
    FloatingActionButton simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtNama.getText().toString().isEmpty() || edtAlamat.getText().toString().isEmpty() ||
                edtEmail.getText().toString().isEmpty() || edtPassword.getText().toString().isEmpty()||
                edtrePass.getText().toString().isEmpty()){

                    Toast.makeText(Pendaftaran.this,"Seluruh data harus di isi!!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}