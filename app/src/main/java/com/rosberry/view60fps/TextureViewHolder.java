package com.rosberry.view60fps;

import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.TextureView;

/**
 * Created by dmitry on 25.01.2018.
 */

public class TextureViewHolder implements ISurfaceHolder {

    private final TextureView textureView;

    public TextureViewHolder(TextureView textureView) {
        this.textureView = textureView;
    }

    @Override
    public void unlockCanvasAndPost(Canvas canvas) {
        textureView.unlockCanvasAndPost(canvas);
    }

    @Override
    public Canvas lockCanvas() {
        return textureView.lockCanvas();
    }
}
