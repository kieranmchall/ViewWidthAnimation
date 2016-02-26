package com.example.kieranhall.activitytransition;

import android.content.res.Resources;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by kieranhall on 25/02/2016.
 */
public class WidthResizeAnimation
        extends Animation {

    private int  startWidth;
    private int  deltaWidth; // distance between start and end width
    private View view;
    private Animation mNextAnimation;

    /**
     * constructor, do not forget to use the setParams(int, int) method before
     * starting the animation
     * @param v
     */
    public WidthResizeAnimation(View v) {
        this.view = v;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {

        view.getLayoutParams().width = (int) (startWidth + deltaWidth * interpolatedTime);
        view.requestLayout();
    }

    /**
     * set the starting and ending width for the resize animation
     * starting width is usually the views current width, the end width is the width
     * we want to reach after the animation is completed
     * @param end width in pixels
     */
    public void setParams(int end) {
        int endInPix = (int)(end * Resources.getSystem().getDisplayMetrics().density);
        this.startWidth = view.getLayoutParams().width;
        deltaWidth = endInPix - startWidth;
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