package com.example.guzellikappp.fragmentler;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guzellikappp.Adapters.YuzMaskesiAdapter;
import com.example.guzellikappp.R;


public class FragmentYuz extends Fragment {



    RecyclerView recyclerView;




    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View  view = inflater.inflate(R.layout.fragment_yuz,container,false);

        recyclerView =view.findViewById(R.id.recy);
        YuzMaskesiAdapter adapter=new YuzMaskesiAdapter(getActivity());
        //B UNESNEYİ OLIŞTURDUĞUMDA yuzadapterindeki consrakçır çalışacakk
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);



        return view;
    }


}
