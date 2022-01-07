package com.example.my_application;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.DrawableRes;

public class myModel {

    int gambar;
    String nama;
    String harga;
    String detail;

    public static final String  TITLE_KEY = "Title";
    public static final String  Detail_KEY = "Detail";
    public static final String  IMAGE_KEY = "Image";

    public myModel(int gambar, String nama, String harga, String detail) {
        this.gambar = gambar;
        this.nama = nama;
        this.harga = harga;
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    public String getNama() {
        return nama;
    }

    public String getHarga() {
        return harga;
    }

    public int getGambar() {
        return gambar;
    }

    static Intent starter(Context context, String title, @DrawableRes int
            imageResId, String detail) {
        Intent detailIntent = new Intent(context, DetailActivity.class);
        detailIntent.putExtra(TITLE_KEY, title);
        detailIntent.putExtra(IMAGE_KEY, imageResId);
        detailIntent.putExtra(Detail_KEY,detail);
        return detailIntent;
    }

}
