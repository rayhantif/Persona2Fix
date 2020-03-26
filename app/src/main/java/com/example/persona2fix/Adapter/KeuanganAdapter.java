package com.example.persona2fix.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.persona2fix.Model.Keuangan;
import com.example.persona2fix.R;

import java.util.List;

public class KeuanganAdapter extends RecyclerView.Adapter<KeuanganAdapter.MyViewHolder> {
    private List<Keuangan> keuanganList;

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView uang, jenis, date, tujuan;
        private MyViewHolder(View view) {
            super(view);
            uang = (TextView) view.findViewById(R.id.uang);
            date = (TextView) view.findViewById(R.id.date);
            jenis = (TextView) view.findViewById(R.id.jenis);
            tujuan=(TextView) view.findViewById(R.id.tujuan);
        }
    }

    public void setKeuangan(List<Keuangan> words) {
        keuanganList = words;
        notifyDataSetChanged();
    }

    public KeuanganAdapter(List<Keuangan> keuanganList) {
        this.keuanganList = keuanganList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tracking, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Keuangan keuangan = keuanganList.get(position);
        holder.uang.setText(keuangan.getUang());
        holder.date.setText(keuangan.getDate());
        holder.jenis.setText(keuangan.getJenis());
        holder.tujuan.setText(keuangan.getTujuan());

    }

    @Override
    public int getItemCount() {
        return keuanganList.size();
    }
}
