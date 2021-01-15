package com.example.konsultdokter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class KonsultasiDokter extends AppCompatActivity {

    Button kembali;
    EditText chat;
    DatabaseReference reference;

    String USERNAME_KEY = "usernamekey";
    String username_key = "";
    String username_key_new = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konsultasi_dokter);

        chat = findViewById(R.id.edchat);

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ubah state menjadi loading
                kembali.setEnabled(false);
                kembali.setText("Pertanyaan akan segera dijawab, terimakasih");

                //menyimpan pada firebase
                // reference = FirebaseDatabase.getInstance().getReference().child("Users").child(username.getText().toString());

                reference = FirebaseDatabase.getInstance().getReference().child("Users")
                        .child(username_key_new);

                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange (@NonNull DataSnapshot dataSnapshot) {
                        dataSnapshot.getRef().child("chat").setValue(chat.getText().toString());
                    }
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
                Intent gotonexregister = new Intent(com.example.konsultdokter.KonsultasiDokter.this, com.example.konsultdokter.MenuUtama.class);
                startActivity(gotonexregister);
            }


        });

    }
}