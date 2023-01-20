package com.example.finalprojectjava.room;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Mahasiswa implements Serializable{

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
//    @ColumnInfo(name = "nama")
    private String nama;
//    @ColumnInfo(name = "nim")
    private String nim;
//    @ColumnInfo(name = "kelas")
    private String kelas;
//    @ColumnInfo(name = "alamat")
    private String alamat;
//    @ColumnInfo(name = "password")
    private String password;

    public Mahasiswa(String nim, String nama, String kelas, String alamat, String password){
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.alamat = alamat;
        this.password = password;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull  int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kejuruan) {
        this.kelas = kejuruan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {this.alamat = alamat;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String alamat) {
        this.password = alamat;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nim='" + nim + '\'' +
                ", nama='" + nama + '\'' +
                ", kelas='" + kelas + '\'' +
                ", alamat='" + alamat + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}



