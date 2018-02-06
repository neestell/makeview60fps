package com.rosberry.view60fps;

import android.graphics.Canvas;

import com.rosberry.view60fps.model.SceneModelComposer;

/**
 * Created by dmitry on 25.01.2018.
 */

public class DrawingThread extends Thread {
    private SceneModelComposer sceneComposer;

    private ISurfaceHolder surfaceHolder;
    private boolean isRunning = false;
    private long previousTime;
    private final int fps = 70;

    public DrawingThread(ISurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;

        previousTime = System.currentTimeMillis();
    }

    public void setRunning(boolean run) {
        isRunning = run;
    }

    @Override
    public void run() {
        Canvas canvas;

        while (isRunning) {

            long currentTimeMillis = System.currentTimeMillis();
            long elapsedTimeMs = currentTimeMillis - previousTime;
            long sleepTimeMs = (long) (1000f/ fps - elapsedTimeMs);

            canvas = null;
            try {

                canvas = surfaceHolder.lockCanvas();

                if (canvas == null) {
                    Thread.sleep(1);

                    continue;

                }else if (sleepTimeMs > 0){

                    Thread.sleep(sleepTimeMs);

                }

                synchronized (surfaceHolder) {
                    sceneComposer.drawOn(canvas);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (canvas != null) {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                    previousTime = System.currentTimeMillis();
                }
            }
        }
    }

    public void setSceneComposer(SceneModelComposer sceneComposer) {
        this.sceneComposer = sceneComposer;
    }
}