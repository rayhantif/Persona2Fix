package com.example.persona2fix;

public class Keuangan {
        private String uang;
        private String date, jenis, tujuan;

        public Keuangan() {
        }

        public Keuangan(String uang, String date, String jenis, String tujuan) {
            this.uang = uang;
            this.date = date;
            this.jenis = jenis;
            this.tujuan=tujuan;
        }

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
