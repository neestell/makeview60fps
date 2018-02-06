package com.rosberry.view60fps.model;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by dmitry on 25.01.2018.
 */

public abstract class Shape {
    protected int color;

    abstract void draw(Canvas canvas, Paint paint);
}
