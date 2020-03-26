package com.example.persona2fix;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.persona2fix.Model.Keuangan;

import java.util.List;

public class KeuanganViewModel extends AndroidViewModel {
    private KeuanganRepository kRepository;
    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    private LiveData<List<Keuangan>> kAllkeuangan;

    public KeuanganViewModel(Application application) {
        super(application);
        kRepository = new KeuanganRepository(application);
        kAllkeuangan = kRepository.getAllWords();
    }

    public LiveData<List<Keuangan>> getAllWords() {
        return kAllkeuangan;
    }

    void insert(Keuangan keuangan) {
        kRepository.insert(keuangan);
    }
}
