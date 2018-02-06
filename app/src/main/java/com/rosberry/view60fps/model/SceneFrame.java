package com.rosberry.view60fps.model;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Created by dmitry on 25.01.2018.
 */

public class SceneFrame {

    ArrayList<Shape> shapes = new ArrayList<Shape>();

    void drawOn(Canvas canvas, Paint paint) {
        for (Shape shape : shapes)
            shape.draw(canvas, paint);
    }

    void clear() {
        shapes.clear();
    }
}
