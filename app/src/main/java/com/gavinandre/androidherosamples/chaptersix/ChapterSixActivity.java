package com.gavinandre.androidherosamples.chaptersix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gavinandre.androidherosamples.R;
import com.gavinandre.androidherosamples.chaptersix.canvaspaintbase.CanvasPaintActivity;
import com.gavinandre.androidherosamples.chaptersix.clock.ClockActivity;
import com.gavinandre.androidherosamples.chaptersix.imageColor.ImageColorActivity;
import com.gavinandre.androidherosamples.chaptersix.imageShape.ImageShapeActivity;
import com.gavinandre.androidherosamples.chaptersix.layer.LayerActivity;
import com.gavinandre.androidherosamples.chaptersix.surfaceview.SurfaceViewActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gavinandre on 17-4-12.
 */

public class ChapterSixActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_six);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.chapter_six_text_view1, R.id.chapter_six_text_view2, R.id.chapter_six_text_view3,
            R.id.chapter_six_text_view4, R.id.chapter_six_text_view5,R.id.chapter_six_text_view6})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.chapter_six_text_view1:
                startActivity(new Intent(this, CanvasPaintActivity.class));
                break;
            case R.id.chapter_six_text_view2:
                startActivity(new Intent(this, ClockActivity.class));
                break;
            case R.id.chapter_six_text_view3:
                startActivity(new Intent(this, LayerActivity.class));
                break;
            case R.id.chapter_six_text_view4:
                startActivity(new Intent(this, ImageColorActivity.class));
                break;
            case R.id.chapter_six_text_view5:
                startActivity(new Intent(this, ImageShapeActivity.class));
                break;
            case R.id.chapter_six_text_view6:
                startActivity(new Intent(this, SurfaceViewActivity.class));
                break;
        }
    }
}
