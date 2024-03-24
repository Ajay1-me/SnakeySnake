package com.example.snakeysnake;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

public class SnakeActivity extends Activity implements SnakeEngineManager{

    // Declare an instance of SnakeGame
    SnakeGame mSnakeGame;

    // Set the game up
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the pixel dimensions of the screen
        Display display = getWindowManager().getDefaultDisplay();

        // Initialize the result into a Point object
        Point size = new Point();
        display.getSize(size);

        // Create a new instance of the SnakeEngine class
        mSnakeGame = new SnakeGame(this, size);

        // Make snakeEngine the view of the Activity
        setContentView(mSnakeGame);
    }




    /*
    Changed the onResume and onPause methods to public from protected. What are the implications?
    */




    // Start the thread in snakeEngine
    @Override
    public void onResume() {
        super.onResume();
        mSnakeGame.onResume();
    }

    // Stop the thread in snakeEngine
    @Override
    public void onPause() {
        super.onPause();
        mSnakeGame.onPause();
    }
}