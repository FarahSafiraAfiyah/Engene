package com.example.my_application;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.PaketViewHolder> {

    ArrayList<myModel> dataItem;
    OnNoteListener mOnNotlistenere;

    @NonNull
    @Override
    public PaketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.paket,parent,false);
        return new PaketViewHolder(view,mOnNotlistenere);

    }

    @Override
    public void onBindViewHolder(@NonNull PaketViewHolder holder, int position) {

        TextView text_nama = holder.textNama;
        TextView text_harga = holder.textHarga;
        ImageView i_gambar = holder.gambar;

        text_nama.setText(dataItem.get(position).getNama());
        text_harga.setText(dataItem.get(position).getHarga());
        i_gambar.setImageResource(dataItem.get(position).getGambar());


    }

    @Override
    public int getItemCount() {

        return dataItem.size();
    }

    public class PaketViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textNama, textHarga;
        ImageView gambar;

        OnNoteListener onNoteListener;
        private OnNoteListener mOnNoteListener;
        public PaketViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            textNama = itemView.findViewById(R.id.title);
            textHarga = itemView.findViewById(R.id.hargaPaketWisata);
            gambar = itemView.findViewById(R.id.paketImages);
            this.onNoteListener = onNoteListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onNoteListener.onNoteClick(getAdapterPosition());

        }
    }
    MyAdapter(ArrayList<myModel> data, OnNoteListener onNoteListener){
        this.dataItem = data;
        this.mOnNotlistenere = onNoteListener;
    }

    public interface OnNoteListener{
        void onNoteClick(int position);
    }
}
