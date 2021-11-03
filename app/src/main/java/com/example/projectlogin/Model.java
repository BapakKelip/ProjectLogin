package com.example.projectlogin;

public class Model {
    private String Judul;

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String judul) {
        Judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    private String deskripsi;
    private String tanggal;
    private String gambar;
    public Model(String judul, String deskripsi, String tanggal, String gambar) {
        Judul = judul;
        this.deskripsi = deskripsi;
        this.tanggal = tanggal;
        this.gambar = gambar;
    }

}
