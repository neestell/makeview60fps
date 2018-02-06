package com.rosberry.view60fps.model;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by dmitry on 25.01.2018.
 */

public class RectShape extends Shape {

    private final int strokeWidth;
    final Rect rect;

    RectShape(Rect rect, int strokeWidth) {
        this.rect = rect;
        this.strokeWidth = strokeWidth;
        this.color = Color.BLACK;

    }

    @Override
    void draw(Canvas canvas, Paint paint) {
        paint.setColor(color);
        paint.setStrokeWidth(strokeWidth);

        canvas.drawRect(rect, paint);
    }
}
