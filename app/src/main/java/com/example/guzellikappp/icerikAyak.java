package com.example.guzellikappp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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
        Button button = (Button)findViewById(R.id.button);
        imgayak = findViewById(R.id.imageayak);
        AyakMaskesi data = (AyakMaskesi) getIntent().getExtras().getSerializable("AyakMaskesi");
        imgayak.setImageResource(data.getImageID());
        txtBaslik.setText(data.getBaslik());
        txtmalzeme.setText(data.getMalzemeler());
        txthazirlaAyak.setText(data.getHazirlanisi());
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(icerikAyak.this.txtBaslik.getText().toString());
                stringBuilder.append("Uygulamadan gönderildi \n www.meralcelik.com");
                String str = stringBuilder.toString();
                icerikAyak.this.shareMyMessage(str);
            }
        });
    }
    protected void shareMyMessage(String paramString) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        startActivity(intent.putExtra("android.intent.extra.TEXT", paramString).createChooser(intent, "Gönderiyi paylaş !! "));
    }
//
}



