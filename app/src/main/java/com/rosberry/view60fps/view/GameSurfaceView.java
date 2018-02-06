package com.rosberry.view60fps.view;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.rosberry.view60fps.DrawingThread;
import com.rosberry.view60fps.IComposer;
import com.rosberry.view60fps.SurfaceViewHolder;
import com.rosberry.view60fps.model.SceneModelComposer;

/**
 * Created by dmitry on 25.01.2018.
 */

public class GameSurfaceView extends SurfaceView implements SurfaceHolder.Callback, IComposer {
    private SceneModelComposer sceneComposer;

    private DrawingThread drawingThread;

    public GameSurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
        // do something
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        drawingThread = new DrawingThread(new SurfaceViewHolder(holder));
        drawingThread.setRunning(true);
        drawingThread.start();
        drawingThread.setSceneComposer(sceneComposer);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;

        drawingThread.setRunning(false);

        while (retry) {
            try {
                drawingThread.join();
                retry = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setComposer(SceneModelComposer modelComposer) {
        this.sceneComposer = modelComposer;
        if (drawingThread != null) drawingThread.setRunning(false);
    }

    @Override
    public void invalidate() {
        super.invalidate();

    }
}
