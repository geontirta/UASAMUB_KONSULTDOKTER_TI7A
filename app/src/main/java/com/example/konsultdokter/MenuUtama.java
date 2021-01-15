package com.example.konsultdokter;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuUtama extends AppCompatActivity {
    ImageButton imgtambah1;
    ImageButton imglihat1;
    Button btnkeluar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);
        imgtambah1 = (ImageButton) findViewById(R.id.imgtambah);
        imgtambah1.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(getApplicationContext(), KonsultasiDokter.class);
                startActivity(i);
            }
        });

        imglihat1 = (ImageButton) findViewById(R.id.imglihat);
        imglihat1.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(getApplicationContext(), ProfilDokter.class);
                startActivity(i);
            }
        });

        btnkeluar1 = (Button) findViewById(R.id.btnkeluar);
        btnkeluar1.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}
