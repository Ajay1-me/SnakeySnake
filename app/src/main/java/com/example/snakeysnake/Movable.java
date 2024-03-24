package com.example.snakeysnake;

import android.view.MotionEvent;

/*
Created this if we consider future expansion where multiple classes might need a similar reset functionality,
or to adhere to a design principle like the Interface Segregation Principle
 */
public interface Movable {
    void move();
    void switchHeading(MotionEvent motionEvent);
}
