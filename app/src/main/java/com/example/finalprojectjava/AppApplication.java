package com.example.finalprojectjava;


import android.app.Application;

import androidx.room.Room;

import com.example.finalprojectjava.room.AppDatabase;

public class AppApplication extends Application {

    public static AppDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "com/example/finalprojectjava/mahasiswa").allowMainThreadQueries().build();
    }
}