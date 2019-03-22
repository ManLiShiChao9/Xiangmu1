package com.lang.xiangmu.ui.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.lang.xiangmu.R;

public class GuideActivity extends AppCompatActivity {


    private AnimatorSet animatorSet;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 100) {
                Intent intent = new Intent(GuideActivity.this,MainActivity.class);
                startActivity(intent);
            }
        }
    };
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        imageView = findViewById(R.id.yd_img);
        ObjectAnimator objectalpha = ObjectAnimator.ofFloat(imageView,"rotation",0f,360f);
        ObjectAnimator objectAnimatorx =ObjectAnimator.ofFloat(imageView,"translationX",0,500);
        ObjectAnimator objectAnimatory =ObjectAnimator.ofFloat(imageView,"translationY",0,500);
        //创建一个动画集合
        animatorSet = new AnimatorSet();
        animatorSet.play(objectalpha)
                .with(objectAnimatorx)
                .with(objectAnimatory);
        animatorSet.setDuration(5000);
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Message message = new Message();
                message.what=100;
                handler.sendMessage(message);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }
}

