package com.example.guzellikappp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guzellikappp.Models.YuzMaskesi;

public class icerik extends AppCompatActivity {

    TextView txtBaslik, Etkisi, txtCiltTipi, txtHazirla;
    ImageView imgyuz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icerik);
        txtBaslik = findViewById(R.id.baslik);
        imgyuz = findViewById(R.id.image);
        txtCiltTipi = findViewById(R.id.ciltTipi);
        txtHazirla=findViewById(R.id.hazirla);
        //if you have a TextView, for example...
        YuzMaskesi data = (YuzMaskesi) getIntent().getExtras().getSerializable("YuzMaskesi");
        txtBaslik.setText(data.getBaslik());
        imgyuz.setImageResource(data.getImageID());
      
        txtCiltTipi.setText(data.getCiltTipi());
        txtHazirla.setText(data.getHazirlanisi());
//     
    }


}
