package com.example.my_application;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pembayaran extends AppCompatActivity {

    TextView totalHarga;
    SharedPreferences preferences;
    public static final String  SHAREDPREF = "mySharedPref";
    public static final String  HARGA_KEY = "totalharga";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);

        totalHarga = findViewById(R.id.totlBayar);

        preferences = getSharedPreferences(SHAREDPREF,MODE_PRIVATE);
        String totalBayar = preferences.getString(HARGA_KEY, null);
        totalHarga.setText("Rp. "+totalBayar+",00");

        findViewById(R.id.bayarduls).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        preferences = getSharedPreferences(SHAREDPREF,MODE_PRIVATE);
        String pembayaran = preferences.getString(HARGA_KEY,null);
//        totalHarga.setText("Rp. "+pembayaran);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);

        dialogBuilder.setTitle("Melakukan Transaksi!");

        dialogBuilder.setMessage("Rp. " + pembayaran+",00").setIcon(R.mipmap.ic_launcher).setCancelable(false).setPositiveButton("Oke", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                preferences = getSharedPreferences(SHAREDPREF,MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(HARGA_KEY,"0");
                editor.commit();
                String total_bayar = preferences.getString(HARGA_KEY,null);
                totalHarga.setText("Rp. "+total_bayar);
//                Pembayaran.this.finish();
            }
        }).setNegativeButton("Jangan", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

    public void reset(View view) {
        preferences = getSharedPreferences(SHAREDPREF,MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(HARGA_KEY,"0");
        editor.commit();
        String total_bayar = preferences.getString(HARGA_KEY,null);
        totalHarga.setText("Rp. "+total_bayar);
    }

    public void back(View view) {
        Intent intent = new Intent(Pembayaran.this,MainActivity.class);
        startActivity(intent);
    }
}