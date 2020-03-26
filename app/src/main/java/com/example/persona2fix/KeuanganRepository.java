package com.example.persona2fix;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.persona2fix.Model.Keuangan;

import java.util.List;

class KeuanganRepository {
    private KeuanganDAO keuanganDAO;
    private LiveData<List<Keuangan>> kAllkeuangan;

    KeuanganRepository(Application application) {
        KeuanganRoomDatabase db = KeuanganRoomDatabase.getDatabase(application);
        keuanganDAO = db.keuanganDAO();
        kAllkeuangan = keuanganDAO.getAllTracking();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Keuangan>> getAllWords() {
        return kAllkeuangan;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(final Keuangan keuangan) {
       KeuanganRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
           @Override
           public void run() {
               keuanganDAO.insert(keuangan);
           }
       });
    }
}
