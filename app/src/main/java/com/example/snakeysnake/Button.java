package com.example.snakeysnake;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;

import java.util.Random;

public class Button {
    // The location of the apple on the grid
    // Not in pixels
    private Point location = new Point();

    // An image to represent the button
    private Bitmap buttonBitmap;
    private Rect buttonRect;

    private boolean isPaused = true;

    // Objects for the game loop/thread
    private Thread mThread = null;

    // Is the game currently playing and or paused?
    private volatile boolean mPlaying = false;


    int x = 200;
    int y = 40;

    /// Set up the apple in the constructor
    Button(Context context, Point sr, int s, int width, int height){
        int buttonWidth = 150; // Adjust but
        // ton width as needed
        int buttonHeight = 130; // Adjust button height as needed
        // Load the image to the bitmap
        buttonBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.button_pause);
        // Resize the bitmap
        buttonBitmap = Bitmap.createScaledBitmap(buttonBitmap, buttonWidth, buttonHeight, false);

        // Set button position (example: center of the screen)
        int buttonX = 20;
        int buttonY = 80;

    }

    // Draw the apple
    public void draw(Canvas canvas, Paint paint){
        canvas.drawBitmap(buttonBitmap, x, y, paint);

    }

    /*
    public boolean onTouchEvent(MotionEvent motionEvent) {


        if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            // Check if touch event occurred within the button bounds
            if (buttonRect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                // Toggle game pause state
                if (isPaused) {
                    // Game paused, perform pause actions
                    pause();
                } else {
                    // Game resumed, perform resume actions
                    resume();
                }
                return true; // Consume touch event
            }
        }

        return true;
    }

     */

    // Stop the thread
    public void pause() {
        mPlaying = false;
        try {
            mThread.join();
        } catch (InterruptedException e) {
            // Error
        }
    }


    // Start the thread
    public void resume() {
        mPlaying = true;
        mThread = new Thread((Runnable) this);
        mThread.start();
    }

}
