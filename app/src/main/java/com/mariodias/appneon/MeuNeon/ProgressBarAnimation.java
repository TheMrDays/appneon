package com.mariodias.appneon.MeuNeon;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;

public class ProgressBarAnimation extends Animation {

    private ProgressBar progressBar;
    private float from;
    private float to;


    // Recebe valores do chamador
    public ProgressBarAnimation(ProgressBar progressBar, float from, float to) {
        this.progressBar = progressBar;
        this.from = from;
        this.to = to;
    }


    // Aplica a animacao do progressBar
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        float value = from + (to - from) * interpolatedTime;
        progressBar.setProgress((int) value);
    }

}
