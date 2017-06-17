package com.gavinandre.androidherosamples.chaptersix.imageColor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gavinandre.androidherosamples.R;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class ImageColorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_color);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.primary_color, R.id.color_matrix, R.id.pixels_effect})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.primary_color:
                startActivity(new Intent(this, PrimaryColor.class));
                break;
            case R.id.color_matrix:
                startActivity(new Intent(this, ColorMatrix.class));
                break;
            case R.id.pixels_effect:
                startActivity(new Intent(this, PixelsEffect.class));
                break;
        }
    }
}
