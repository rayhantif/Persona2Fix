package com.example.persona2fix.Model;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "keuangan")
public class Keuangan {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name="_id")
    private int _id;

    @NonNull
    @ColumnInfo(name="uang")
    private String uang;

    @NonNull
    @ColumnInfo(name="date")
    private String date;

    @NonNull
    @ColumnInfo(name="jenis")
    private String jenis;

    @NonNull
    @ColumnInfo(name="tujuan")
    private String tujuan;

        public Keuangan() {
        }

        public Keuangan(@NonNull String uang, @NonNull String date, @NonNull String jenis, @NonNull String tujuan) {
            this.uang = uang;
            this.date = date;
            this.jenis = jenis;
            this.tujuan=tujuan;
        }

        public int get_id(){return  _id;};
        public String getUang() {
            return uang;
        }

        public void setUang(String jumlah) {
            this.uang = jumlah;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getJenis() {
            return jenis;
        }

        public void setJenis(String jenis) {
            this.jenis = jenis;
        }

        public String getTujuan(){return tujuan;}

        public void setTujuan(String tujuan){this.tujuan=tujuan;}


}
