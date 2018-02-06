package com.rosberry.view60fps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import com.rosberry.view60fps.model.SceneModelComposer;
import com.rosberry.view60fps.model.SimpleSceneModel;
import com.rosberry.view60fps.model.StressSceneModel;
import com.rosberry.view60fps.view.GameSurfaceView;
import com.rosberry.view60fps.view.GameTextureView;
import com.rosberry.view60fps.view.GameView;
import com.rosberry.view60fps.view.SquareFrameLayout;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener,
                                                               CompoundButton.OnCheckedChangeListener,
                                                               RadioGroup.OnCheckedChangeListener {

    SquareFrameLayout continer;
    SceneModelComposer sceneModelComposer;
    IComposer gameView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        continer = findViewById(R.id.viewContainer);
        SeekBar seekBar = findViewById(R.id.seekbarSceneModel);
        seekBar.setOnSeekBarChangeListener(this);
        ((RadioGroup)findViewById(R.id.radio_group_views)).setOnCheckedChangeListener(this);
        ((CheckBox) findViewById(R.id.checkbox_ha)).setOnCheckedChangeListener(this);
        ((CheckBox) findViewById(R.id.checkbox_mode)).setOnCheckedChangeListener(this);
        sceneModelComposer = new SceneModelComposer(getResources().getDisplayMetrics().widthPixels);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.viewCanvas:
                gameView = new GameView(this);
                break;
            case R.id.surfaceViewCanvas:
                gameView = new GameSurfaceView(this);
                break;
            case R.id.textureViewCanvas:
                gameView = new GameTextureView(this);
                break;
        }
        gameView.setComposer(sceneModelComposer);

        continer.removeAllViews();
        continer.addView((View) gameView);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (gameView != null ) {
            if (buttonView.getId() == R.id.checkbox_ha)
                if (isChecked) {
                    ((View) gameView).setLayerType(View.LAYER_TYPE_HARDWARE, null);
                } else {
                    ((View) gameView).setLayerType(View.LAYER_TYPE_SOFTWARE, null);
                }
            if (buttonView.getId() == R.id.checkbox_mode)
                if (isChecked) {
                    sceneModelComposer.setSceneModel(new StressSceneModel(getResources().getDisplayMetrics().widthPixels));
                } else {
                    sceneModelComposer.setSceneModel(new SimpleSceneModel());
                }
            ((View)gameView).invalidate();
            sceneModelComposer.invalidate();
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        sceneModelComposer.changeModel(progress);
        if (continer.getChildCount() > 0) {
            continer.getChildAt(0).invalidate();
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


}
