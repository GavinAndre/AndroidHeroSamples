package com.gavinandre.androidherosamples.chapterseven.customanim;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.gavinandre.androidherosamples.R;

public class CustomAnimActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_anim);
    }

    public void btnAnim(View view) {
        CustomAnim customAnim = new CustomAnim();
        customAnim.setRotateY(30);
        view.startAnimation(customAnim);
    }

    public void imgClose(View view) {
        CustomTV customTV = new CustomTV();
        view.startAnimation(customTV);
    }
}
