package com.example.my_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnNoteListener {


    RecyclerView recyclerView;
    MyAdapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<myModel> data;
    Button reset;

    public TextView harga, totalHarga;
    public int Total_harga_int;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        harga = findViewById(R.id.hargaPaketWisata);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        data = new ArrayList<>();
        for (int i = 0; i<Paket1.nama.length; i++){
            data.add(new myModel(Paket1.gambar[i],
                    Paket1.nama[i],Paket1.harga[i],Paket1.detail[i]));
        }

        myAdapter = new MyAdapter(data, this);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }


    public void onNoteClick(int position) {

        String namaAlbum = data.get(position).getNama();
        String hargaAlbum = data.get(position).getHarga();
        String detailAlbum = data.get(position).getDetail();
        int gambarAlbum = data.get(position).getGambar();

        Intent detailIntent = new Intent(MainActivity.this,DetailActivity.class);
        detailIntent.putExtra(DetailActivity.EXTRA_NAME,namaAlbum);
        detailIntent.putExtra(DetailActivity.EXTRA_DETAIL,detailAlbum);
        detailIntent.putExtra(DetailActivity.EXTRA_HARGA,hargaAlbum);
        detailIntent.putExtra(DetailActivity.EXTRA_IMAGE,gambarAlbum);
        startActivity(detailIntent);
    }


    public void logout(MenuItem item) {
        Intent intent = new Intent(MainActivity.this,Login.class);
        startActivity(intent);
        finish();
    }

    public void onMap(MenuItem item) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String geoLocation =
                "https://www.google.com/maps/place/KB+Aisyiyah+Loboyo/@-6.9201537,109.5219726,3a,90y,175.98h,70.93t/data=!3m6!1e1!3m4!1svWxbj5foN3QmcUvBavcr7w!2e0!7i13312!8i6656!4m9!1m2!2m1!1sLosari+loboyo+Ampelgading,+Pemalang,+Jawa+Tengah!3m5!1s0x2e6fd9c0fdf75a51:0x346d83baa4857a61!8m2!3d-6.9200614!4d109.522117!15sCjBMb3NhcmkgbG9ib3lvIEFtcGVsZ2FkaW5nLCBQZW1hbGFuZywgSmF3YSBUZW5nYWiSAQZzY2hvb2w";
        intent.setData(Uri.parse(geoLocation));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void update(MenuItem item) {
        Intent updateLah = new Intent(MainActivity.this,updateUnP.class);
        startActivity(updateLah);
    }

    public void dialCall(MenuItem item) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        String phoneNumber = "0852643834xx";
        callIntent.setData(Uri.parse("tel:"+ phoneNumber));
        if (callIntent.resolveActivity(getPackageManager()) != null){
            startActivity(callIntent);
        }
    }

    public void smsCenter(MenuItem item) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto: 0852643834xx"));  // This ensures only SMS apps respond
        startActivity(intent);
    }

    public void pembayaran(MenuItem item) {
        Intent pembayaranIntent = new Intent(MainActivity.this,Pembayaran.class);
        startActivity(pembayaranIntent);

    }
}