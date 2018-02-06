package com.rosberry.view60fps.model;

import android.graphics.Rect;

import com.rosberry.view60fps.IScene;

/**
 * Created by dmitry on 29.01.2018.
 */

public class StressSceneModel implements IScene{

    private Rect bound = new Rect(0, 0, 50, 50);
    private SceneFrame frame = new SceneFrame();
    private float step;

    public StressSceneModel(int screenWidth) {

        this.step = screenWidth / (float) bound.width();

        for (int i = 0; i < bound.width(); i++) {
            for (int j = 0; j < bound.height(); j++) {
                frame.shapes.add(new RectShape(new Rect(0, 0, 1, 1), 1));
            }
        }

    }

    public void change(int value){

        for (int i = 0; i < bound.width(); i++) {
            for (int j = 0; j < bound.height(); j++) {

                int left = (int) (j * step) + value + 1;
                int right = (int) (left + step) - 1;
                int top = (int) (i * step) + 1;
                int bottom = (int) (top + step) - 1;

                RectShape rectShape = (RectShape) frame.shapes.get(i * bound.width() + j);

                rectShape.rect.left = left;
                rectShape.rect.top = top;
                rectShape.rect.right = right;
                rectShape.rect.bottom = bottom;
            }
        }
    }

    public void add(SceneFrame sceneFrame) {

        sceneFrame.shapes.clear();
        sceneFrame.shapes.addAll(frame.shapes);

    }
}
