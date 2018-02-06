package com.rosberry.view60fps;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Created by dmitry on 25.01.2018.
 */

public class SurfaceViewHolder implements ISurfaceHolder {

    private final SurfaceHolder surfaceHolder;

    public SurfaceViewHolder(SurfaceHolder surfaceHolder){
        this.surfaceHolder = surfaceHolder;
    }

    @Override
    public void unlockCanvasAndPost(Canvas canvas) {
        surfaceHolder.unlockCanvasAndPost(canvas);
    }

    @Override
    public Canvas lockCanvas() {
        return surfaceHolder.lockCanvas();
    }
}
