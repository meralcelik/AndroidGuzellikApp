package com.example.guzellikappp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guzellikappp.Models.SacMaskesi;


public class icerikSac extends AppCompatActivity {
    TextView txtSacBaslik,  txtSacmalzeme, txthazirlasac;
    ImageView imgsac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icerik_sac);
        imgsac=findViewById(R.id.imagesac)   ;
        txtSacBaslik=findViewById(R.id.basliksac);
        txtSacmalzeme=findViewById(R.id.sacmalzemeler);
        txthazirlasac=findViewById(R.id.hazirlasac);
        SacMaskesi data = (SacMaskesi) getIntent().getExtras().getSerializable("SacMaskesi");
        imgsac.setImageResource(data.getImageID());
        txtSacBaslik.setText(data.getBaslik());
        txtSacmalzeme.setText(data.getMalzemeler());
        txthazirlasac.setText(data.getHazirlanisi());
    }
}
