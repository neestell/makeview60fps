package com.rosberry.view60fps.model;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by dmitry on 25.01.2018.
 */

class FillShape extends Shape {

    FillShape(int color) {
        this.color = color;
    }

    @Override
    void draw(Canvas canvas, Paint paint) {
        paint.setColor(color);
        canvas.drawPaint(paint);
    }
}
