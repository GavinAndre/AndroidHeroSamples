package com.gavinandre.androidherosamples.chaptertwelve.anim;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.gavinandre.androidherosamples.R;

public class CircularActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular);
        final View oval = findViewById(R.id.oval);
        oval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animator animator = ViewAnimationUtils.createCircularReveal(oval, oval.getWidth() / 2,
                        oval.getHeight() / 2, oval.getWidth(), 0);
                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                animator.setDuration(2000);
                animator.start();
            }
        });

        final View rect = findViewById(R.id.rect);
        rect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Math.hypot求直角三角形斜边长
                Animator animator = ViewAnimationUtils.createCircularReveal(rect,
                        0, 0, 0, (float) Math.hypot(rect.getWidth(), rect.getHeight()));
                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                animator.setDuration(2000);
                animator.start();
            }
        });
    }
}
