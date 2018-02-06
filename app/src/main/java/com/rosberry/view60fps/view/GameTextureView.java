package com.rosberry.view60fps.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;

import com.rosberry.view60fps.DrawingThread;
import com.rosberry.view60fps.IComposer;
import com.rosberry.view60fps.SurfaceViewHolder;
import com.rosberry.view60fps.TextureViewHolder;
import com.rosberry.view60fps.model.SceneModelComposer;

/**
 * Created by dmitry on 25.01.2018.
 */

public class GameTextureView extends TextureView
        implements TextureView.SurfaceTextureListener, IComposer {
    private SceneModelComposer sceneComposer;

    private DrawingThread drawingThread;

    public GameTextureView(Context context) {
        super(context);
        setSurfaceTextureListener(this);
    }


    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        drawingThread = new DrawingThread(new TextureViewHolder(this));
        drawingThread.setRunning(true);
        drawingThread.start();
        drawingThread.setSceneComposer(sceneComposer);

    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
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
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

    }

    @Override
    public void setComposer(SceneModelComposer modelComposer) {
        sceneComposer = modelComposer;
        if (drawingThread != null) drawingThread.setRunning(false);
    }

    @Override
    public void invalidate() {
        super.invalidate();
    }
}
