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
import com.example.guzellikappp.Models.ElMaskesi;
import com.example.guzellikappp.R;
import com.example.guzellikappp.icerikEl;

import java.util.ArrayList;

public class ElMaskesiAdapter extends RecyclerView.Adapter<ElMaskesiAdapter.MyViewHolder> {
    ArrayList<ElMaskesi> mDataList;

    Context context;

    public ElMaskesiAdapter(Context c) {
        this.context = c;
        mDataList = new ArrayList<>();
        Resources kaynak = c.getResources();
        int resimler[] = {R.drawable.zeytinyag, R.drawable.limon, R.drawable.patate,
                R.drawable.yumurtae, R.drawable.gule, R.drawable.avakado,
                R.drawable.yulaf, R.drawable.muz, R.drawable.salatalik,
                R.drawable.sirke, R.drawable.papa,
                R.drawable.kile, R.drawable.sute

        };
        String[] basliklar = kaynak.getStringArray(R.array.Ebaslik);
 
        String[]malzemeler=kaynak.getStringArray(R.array.malzemeler);
        String[] hazirlanisi=kaynak.getStringArray(R.array.hazirlanisiEl);
        for (int i = 0; i < resimler.length; i++) {

            ElMaskesi gecici = new ElMaskesi();
            gecici.setImageID(resimler[i]);
            gecici.setBaslik(basliklar[i]);
            gecici.setMalzemeler(malzemeler[i]);
            gecici.setHazirlanisi(hazirlanisi[i]);
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

        ElMaskesi tiklanilanElMaskesi = mDataList.get(position);
        holder.setData(tiklanilanElMaskesi, position);
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {

                if (isLongClick)
                    Toast.makeText(context, "fffff", Toast.LENGTH_SHORT).show();

                else {
                    Intent i = new Intent(context, icerikEl.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("ElMaskesi", mDataList.get(position));
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
        TextView mElMaskesiBaslik;
        ImageView mImageView;
        private ItemClickListener itemClickListener;


        public MyViewHolder(View itemView) {
            super(itemView);

            mElMaskesiBaslik = itemView.findViewById(R.id.text);
            mImageView = itemView.findViewById(R.id.image);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setData(ElMaskesi tiklanilanElMaskesi, int position) {
            this.mElMaskesiBaslik.setText(tiklanilanElMaskesi.getBaslik());
            this.mImageView.setImageResource(tiklanilanElMaskesi.getImageID());
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
