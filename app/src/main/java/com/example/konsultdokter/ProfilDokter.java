package com.example.konsultdokter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfilDokter extends AppCompatActivity {
    Button kembali1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_dokter);

        kembali1 = (Button) findViewById(R.id.btnkembali1);
        kembali1.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(getApplicationContext(), MenuUtama.class);
                startActivity(i);
            }
        });
    }
}
