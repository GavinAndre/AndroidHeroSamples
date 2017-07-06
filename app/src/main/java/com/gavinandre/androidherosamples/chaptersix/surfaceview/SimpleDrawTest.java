package com.gavinandre.androidherosamples.chaptersix.surfaceview;

import android.app.Activity;
import android.os.Bundle;


public class SimpleDrawTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SimpleDraw(this));
    }
}
