package com.example.my_application;

import static android.view.LayoutInflater.from;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnItemClick;

//public class AdapterRcyclerView extends RecyclerView.Adapter<AdapterRcyclerView.ViewHolder> {
//    ArrayList<myModel> dataItem;
//    OnNoteListener mOnNoteListener;
//    OnItemClick mOnItemClick;
//
//    Context mContext;
//    GradientDrawable mGradientDrawable;
//
////    static final String TITLE_KEY = "Title";
////    static final String IMAGE_KEY = "Image Resource";
//    AdapterRcyclerView(Context context,ArrayList<myModel> paketData){
//        this.dataItem = paketData;
//        this.mContext = context;
//
//        mGradientDrawable = new GradientDrawable();
//        mGradientDrawable.setColor(Color.GRAY);
//
//        Drawable drawable = ContextCompat.getDrawable(mContext,R.drawable.pw2);
//        if (drawable !=null){
//            mGradientDrawable.setSize(drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
//        }
//    }
//
////    public AdapterRcyclerView(ArrayList<myModel> data, DetailActivity detailActivity) {
////    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
////        View view = mContext,LayoutInflater.from(mContext).inflate(R.layout.paket,parent,false)
////        return new ViewHolder(view,mGradientDrawable,mOnNoteListener,mOnItemClick);
//
//        return new ViewHolder(mContext,LayoutInflater.from(mContext).inflate(R.layout.paket,parent,false),mGradientDrawable,mOnNoteListener,mOnItemClick);
//
////        View view =mContext,LayoutInflater.from(parent.getContext()).inflate(R.layout.paket,parent,false);
////        return new ViewHolder(view,mOnNoteListener,mOnItemClick);
//    }
//    @Override
//    public void onBindViewHolder(@NonNull AdapterRcyclerView.ViewHolder
//                                         holder, int position) {
//        TextView text_nama = holder.textNama;
//        TextView text_harga = holder.textHarga;
//        ImageView i_gambar = holder.gambar;
//        myModel currentPaket = dataItem.get(position);
//        holder.bindTo(currentPaket);
//        text_nama.setText(dataItem.get(position).getNama());
//        text_harga.setText("RP."+dataItem.get(position).getHarga());
//        i_gambar.setImageResource(dataItem.get(position).getGambar());
//        text_nama.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Intent intent = new Intent(view.getContext(),DetailActivity.class);
////                view.getContext().startActivity(intent);
//                Intent detailIntent = myModel.starter(mContext,currentPaket.getNama(),currentPaket.getGambar(),currentPaket.getDetail());
//                view.getContext().startActivity(detailIntent);
//            }
//        });
//    }
//    @Override
//    public int getItemCount() {
//        return dataItem.size();
//    }
//
//
//    public class ViewHolder extends RecyclerView.ViewHolder implements
//            View.OnClickListener {
//
//        TextView textNama;
//        TextView textHarga;
//        TextView textDetail;
//        ImageView gambar;
//        Context mContext;
//        myModel mCurrentPaket;
//        GradientDrawable mGradientDrawable;
//        OnNoteListener onNoteListener;
//        OnItemClick onItemClick;
//
//        private OnNoteListener mOnNoteListener;
//
////        public ViewHolder(Context context,GradientDrawable gradientDrawable,View itemView, OnNoteListener onNoteListener, OnItemClick onItemClick) {
////            super(itemView);
////            gambar = itemView.findViewById(R.id.paketImages);
////            textNama = itemView.findViewById(R.id.title);
////            textHarga = itemView.findViewById(R.id.hargaPaketWisata);
////            textDetail =itemView.findViewById(R.id.subNewsTitleDetail);
////
////            mContext = context;
////            mGradientDrawable = gradientDrawable;
////
////            this.onNoteListener = onNoteListener;
////            this.onItemClick = onItemClick;
////
////            itemView.setOnClickListener(this);
////        }
//
//        public ViewHolder(Context context, View itemView, GradientDrawable gradientDrawable, OnNoteListener onNoteListener, OnItemClick onItemClick) {
//            super(itemView);
//            gambar = itemView.findViewById(R.id.paketImages);
//            textNama = itemView.findViewById(R.id.title);
//            textHarga = itemView.findViewById(R.id.hargaPaketWisata);
//            textDetail =itemView.findViewById(R.id.subNewsTitleDetail);
//
//            mContext = context;
//            mGradientDrawable = gradientDrawable;
//
//            this.onNoteListener = onNoteListener;
//            this.onItemClick = onItemClick;
//
//            itemView.setOnClickListener(this);
//        }
//
////        public ViewHolder(Context mContext, View inflate, OnNoteListener mOnNoteListener, OnItemClick mOnItemClick) {
////            super();
////        }
//
//        void bindTo(myModel currentPaket){
//
//            mCurrentPaket = currentPaket;
////            textDetail.setText(currentPaket.getDetail());
////            Glide.with(mContext).load(currentPaket.getGambar()).placeholder(mGradientDrawable).into(gambar);
//        }
//
//        @Override
//        public void onClick(View view) {
//            if (view.getId() != R.id.paketImages){
//                onNoteListener.onNoteClick(getAdapterPosition());
//            }else if (view.getId() !=R.id.title){
//                if (onItemClick != null){
//                    onItemClick.onItemClick(getAdapterPosition());
//                }
//            }
//        }
//
////        public ViewHolder(@NonNull View itemView, OnNoteListener
////                onNoteListener) {
////            super(itemView);
////
////            gambar = itemView.findViewById(R.id.paketImages);
////            textNama = itemView.findViewById(R.id.title);
////            textHarga = itemView.findViewById(R.id.subTitle);
////            this.onNoteListener = onNoteListener;
////            itemView.setOnClickListener(this);
////        }
////
////        @Override
////        public void onClick(View view) {
////            onNoteListener.onNoteClick(getAdapterPosition());
////
////        }
//    }
//
//    AdapterRcyclerView(ArrayList<myModel> data, OnNoteListener
//            onNoteListener){
//        this.dataItem = data;
//        this.mOnNoteListener = onNoteListener;
//    }
//    public interface OnNoteListener{
//        void onNoteClick(int position);
//
//    }
//    public  interface OnItemClick{
//        void onItemClick(int position);
//    }
//}
