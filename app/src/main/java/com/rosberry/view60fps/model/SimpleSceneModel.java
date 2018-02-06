package com.rosberry.view60fps.model;

import android.graphics.Rect;

import com.rosberry.view60fps.IScene;

/**
 * Created by dmitry on 29.01.2018.
 */

public class SimpleSceneModel implements IScene {

    private final int size = 10;
    private RectShape rectShape = new RectShape(new Rect(0, 0, size , size), 1);

    public void change(int value){

        rectShape.rect.left = 0;
        rectShape.rect.top = 0;
        rectShape.rect.right = size * value;
        rectShape.rect.bottom = size * value;

    }

    public void add(SceneFrame sceneFrame) {
        sceneFrame.shapes.clear();
        sceneFrame.shapes.add(rectShape);
    }
}
