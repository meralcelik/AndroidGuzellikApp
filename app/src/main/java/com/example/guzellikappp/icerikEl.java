package com.example.guzellikappp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guzellikappp.Models.ElMaskesi;


public class icerikEl extends AppCompatActivity {

    TextView txtBaslik, txtElmaske,txtmalzeme,txthazirlaEl;
    ImageView imgyuz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icerik_el);

        txtBaslik = findViewById(R.id.baslikEl);
        imgyuz = findViewById(R.id.imageEl);
    
        txtmalzeme=findViewById(R.id.Elmalzemeler);
        txthazirlaEl=findViewById(R.id.hazirlaEl);

        ElMaskesi data = (ElMaskesi) getIntent().getExtras().getSerializable("ElMaskesi");
        imgyuz.setImageResource(data.getImageID());

        txtBaslik.setText(data.getBaslik());
      
        txtmalzeme.setText(data.getMalzemeler());
        txthazirlaEl.setText(data.getHazirlanisi());
    }
}
