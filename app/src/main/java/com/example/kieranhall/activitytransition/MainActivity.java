package com.example.kieranhall.activitytransition;

import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.widget.RelativeLayout;

public class MainActivity
        extends AppCompatActivity {

    View pinkView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pinkView = findViewById(R.id.pinkView);
        pinkView.setClickable(true);

        final HeightResizeAnimation heightResizeAnimation = new HeightResizeAnimation(pinkView);
        heightResizeAnimation.setDuration(300);
        heightResizeAnimation.setParams(414);
        heightResizeAnimation.setInterpolator(new AccelerateInterpolator());
        heightResizeAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        final WidthResizeAnimation widthResizeAnimation = new WidthResizeAnimation(pinkView);
        widthResizeAnimation.setDuration(200);
        widthResizeAnimation.setParams(356);
        widthResizeAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        widthResizeAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                pinkView.startAnimation(heightResizeAnimation);
                pinkView.setBackground(getDrawable(R.drawable.countries_list));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        pinkView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pinkView.startAnimation(widthResizeAnimation);
            }
        });
    }
}
