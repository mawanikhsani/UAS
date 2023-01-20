package com.example.finalprojectjava.mahasiswa;
import static com.example.finalprojectjava.AppApplication.db;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.room.Room;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalprojectjava.HomeActivity;
import com.example.finalprojectjava.LoginActivity;
import com.example.finalprojectjava.R;
import com.example.finalprojectjava.room.AppDatabase;
import com.example.finalprojectjava.room.Mahasiswa;
import com.example.finalprojectjava.room.MahasiswaDao;

public class AddUserActivity extends AppCompatActivity {

    EditText etNama, etNim, etKelas, etAlamat, etPass, etConfPass;
    Button btndaftar, btnbatal;

    private MahasiswaDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        etNim = findViewById(R.id.inputNim);
        etNama = findViewById(R.id.inputNama);
        etKelas = findViewById(R.id.inputKelas);
        etAlamat = findViewById(R.id.inputAlamat);
        etPass = findViewById(R.id.inputPass);
        btndaftar = findViewById(R.id.btnDaftar);
        btnbatal = findViewById(R.id.btnBatal);
        etConfPass = findViewById(R.id.inputConfPass);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        btnbatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddUserActivity.this, LoginActivity.class));
            }
        });

        userDao = Room.databaseBuilder(this, AppDatabase.class, "mi-database.db").allowMainThreadQueries()
                .build().getUserDao();

        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nim = etNim.getText().toString().trim();
                String nama = etNama.getText().toString().trim();
                String kelas = etKelas.getText().toString().trim();
                String alamat = etAlamat.getText().toString().trim();
                String password = etPass.getText().toString().trim();
                String passwordConf = etConfPass.getText().toString().trim();

                NotificationCompat.Builder builder = new NotificationCompat.Builder(AddUserActivity.this, "My Notification");
                builder.setContentTitle("Ayang NgeChat NICH....");
                builder.setContentText("Tapi Bo'ong Awokwokwokwok");
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(AddUserActivity.this);
                managerCompat.notify(1, builder.build());

                if (password.equals(passwordConf)) {
                    Mahasiswa user = new Mahasiswa(nim, nama, kelas, alamat, password);
                    userDao.insertAll(user);
                    Intent moveToLogin = new Intent(AddUserActivity.this, LoginActivity.class);
                    startActivity(moveToLogin);

                } else {
                    Toast.makeText(AddUserActivity.this, "Masukan Data Dengan Benar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}