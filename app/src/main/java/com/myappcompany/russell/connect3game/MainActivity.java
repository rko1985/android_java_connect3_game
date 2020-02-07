package com.myappcompany.russell.connect3game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0; //0 for yellow 1 for red

    public void dropIn(View view){

        ImageView counter = (ImageView) view; //finding the piece that is going to drop from view
        counter.setTranslationY(-1500); //move off the screen
        if(activePlayer == 0) {
            counter.setImageResource(R.drawable.yellow); //set image to yellow counter
            activePlayer = 1; // set to red
        } else {
            counter.setImageResource(R.drawable.red); //set imag
            activePlayer = 0;
        }

        counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
