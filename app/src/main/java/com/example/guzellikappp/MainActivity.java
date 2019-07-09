package com.example.guzellikappp;


import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView image =  findViewById(R.id.image);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        WindowManager wm = window.getWindowManager();
        Display ekran = wm.getDefaultDisplay();

        Point point = new Point();
        ekran.getSize(point);
//
        int genislik = point.x;
        int yukseklik = point.y;

        //1.78 en boy oranı
        image.getLayoutParams().width = (int) (yukseklik *8.78);
     //   image.getLayoutParams().height = (int) (genislik * 3.35);

//        ObjectAnimator animator = ObjectAnimator.ofFloat(image, "x", 0, -(yukseklik * 1.78f - genislik), 0, -(yukseklik * 1.78f - genislik));
//        animator.setDuration(210000);
//        animator.setInterpolator(new LinearInterpolator());
//        animator.start();


  }

    public void Bakim(View view) {
        Intent i=new Intent(this,Bakim.class);
        startActivity(i);
    }
}