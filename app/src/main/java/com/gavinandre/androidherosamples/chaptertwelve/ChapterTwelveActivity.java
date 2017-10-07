package com.gavinandre.androidherosamples.chaptertwelve;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gavinandre.androidherosamples.R;
import com.gavinandre.androidherosamples.chaptertwelve.anim.MDAnimActivity;
import com.gavinandre.androidherosamples.chaptertwelve.cardview.CardViewActivity;
import com.gavinandre.androidherosamples.chaptertwelve.clipping.ClippingActivity;
import com.gavinandre.androidherosamples.chaptertwelve.elevation.ElevationActivity;
import com.gavinandre.androidherosamples.chaptertwelve.palette.PaletteActivity;
import com.gavinandre.androidherosamples.chaptertwelve.recyclerview.RecyclerTest;
import com.gavinandre.androidherosamples.chaptertwelve.tinting.TintingActivity;
import com.gavinandre.androidherosamples.chaptertwelve.transition.TransitionActivityA;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gavinandre on 17-4-12.
 */

public class ChapterTwelveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_twelve);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.chapter_twelve_text_view1, R.id.chapter_twelve_text_view2,
            R.id.chapter_twelve_text_view3, R.id.chapter_twelve_text_view4,
            R.id.chapter_twelve_text_view5, R.id.chapter_twelve_text_view6,
            R.id.chapter_twelve_text_view7, R.id.chapter_twelve_text_view8
    })
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.chapter_twelve_text_view1:
                intent = new Intent(this, PaletteActivity.class);
                startActivity(intent);
                break;
            case R.id.chapter_twelve_text_view2:
                intent = new Intent(this, ElevationActivity.class);
                startActivity(intent);
                break;
            case R.id.chapter_twelve_text_view3:
                intent = new Intent(this, TintingActivity.class);
                startActivity(intent);
                break;
            case R.id.chapter_twelve_text_view4:
                intent = new Intent(this, ClippingActivity.class);
                startActivity(intent);
                break;
            case R.id.chapter_twelve_text_view5:
                intent = new Intent(this, RecyclerTest.class);
                startActivity(intent);
                break;
            case R.id.chapter_twelve_text_view6:
                intent = new Intent(this, CardViewActivity.class);
                startActivity(intent);
                break;
            case R.id.chapter_twelve_text_view7:
                intent = new Intent(this, TransitionActivityA.class);
                startActivity(intent);
                break;
            case R.id.chapter_twelve_text_view8:
                intent = new Intent(this, MDAnimActivity.class);
                startActivity(intent);
                break;
        }
    }
}
