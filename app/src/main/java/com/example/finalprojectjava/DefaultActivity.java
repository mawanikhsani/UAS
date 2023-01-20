package com.example.finalprojectjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DefaultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);

        ImageView ivCover = findViewById(R.id.ivCover);
        TextView tvJudul = findViewById(R.id.tvJudul);
        TextView tvPengarang = findViewById(R.id.tvPengarang);
        TextView tvIsi = findViewById(R.id.tvIsibuku);
        TextView tvTahun = findViewById(R.id.tvTahun);

        Intent intent = getIntent();

        int coverBuku = intent.getIntExtra("GAMBAR_DEFAULT", 0);
        String judulBuku = intent.getStringExtra("TEXT_JUDUL");
        String pengarangBuku = intent.getStringExtra("TEXT_PENGARANG");
        String tahunBuku = intent.getStringExtra("TEXT_TAHUN");
        String isiBuku = intent.getStringExtra("TEXT_ISI");

        ivCover.setImageResource(coverBuku);
        tvJudul.setText(judulBuku);
        tvPengarang.setText(pengarangBuku);
        tvTahun.setText(tahunBuku);
        tvIsi.setText(isiBuku);
    }
}