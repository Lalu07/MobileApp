package firdaus.rizkika.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class masuk extends AppCompatActivity {

    TextView Email, Pas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk);

        Email = findViewById(R.id.hslEmail);
        Pas = findViewById(R.id.hslPass);

        Bundle bundle = getIntent().getExtras();

        String email = bundle.getString("e");
        String Pass = bundle.getString("p");

        Email.setText(email);
        Pas.setText(Pass);
    }
}