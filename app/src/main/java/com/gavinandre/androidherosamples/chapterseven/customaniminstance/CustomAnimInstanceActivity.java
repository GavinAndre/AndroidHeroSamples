package com.gavinandre.androidherosamples.chapterseven.customaniminstance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gavinandre.androidherosamples.R;

/**
 * Created by gavinandre on 17-4-12.
 */

public class CustomAnimInstanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_anim_instance);
    }

    public void btnDrop(View view) {
        startActivity(new Intent(this, DropTest.class));
    }

    public void btnProperty(View view) {
        startActivity(new Intent(this, PropertyTest.class));
    }

    public void btnTimer(View view) {
        startActivity(new Intent(this, TimerTest.class));
    }
}
