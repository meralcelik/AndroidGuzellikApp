package com.example.guzellikappp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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
        Button button = (Button)findViewById(R.id.button);
        txthazirlasac=findViewById(R.id.hazirlasac);
        SacMaskesi data = (SacMaskesi) getIntent().getExtras().getSerializable("SacMaskesi");
        imgsac.setImageResource(data.getImageID());
        txtSacBaslik.setText(data.getBaslik());
        txtSacmalzeme.setText(data.getMalzemeler());
        txthazirlasac.setText(data.getHazirlanisi());
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(icerikSac.this.txtSacBaslik.getText().toString());
                stringBuilder.append("Uygulamadan gönderildi \n www.meralcelik.com");
                String str = stringBuilder.toString();
                icerikSac.this.shareMyMessage(str);
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

