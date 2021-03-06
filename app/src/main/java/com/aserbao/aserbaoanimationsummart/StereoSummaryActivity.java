package com.aserbao.aserbaoanimationsummart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aserbao.aserbaoanimationsummart.stereo_animation.StereoActivity;
import com.aserbao.aserbaoanimationsummart.doubleTouchImageMoveScale.ImageMoveScaleActivity;

public class StereoSummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stereo_summary);
    }

    public void btn_simple_stereo_animation(View view) {
        startActivity(new Intent(this,StereoActivity.class));
    }

    public void btn_image_move_scale(View view) {
        startActivity(new Intent(this,ImageMoveScaleActivity.class));
    }
}
