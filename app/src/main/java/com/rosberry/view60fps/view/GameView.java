package com.rosberry.view60fps.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.rosberry.view60fps.IComposer;
import com.rosberry.view60fps.model.SceneModelComposer;

/**
 * Created by dmitry on 25.01.2018.
 */

public class GameView extends View implements IComposer {

    private SceneModelComposer sceneComposer;

    public GameView(Context context) {
        super(context);
    }

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setSceneComposer(SceneModelComposer sceneComposer){
        this.sceneComposer = sceneComposer;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (canvas != null && sceneComposer != null) sceneComposer.drawOn(canvas);
    }

    @Override
    public void setComposer(SceneModelComposer modelComposer) {
        this.sceneComposer = modelComposer;
    }
}
