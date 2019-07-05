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
import com.example.guzellikappp.Models.YuzMaskesi;
import com.example.guzellikappp.R;
import com.example.guzellikappp.icerik;

import java.util.ArrayList;

public class YuzMaskesiAdapter extends RecyclerView.Adapter<YuzMaskesiAdapter.MyViewHolder> {

    ArrayList<YuzMaskesi> mDataList;
    LayoutInflater inflater;
    Context context;
    public YuzMaskesiAdapter(Context c) {
        //  inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //  inflater = LayoutInflater.from(context);
        this.context = c;
        mDataList = new ArrayList<>();
        Resources kaynak = c.getResources();
        int[] resimler = {
                R.drawable.muz, R.drawable.sirke,
                R.drawable.sut, R.drawable.yogurt, R.drawable.limon, R.drawable.avakado, R.drawable.balmuz, R.drawable.salatalik, R.drawable.nar,
                R.drawable.cayagaci, R.drawable.bal, R.drawable.zeytin, R.drawable.cay, R.drawable.zeytinyag,
                R.drawable.soda
        };
        String[] basliklar = kaynak.getStringArray(R.array.baslik);
        String[] Etkisi = kaynak.getStringArray(R.array.Etki);
        String[] ciltTipi = kaynak.getStringArray(R.array.ciltTip);
        String[] hazirlama = kaynak.getStringArray(R.array.hazirla);

        for (int i = 0; i < resimler.length; i++) {
            YuzMaskesi gecici = new YuzMaskesi();
            gecici.setImageID(resimler[i]);
            gecici.setBaslik(basliklar[i]);
            gecici.setEtkisi(Etkisi[i]);
            gecici.setCiltTipi(ciltTipi[i]);
            gecici.setHazirlanisi(hazirlama[i]);
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

        YuzMaskesi tiklanilanyuzMaskesi = mDataList.get(position);
        holder.setData(tiklanilanyuzMaskesi, position);
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {

                if (isLongClick)
                    Toast.makeText(context, "fffff", Toast.LENGTH_SHORT).show();

                else {
                    Intent i = new Intent(context, icerik.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("YuzMaskesi", mDataList.get(position));
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
        TextView mYuzMaskesiBaslik;
        ImageView mImageView;
        private ItemClickListener itemClickListener;


        public MyViewHolder(View itemView) {
            super(itemView);

            mYuzMaskesiBaslik = itemView.findViewById(R.id.text);
            mImageView = itemView.findViewById(R.id.image);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setData(YuzMaskesi tiklanilanyuzMaskesi, int position) {
            this.mYuzMaskesiBaslik.setText(tiklanilanyuzMaskesi.getBaslik());
            this.mImageView.setImageResource(tiklanilanyuzMaskesi.getImageID());
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
