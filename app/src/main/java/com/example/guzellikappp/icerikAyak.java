package com.example.guzellikappp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guzellikappp.Models.AyakMaskesi;


public class icerikAyak extends AppCompatActivity {
    TextView txtBaslik, txtAmaske, txtmalzeme, txthazirlaAyak;
    ImageView imgayak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icerik_ayak);
        txtBaslik = findViewById(R.id.baslikAyak);
        txtmalzeme = findViewById(R.id.Ayakmalzemeler);
        txthazirlaAyak = findViewById(R.id.hazirlaAyak);
        imgayak = findViewById(R.id.imageayak);
        AyakMaskesi data = (AyakMaskesi) getIntent().getExtras().getSerializable("AyakMaskesi");
        imgayak.setImageResource(data.getImageID());
        txtBaslik.setText(data.getBaslik());
        txtmalzeme.setText(data.getMalzemeler());
        txthazirlaAyak.setText(data.getHazirlanisi());
    }
}
