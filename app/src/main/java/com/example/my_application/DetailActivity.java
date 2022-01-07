package com.example.my_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    public static final String SHAREDPREF = "mySharedPref";
    public static final String EXTRA_NAME = "namaAlbum";
    public static final String EXTRA_HARGA = "hargaAlbum";
    public static final String EXTRA_DETAIL = "detailAlbum";
    public static final String EXTRA_IMAGE = "gambarAlbum";
    public static final String HARGA_KEY = "totalharga";
    public int Total_harga_int;
    private int jumlah = 0;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView titleDetail = findViewById(R.id.titleDetail);
        ImageView image = findViewById(R.id.imageDetail);
        TextView harga = findViewById(R.id.hargaDetail);
        TextView nama = findViewById(R.id.namaTitle);
        Button beli = findViewById(R.id.beliDetail);

        String mNama = getIntent().getStringExtra(EXTRA_NAME);
        String mHarga = getIntent().getStringExtra(EXTRA_HARGA);
        String mDetail = getIntent().getStringExtra(EXTRA_DETAIL);
        int mImage = getIntent().getIntExtra(EXTRA_IMAGE,0);

        titleDetail.setText(mDetail);
        harga.setText("Rp. "+mHarga+" /album");
        nama.setText(mNama);
        image.setImageResource(mImage);

        preferences = getSharedPreferences(SHAREDPREF,MODE_PRIVATE);

        beli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumlah++;
                int i = Integer.parseInt(mHarga);
                Total_harga_int = Total_harga_int + i;
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(HARGA_KEY, String.valueOf(Total_harga_int));
                editor.apply();
                Toast.makeText(DetailActivity.this, "Pesan untuk "+jumlah+" Orang", Toast.LENGTH_SHORT).show();
            }
        });
    }

//    public void beliPaket(View view) {
//        jumlah++;
//        int i = Integer.parseInt(mHarga);
//    }
}