package com.example.persona2fix;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        Button button=(Button) findViewById(R.id.tambah);
        final Intent intent=new Intent(getApplicationContext(),MainPage.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(intent,1);
            }
        });



        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        kAdapter = new KeuanganAdapter(keuanganList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(kAdapter);

        prepareMovieData();
    }


    public void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {

                Bundle bundle = data.getExtras();
                Keuangan keuangan = new Keuangan(bundle.getString("uang"), bundle.getString("date"), bundle.getString("jenis"), bundle.getString("tujuan"));
                keuanganList.add(keuangan);
                kAdapter.notifyDataSetChanged();
            }
        }
    }

    private void prepareMovieData() {
        Keuangan keuangan = new Keuangan("Rp. 500,000", "25/2/2020", "Pemasukan","Dari Ilham");
        keuanganList.add(keuangan);

        keuangan = new Keuangan("Rp. 300,000", "26/2/2020", "Pengeluaran","beli ayam");
        keuanganList.add(keuangan);

        keuangan = new Keuangan("Rp. 200,000", "29/2/2020", "Pemasukan","dari aji");
        keuanganList.add(keuangan);






        kAdapter.notifyDataSetChanged();
    }
}
