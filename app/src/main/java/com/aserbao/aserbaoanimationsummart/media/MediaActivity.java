package com.aserbao.aserbaoanimationsummart.media;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aserbao.aserbaoanimationsummart.R;
import com.aserbao.aserbaoanimationsummart.media.camera.CameraActivity;
import com.aserbao.aserbaoanimationsummart.media.camera2.Camera2Activity;

public class MediaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
    }
    public void btn_camera(View view) {
        startActivity(new Intent(this, CameraActivity.class));
    }

    public void btn_camera2(View view) {
        startActivity(new Intent(this, Camera2Activity.class));
    }
}
