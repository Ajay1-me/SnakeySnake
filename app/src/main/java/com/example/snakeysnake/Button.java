package com.example.snakeysnake;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class Button implements Drawable{

    private Point location = new Point();

    // An image to represent the button
    private Bitmap buttonBitmap;

    // Objects for the game loop/thread
    private Thread mThread = null;

    // Is the game currently playing and or paused?
    private volatile boolean mPlaying = false;





    int x = 200;
    int y = 30;

    /// Set up the button in the constructor
    Button(Context context, Point sr, int s, int width, int height){
        // Load the image to the bitmap
        buttonBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.button_pause);
        // Resize the bitmap
        buttonBitmap = Bitmap.createScaledBitmap(buttonBitmap, width, height, false);
    }

    // Draw the apple
    public void draw(Canvas canvas, Paint paint){
        canvas.drawBitmap(buttonBitmap, x, y, paint);

    }

}
