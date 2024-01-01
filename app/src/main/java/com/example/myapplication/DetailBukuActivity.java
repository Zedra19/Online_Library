package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DetailBukuActivity extends AppCompatActivity {


    private DatabaseReference mDatabase;
    TextView judul, penulis, jumlah_halaman, bahasa, tanggal_terbit, sinopsis, baca;
    ImageButton home, dipinjam, review, akun;
    ImageView feedback;
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
        home = findViewById(R.id.imageHome);
        dipinjam = findViewById(R.id.imageDipinjam);
        review = findViewById(R.id.imageReview);
        akun = findViewById(R.id.imageAccount);

        feedback = findViewById(R.id.Feedback);
        baca = findViewById(R.id.button_baca);


        mDatabase = FirebaseDatabase.getInstance().getReference("Buku");

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailBukuActivity.this, HomepageActivity.class);
                startActivity(intent);
            }
        });

        dipinjam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailBukuActivity.this, DipinjamActivity.class);
                startActivity(intent);
            }
        });

        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailBukuActivity.this, ReviewActivity.class);
                startActivity(intent);
            }
        });

        akun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailBukuActivity.this, AccountActivity.class);
                startActivity(intent);
            }
        });

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailBukuActivity.this, FeedbackActivity.class);
                startActivity(intent);
            }
        });
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
                baca.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(DetailBukuActivity.this, BacaBukuActivity.class);
                        intent.putExtra("ID_Buku", idBuku);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}