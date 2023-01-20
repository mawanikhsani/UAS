package com.example.finalprojectjava.room;



import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MahasiswaDao {

//    @Query("SELECT * FROM mahasiswa")
//    List<Mahasiswa> getAll();

    @Query("SELECT * FROM mahasiswa WHERE nim= :nim and password= :password")
    Mahasiswa getUser(String nim, String password);

    @Insert
    void insertAll(Mahasiswa mahasiswa);

    @Delete
    public void deleteUsers(Mahasiswa users);

    @Update
    public void update(Mahasiswa mahasiswa);

    @Delete
    public void deleteAll(Mahasiswa user1,Mahasiswa user2);

}
