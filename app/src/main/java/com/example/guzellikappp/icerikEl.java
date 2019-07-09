package com.example.guzellikappp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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
        Button button = (Button)findViewById(R.id.button);
        txtmalzeme=findViewById(R.id.Elmalzemeler);
        txthazirlaEl=findViewById(R.id.hazirlaEl);

        ElMaskesi data = (ElMaskesi) getIntent().getExtras().getSerializable("ElMaskesi");
        imgyuz.setImageResource(data.getImageID());

        txtBaslik.setText(data.getBaslik());
      
        txtmalzeme.setText(data.getMalzemeler());
        txthazirlaEl.setText(data.getHazirlanisi());
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(icerikEl.this.txtBaslik.getText().toString());
                stringBuilder.append("Uygulamadan gönderildi \n www.meralcelik.com");
                String str = stringBuilder.toString();
                icerikEl.this.shareMyMessage(str);
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

