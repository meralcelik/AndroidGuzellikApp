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
import com.example.guzellikappp.Models.AyakMaskesi;
import com.example.guzellikappp.R;
import com.example.guzellikappp.icerikAyak;

import java.util.ArrayList;

public class AyakMaskesiAdapter extends RecyclerView.Adapter<AyakMaskesiAdapter.MyViewHolder> {
    ArrayList<AyakMaskesi> mDataList;
    LayoutInflater inflater;
    Context context;

    public AyakMaskesiAdapter(Context c) {
        //  inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //  inflater = LayoutInflater.from(context);
        this.context = c;
        mDataList = new ArrayList<>();
        Resources kaynak = c.getResources();
        int[] resimler = {
                R.drawable.zeytinyag, R.drawable.muz,
                R.drawable.limon, R.drawable.balmumu, R.drawable.bal, R.drawable.pririncunu, R.drawable.zeytinyag, R.drawable.yulaf, R.drawable.susamyag,
                R.drawable.hindistan, R.drawable.listerine, R.drawable.kabartma, R.drawable.sirke, R.drawable.epsom,
                R.drawable.aleovera
        };
        String[] basliklar = kaynak.getStringArray(R.array.AyakBaslik);
        String[] malzemeler = kaynak.getStringArray(R.array.AyakMalzemeler);
       
        String[] hazirlama = kaynak.getStringArray(R.array.AyakHazirlanisi);

        for (int i = 0; i < resimler.length; i++) {
            AyakMaskesi gecici = new AyakMaskesi();
            gecici.setImageID(resimler[i]);
            gecici.setBaslik(basliklar[i]);
            gecici.setMalzemeler(malzemeler[i]);
//            gecici.setCiltTipi(ciltTipi[i]);
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

        AyakMaskesi tiklanilanAyakMaskesi = mDataList.get(position);
        holder.setData(tiklanilanAyakMaskesi, position);
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {

                if (isLongClick)
                    Toast.makeText(context, "fffff", Toast.LENGTH_SHORT).show();

                else {
                    Intent i = new Intent(context, icerikAyak.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("AyakMaskesi", mDataList.get(position));
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
        TextView mAyakMaskesiBaslik;
        ImageView mImageView;
        private ItemClickListener itemClickListener;


        public MyViewHolder(View itemView) {
            super(itemView);

            mAyakMaskesiBaslik = itemView.findViewById(R.id.text);
            mImageView = itemView.findViewById(R.id.image);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setData(AyakMaskesi tiklanilanAyakMaskesi, int position) {
            this.mAyakMaskesiBaslik.setText(tiklanilanAyakMaskesi.getBaslik());
            this.mImageView.setImageResource(tiklanilanAyakMaskesi.getImageID());
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
