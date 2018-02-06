package com.rosberry.view60fps.model;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.rosberry.view60fps.IScene;

import java.util.LinkedList;

/**
 * Created by dmitry on 25.01.2018.
 */

public class SceneModelComposer {

    private LinkedList<SceneFrame> drawnFrames = new LinkedList<>();
    private LinkedList<SceneFrame> bufferedFrames = new LinkedList<>();
    private final Paint paint = new Paint() {

        {
            setStyle(Paint.Style.FILL);
        }
    };
    private final int countFrames = 120;
    private final SceneFrame initialFrame = new SceneFrame() {

        {
            shapes.add(new FillShape(Color.WHITE));
        }

    };

    private IScene sceneModel = null;
    private int value;

    public SceneModelComposer(int widthPixels) {

        sceneModel = new StressSceneModel(widthPixels);

        for (int i = 0; i < countFrames; i++)
            drawnFrames.add(new SceneFrame());
    }

    public synchronized void drawOn(Canvas canvas) {

        synchronized (paint) {
            initialFrame.drawOn(canvas, paint);

            if (bufferedFrames.size() > 0) {

                SceneFrame frame = null;
                boolean keepLastFrame = true;

                if (bufferedFrames.size() > 1) {

                    keepLastFrame = false;
                    frame = bufferedFrames.removeLast();

                } else

                    frame = bufferedFrames.getLast();

                frame.drawOn(canvas, paint);

                if (!keepLastFrame) {
                    drawnFrames.addLast(frame);
                    frame.clear();
                }
            }
        }
    }

    public void changeModel(int value) {
        this.value = value;
        if (drawnFrames.size() == 0)
            return;

        sceneModel.change(value);
        SceneFrame sceneFrame = drawnFrames.removeFirst();
        sceneModel.add(sceneFrame);

        bufferedFrames.addFirst(sceneFrame);

    }

    public void invalidate() {
        changeModel(value);
    }

    public void setSceneModel(IScene sceneModel) {
        this.sceneModel = sceneModel;
    }
}
