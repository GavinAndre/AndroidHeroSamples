package com.gavinandre.androidherosamples.chapterseven;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gavinandre.androidherosamples.R;
import com.gavinandre.androidherosamples.chapterseven.customanim.CustomAnimActivity;
import com.gavinandre.androidherosamples.chapterseven.customaniminstance.CustomAnimInstanceActivity;
import com.gavinandre.androidherosamples.chapterseven.svganim.SVGAnimActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gavinandre on 17-4-12.
 */

public class ChapterSevenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_seven);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.chapter_seven_text_view1, R.id.chapter_seven_text_view2, R.id.chapter_seven_text_view3})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.chapter_seven_text_view1:
                intent = new Intent(this, CustomAnimActivity.class);
                startActivity(intent);
                break;
            case R.id.chapter_seven_text_view2:
                intent = new Intent(this, CustomAnimInstanceActivity.class);
                startActivity(intent);
                break;
            case R.id.chapter_seven_text_view3:
                intent = new Intent(this, SVGAnimActivity.class);
                startActivity(intent);
                break;
        }
    }
}
