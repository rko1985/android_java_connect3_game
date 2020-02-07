package com.myappcompany.russell.connect3game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int[] gameState = {2,2,2,2,2,2,2,2,2}; //0 yellow, 1 red, 2 empty
    int activePlayer = 0; //0 for yellow 1 for red
    int[][] winningPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

    public void dropIn(View view){

        ImageView counter = (ImageView) view; //finding the piece that is going to drop from view
        Log.i("Tag",counter.getTag().toString());
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        gameState[tappedCounter] = activePlayer;
        counter.setTranslationY(-1500); //move off the screen
        if(activePlayer == 0) {
            counter.setImageResource(R.drawable.yellow); //set image to yellow counter
            activePlayer = 1; // set to red
        } else {
            counter.setImageResource(R.drawable.red); //set imag
            activePlayer = 0;
        }

        counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

        //checking if winning position
        for (int[] winningPosition : winningPositions){
            if(gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2){
                //if those conditions are met someone has one
                String winner = "";
                if(activePlayer == 1){
                    winner = "Yellow";
                } else {
                    winner = "Red";
                }
                Toast.makeText(this, winner + " someone has one!", Toast.LENGTH_LONG).show();
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
