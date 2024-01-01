package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class KatalogActivity extends AppCompatActivity {
    ImageButton home, dipinjam, review, akun;
    ImageButton buku1, buku2, buku3, buku4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.katalog);

        home = findViewById(R.id.imageHome);
        dipinjam = findViewById(R.id.imageDipinjam);
        review = findViewById(R.id.imageReview);
        akun = findViewById(R.id.imageAccount);

        buku1 = findViewById(R.id.matahari);
        buku2 = findViewById(R.id.filTeras);
        buku3 = findViewById(R.id.dearJohn);
        buku4 = findViewById(R.id.harrypot);

        buku1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KatalogActivity.this, DetailBukuActivity.class);
                intent.putExtra("ID_Buku", 1);
                startActivity(intent);
            }
        });

        buku2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KatalogActivity.this, DetailBukuActivity.class);
                intent.putExtra("ID_Buku", 2);
                startActivity(intent);
            }
        });

        buku3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KatalogActivity.this, DetailBukuActivity.class);
                intent.putExtra("ID_Buku", 3);
                startActivity(intent);
            }
        });

        buku4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KatalogActivity.this, DetailBukuActivity.class);
                intent.putExtra("ID_Buku", 4);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KatalogActivity.this, HomepageActivity.class);
                startActivity(intent);
            }
        });

        dipinjam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KatalogActivity.this, DipinjamActivity.class);
                startActivity(intent);
            }
        });

        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KatalogActivity.this, ReviewActivity.class);
                startActivity(intent);
            }
        });

        akun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KatalogActivity.this, AccountActivity.class);
                startActivity(intent);
            }
        });
    }
}