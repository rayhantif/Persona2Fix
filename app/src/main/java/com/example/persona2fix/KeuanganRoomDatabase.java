package com.example.persona2fix;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.persona2fix.Model.Keuangan;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Keuangan.class}, version = 1, exportSchema = false)
abstract class KeuanganRoomDatabase extends RoomDatabase {
    abstract KeuanganDAO keuanganDAO();
    private static volatile KeuanganRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static KeuanganRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (KeuanganRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            KeuanganRoomDatabase.class, "keuangan")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
