package com.example.persona2fix.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.database.Cursor;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.persona2fix.Adapter.DBAdapter;
import com.example.persona2fix.KeuanganViewModel;
import com.example.persona2fix.Model.Keuangan;
import com.example.persona2fix.Adapter.KeuanganAdapter;
import com.example.persona2fix.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Keuangan> keuanganList = new ArrayList<>();
    private RecyclerView recyclerView;
    private KeuanganAdapter kAdapter;
    private DBAdapter db = new DBAdapter(this);
    private KeuanganViewModel kkeuanganviewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button) findViewById(R.id.tambah);
        final Intent intent=new Intent(getApplicationContext(), MainPage.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(intent,1);
            }
        });

        Button clear=(Button) findViewById(R.id.hapus);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.open();
                Cursor c = db.getAllKeuangan();
                if (c.moveToFirst())
                {
                    do {
                        if(db.deleteKeuangan(c.getLong(0)))
                        {

                        }

                    } while (c.moveToNext());
                }
                db.close();
                keuanganList.clear();
                kAdapter.notifyDataSetChanged();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        kAdapter = new KeuanganAdapter(keuanganList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(kAdapter);
        /*kkeuanganviewmodel = new ViewModelProvider(this).get(KeuanganViewModel.class);
        kkeuanganviewmodel.getAllWords().observe(this, new Observer<List<Keuangan>>() {
            @Override
            public void onChanged(@Nullable final List<Keuangan> words) {
                // Update the cached copy of the words in the adapter.
                kAdapter.setKeuangan(words);
            }
        });*/
        prepareDataKeuangan();

    }


    public void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {

                Bundle bundle = data.getExtras();
                db.open();
                long id=db.insertKeuangan(bundle.getString("uang"),bundle.getString("date"),bundle.getString("jenis"),bundle.getString("tujuan"));
                db.close();

                db.open();
                Cursor c = db.getAllKeuangan();
                if (c.moveToLast())
                {
                        Keuangan keuangan=new Keuangan(c.getString(1), c.getString(2), c.getString(3),c.getString(4));
                        keuanganList.add(keuangan);
                }
                kAdapter.notifyDataSetChanged();
            }
        }
    }

    private void prepareDataKeuangan() {
        db.open();
        Cursor c = db.getAllKeuangan();
        if (c.moveToFirst())
        {
            do {
                Keuangan keuangan=new Keuangan(c.getString(1), c.getString(2), c.getString(3),c.getString(4));
                keuanganList.add(keuangan);
            } while (c.moveToNext());
        }
        db.close();



        kAdapter.notifyDataSetChanged();
    }
}
