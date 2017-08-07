package com.gavinandre.androidherosamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gavinandre.androidherosamples.chapterfive.ChapterFiveActivity;
import com.gavinandre.androidherosamples.chapterseven.ChapterSevenActivity;
import com.gavinandre.androidherosamples.chaptersix.ChapterSixActivity;
import com.gavinandre.androidherosamples.chapterthree.ChapterThreeActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.text_view1, R.id.text_view2, R.id.text_view3, R.id.text_view4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text_view1:
                startActivity(new Intent(this, ChapterThreeActivity.class));
                break;
            case R.id.text_view2:
                startActivity(new Intent(this, ChapterFiveActivity.class));
                break;
            case R.id.text_view3:
                startActivity(new Intent(this, ChapterSixActivity.class));
                break;
            case R.id.text_view4:
                startActivity(new Intent(this, ChapterSevenActivity.class));
                break;
        }
    }
}
