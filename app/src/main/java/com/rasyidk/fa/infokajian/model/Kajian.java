package com.rasyidk.fa.infokajian.model;

import com.google.firebase.database.IgnoreExtraProperties;
import java.io.Serializable;

public class Kajian implements Serializable {
    private String key;
    private String nama;
    private String waktu;
    private String date;
    private String lokasi;
    private String deskripsi;

    public Kajian() {

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    @Override
    public String toString() {
        return " "+nama+"\n" +
                " "+waktu+"\n" +
                " "+date+"\n" +
                " "+lokasi+"\n" +
                " "+deskripsi;
    }

    public Kajian(String nm, String wkt, String dat, String lks, String desc){
        nama = nm;
        waktu = wkt;
        date = dat;
        lokasi = lks;
        deskripsi = desc;
    }
}
