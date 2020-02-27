package com.example.persona2fix;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;




import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Keuangan> keuanganList = new ArrayList<>();
    private RecyclerView recyclerView;
    private KeuanganAdapter kAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        kAdapter = new KeuanganAdapter(keuanganList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(kAdapter);

        prepareMovieData();
    }

    private void prepareMovieData() {
        Keuangan keuangan = new Keuangan("Rp. 500,000", "25/2/2020", "Pemasukan");
        keuanganList.add(keuangan);

        keuangan = new Keuangan("Rp. 300,000", "26/2/2020", "Pengeluaran");
        keuanganList.add(keuangan);

        keuangan = new Keuangan("Rp. 200,000", "29/2/2020", "Pemasukan");
        keuanganList.add(keuangan);





        kAdapter.notifyDataSetChanged();
    }
}
