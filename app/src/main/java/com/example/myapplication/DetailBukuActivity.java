package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DetailBukuActivity extends AppCompatActivity {


    private DatabaseReference mDatabase;
    TextView judul, penulis, jumlah_halaman, bahasa, tanggal_terbit, sinopsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.detailbuku);

        judul = findViewById(R.id.judul);
        penulis = findViewById(R.id.penulis);
        jumlah_halaman = findViewById(R.id.jumlah_halaman);
        bahasa = findViewById(R.id.bahasa);
        tanggal_terbit = findViewById(R.id.tanggal_terbit);
        sinopsis = findViewById(R.id.isi_summary);

        mDatabase = FirebaseDatabase.getInstance().getReference("Buku");

        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int idBuku = getIntent().getIntExtra("ID_Buku", 0);
                if (idBuku != 0){
                    judul.setText(snapshot.child(String.valueOf(idBuku)).child("Judul").getValue(String.class));
                    penulis.setText(snapshot.child(String.valueOf(idBuku)).child("Penulis").getValue(String.class));
                    jumlah_halaman.setText(snapshot.child(String.valueOf(idBuku)).child("Jumlah Halaman").getValue(String.class));
                    bahasa.setText(snapshot.child(String.valueOf(idBuku)).child("Bahasa").getValue(String.class));
                    tanggal_terbit.setText(snapshot.child(String.valueOf(idBuku)).child("Tanggal Terbit").getValue(String.class));
                    sinopsis.setText(snapshot.child(String.valueOf(idBuku)).child("Sinopsis").getValue(String.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}