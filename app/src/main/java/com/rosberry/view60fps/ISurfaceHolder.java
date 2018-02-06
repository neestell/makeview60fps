package com.rosberry.view60fps;

import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by dmitry on 25.01.2018.
 */

public interface ISurfaceHolder {

    void unlockCanvasAndPost(Canvas canvas);
    Canvas lockCanvas();

}
