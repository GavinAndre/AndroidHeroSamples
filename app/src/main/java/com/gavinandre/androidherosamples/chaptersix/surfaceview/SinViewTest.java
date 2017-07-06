package com.gavinandre.androidherosamples.chaptersix.surfaceview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class SinViewTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SinView(this));
    }
}
