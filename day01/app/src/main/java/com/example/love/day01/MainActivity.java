package com.example.love.day01;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView mMainImage;
    private TextView mMainText;
    private int count = 5;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                if (count > 1) {
                    mMainText.setText(--count + "");
                    handler.sendEmptyMessageDelayed(1, 1000);
                } else {
                    startActivity(new Intent(MainActivity.this, Main2Activity.class));

                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    @SuppressLint("ObjectAnimatorBinding")
    private void initview() {
        mMainImage = findViewById(R.id.main_image);
        mMainText = findViewById(R.id.main_text);

        //渐变
        ObjectAnimator alpha = ObjectAnimator.ofFloat(mMainImage, "alpha", 0, 1);
        //平移
        ObjectAnimator translationX = ObjectAnimator.ofFloat(mMainImage, "translationX", 0, 200);
        ObjectAnimator translationY = ObjectAnimator.ofFloat(mMainImage, "translationY", 0, 500);
        //缩放
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(mMainImage, "scaleX", 0, 2);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(mMainImage, "scaleY", 0, 2);
        //旋转
        ObjectAnimator rotation = ObjectAnimator.ofFloat(mMainImage, "rotation", 0, 360);
        //设置动画的对象
        AnimatorSet set = new AnimatorSet();
        set.setDuration(5000);
        set.play(alpha).with(translationX).with(translationY).with(scaleX).with(scaleY).with(rotation);
        set.start();
        handler.sendEmptyMessageDelayed(1, 1000);
    }
}
