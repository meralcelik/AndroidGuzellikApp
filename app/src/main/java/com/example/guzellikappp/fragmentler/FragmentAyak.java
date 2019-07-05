package com.example.guzellikappp.fragmentler;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guzellikappp.Adapters.AyakMaskesiAdapter;
import com.example.guzellikappp.R;


public class FragmentAyak  extends Fragment {

    RecyclerView recyclerView;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view = inflater.inflate(R.layout.fragment_ayak,container,false);


        recyclerView =view.findViewById(R.id.recy);
        AyakMaskesiAdapter adapter=new AyakMaskesiAdapter(getActivity());
        //B UNESNEYİ OLIŞTURDUĞUMDA yuzadapterindeki consrakçır çalışacakk
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);



        return view;
    }
}
