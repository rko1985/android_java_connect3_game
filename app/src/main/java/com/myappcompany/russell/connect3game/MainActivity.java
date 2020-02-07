package com.myappcompany.russell.connect3game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void dropIn(View view){

        ImageView counter = (ImageView) view; //finding the piece that is going to drop from view
        counter.setTranslationY(-1500); //move off the screen
        counter.setImageResource(R.drawable.yellow); //set image to yellow counter
        counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
