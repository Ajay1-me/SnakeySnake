package com.example.snakeysnake;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
public class YellowApple extends Apple{

    YellowApple(Context context, Point sr, int s) {
        super(context, sr, s);
        // Load the green apple image
        mBitmapApple = BitmapFactory.decodeResource(context.getResources(), R.drawable.apple);
        // Resize the bitmap
        mBitmapApple = Bitmap.createScaledBitmap(mBitmapApple, s, s, false);
    }

    // Override the draw method to draw a yellow apple
    @Override
    public void draw(Canvas canvas, Paint paint) {
        // Set the paint color to yellow
        paint.setColor(Color.YELLOW);
        // Draw the yellow apple
        canvas.drawBitmap(mBitmapApple, location.x * mSize, location.y * mSize, paint);
    }
}
