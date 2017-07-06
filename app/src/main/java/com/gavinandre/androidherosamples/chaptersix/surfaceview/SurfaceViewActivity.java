package com.gavinandre.androidherosamples.chaptersix.surfaceview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gavinandre.androidherosamples.R;
import com.gavinandre.androidherosamples.chaptersix.imageShape.PathEffectViewTest;
import com.gavinandre.androidherosamples.chaptersix.imageShape.ReflectViewTest;


public class SurfaceViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_view);
    }

    public void btnSinView(View view) {
        startActivity(new Intent(this, SinViewTest.class));
    }

    public void btnSimpleDraw(View view) {
        startActivity(new Intent(this, SimpleDrawTest.class));
    }
}
