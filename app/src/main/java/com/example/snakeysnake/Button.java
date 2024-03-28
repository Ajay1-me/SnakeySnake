package com.example.snakeysnake;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class Button implements Drawable{
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
