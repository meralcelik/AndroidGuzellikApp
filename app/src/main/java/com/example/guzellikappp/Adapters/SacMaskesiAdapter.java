package com.example.guzellikappp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.guzellikappp.ItemClickListener;
import com.example.guzellikappp.Models.SacMaskesi;
import com.example.guzellikappp.R;
import com.example.guzellikappp.icerikSac;

import java.util.ArrayList;

public class SacMaskesiAdapter extends RecyclerView.Adapter<SacMaskesiAdapter.MyViewHolder> {
    ArrayList<SacMaskesi> mDataList;
    LayoutInflater inflater;
    Context context;
    public SacMaskesiAdapter(Context c) {
        //  inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //  inflater = LayoutInflater.from(context);
        this.context = c;
        mDataList = new ArrayList<>();
        Resources kaynak = c.getResources();
        int[] resimler = {
                R.drawable.portakal, R.drawable.muz,
                R.drawable.bal, R.drawable.zeytinyag, R.drawable.hindistan, R.drawable.bal, R.drawable.kina, R.drawable.mersin, R.drawable.turp,
                R.drawable.zeytinyag, R.drawable.aleovera, R.drawable.sute, R.drawable.cayagaci, R.drawable.zeytinyag,

        };
        String[] basliklar = kaynak.getStringArray(R.array.sacbaslik);
        String[] malzeme = kaynak.getStringArray(R.array.sacmalzeme);
        String[] hazirla= kaynak.getStringArray(R.array.sachazirlama);


        for (int i = 0; i < resimler.length; i++) {
            SacMaskesi gecici = new SacMaskesi();
            gecici.setImageID(resimler[i]);
            gecici.setBaslik(basliklar[i]);
            gecici.setMalzeme(malzeme[i]);
            gecici.setHazirlanisi(hazirla[i]);

            mDataList.add(gecici);
        }

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //elemanlar için inflater yapacak
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;


    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //tıklanilan ogenin pozisyonunu tutan metott

        SacMaskesi tiklanilanSacMaskesi = mDataList.get(position);
        holder.setData(tiklanilanSacMaskesi, position);
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {

                if (isLongClick)
                    Toast.makeText(context, "fffff", Toast.LENGTH_SHORT).show();
                else {
                    Intent i = new Intent(context, icerikSac.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("SacMaskesi", mDataList.get(position));
                    i.putExtras(bundle);
                    context.startActivity(i);
                    //    Toast.makeText(context, "long meralll" + mDataList.get(position), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        TextView mSacMaskesiBaslik;
        ImageView mImageView;
        private ItemClickListener itemClickListener;


        public MyViewHolder(View itemView) {
            super(itemView);

            mSacMaskesiBaslik = itemView.findViewById(R.id.text);
            mImageView = itemView.findViewById(R.id.image);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setData(SacMaskesi tiklanilanSacMaskesi, int position) {
            this.mSacMaskesiBaslik.setText(tiklanilanSacMaskesi.getBaslik());
            this.mImageView.setImageResource(tiklanilanSacMaskesi.getImageID());
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;

        }

        @Override
        public void onClick(View v) {

            itemClickListener.onClick(v, getAdapterPosition(), false);
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), true);
            return true;
        }
    }


}
