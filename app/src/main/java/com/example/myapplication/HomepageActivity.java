package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class HomepageActivity extends AppCompatActivity {

    ImageButton katalog, dipinjam, review, akun;
    ImageButton buku1, buku2, buku3, buku4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.beranda);

        katalog = findViewById(R.id.imageKatalog);
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
                Intent intent = new Intent(HomepageActivity.this, DetailBukuActivity.class);
                startActivity(intent);
            }
        });


        katalog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomepageActivity.this, KatalogActivity.class);
                startActivity(intent);
            }
        });

        dipinjam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomepageActivity.this, DipinjamActivity.class);
                startActivity(intent);
            }
        });

        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomepageActivity.this, ReviewActivity.class);
                startActivity(intent);
            }
        });

        akun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomepageActivity.this, AccountActivity.class);
                startActivity(intent);
            }
        });

    }
}