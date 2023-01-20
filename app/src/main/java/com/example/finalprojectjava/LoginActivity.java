package com.example.finalprojectjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import static com.example.finalprojectjava.AppApplication.db;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalprojectjava.mahasiswa.AddUserActivity;
import com.example.finalprojectjava.room.AppDatabase;
import com.example.finalprojectjava.room.Mahasiswa;
import com.example.finalprojectjava.room.MahasiswaDao;
import com.example.finalprojectjava.util.PreferencesHelper;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private Button btnRegistrasi, btnMasuk, btnTambah;
    private EditText etNim, etPass;
    PreferencesHelper preferencesHelper;
    MahasiswaDao db;
    AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        preferencesHelper = PreferencesHelper.getInstance(getApplicationContext());

        btnMasuk = findViewById(R.id.btnLogin);
        btnRegistrasi = findViewById(R.id.btnRegistrasi);
        etNim = findViewById(R.id.inputNim);
        etPass = findViewById(R.id.inputPass);

        database = Room.databaseBuilder(this, AppDatabase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();
        db = database.getUserDao();


        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nim = etNim.getText().toString();
                String password = etPass.getText().toString();

                Mahasiswa user = db.getUser(nim, password);
                if (user != null) {
                    Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                    i.putExtra("User", user);
                    startActivity(i);
                    finish();
                }
                else {
                    Toast.makeText(LoginActivity.this, "Masukan Data Dengan Benar", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnRegistrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondIntent = new Intent(LoginActivity.this, AddUserActivity.class);
                startActivity(secondIntent);
            }
        });
    }

}