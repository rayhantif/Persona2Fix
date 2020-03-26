package com.example.persona2fix;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.persona2fix.Model.Keuangan;

import java.util.List;

@Dao
public interface KeuanganDAO {
    @Query("SELECT * from keuangan")
    LiveData<List<Keuangan>> getAllTracking();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Keuangan keuangan);

    @Query("DELETE FROM keuangan")
    void deleteAll();
}
