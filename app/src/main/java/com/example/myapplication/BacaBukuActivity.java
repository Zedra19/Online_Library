package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BacaBukuActivity extends AppCompatActivity {


    TextView judul, isi_buku;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.bacabuku);

        judul = findViewById(R.id.judul);
        isi_buku = findViewById(R.id.isi_buku);

        mDatabase = FirebaseDatabase.getInstance().getReference("Buku");

        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int idBuku = getIntent().getIntExtra("ID_Buku", 0);
                if (idBuku != 0){
                    judul.setText(snapshot.child(String.valueOf(idBuku)).child("Judul").getValue(String.class));
                    isi_buku.setText(snapshot.child(String.valueOf(idBuku)).child("Buku").getValue(String.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}