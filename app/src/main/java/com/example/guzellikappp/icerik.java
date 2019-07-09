package com.example.guzellikappp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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
        Button button = (Button)findViewById(R.id.button);
        //if you have a TextView, for example...
        YuzMaskesi data = (YuzMaskesi) getIntent().getExtras().getSerializable("YuzMaskesi");
        txtBaslik.setText(data.getBaslik());
        imgyuz.setImageResource(data.getImageID());
        txtCiltTipi.setText(data.getCiltTipi());
        txtHazirla.setText(data.getHazirlanisi());
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(icerik.this.txtBaslik.getText().toString());
                stringBuilder.append("Uygulamadan gönderildi \n www.meralcelik.com");
                String str = stringBuilder.toString();
                icerik.this.shareMyMessage(str);
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



