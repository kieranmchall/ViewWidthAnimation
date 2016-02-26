package com.example.kieranhall.activitytransition;

import android.content.res.Resources;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by kieranhall on 25/02/2016.
 */
public class HeightResizeAnimation
        extends Animation {

    private int  startHeight;
    private int  deltaHeight; // distance between start and end height
    private View view;

    /**
     * constructor, do not forget to use the setParams(int, int) method before
     * starting the animation
     * @param v
     */
    public HeightResizeAnimation(View v) {
        this.view = v;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {

        view.getLayoutParams().height = (int) (startHeight + deltaHeight * interpolatedTime);
        view.requestLayout();
    }

    /**
     * set the starting and ending height for the resize animation
     * starting height is usually the views current height, the end height is the height
     * we want to reach after the animation is completed
     * @param end height in pixels
     */
    public void setParams(int end) {
        int endInPix = (int)(end * Resources.getSystem().getDisplayMetrics().density);
        this.startHeight = view.getLayoutParams().height;
        deltaHeight = endInPix - startHeight;
    }

    /**
     * set the duration for the hideshowanimation
     */
    @Override
    public void setDuration(long durationMillis) {
        super.setDuration(durationMillis);
    }

    @Override
    public boolean willChangeBounds() {
        return true;
    }
}