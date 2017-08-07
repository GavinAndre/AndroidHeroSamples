package com.gavinandre.androidherosamples.chapterseven;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gavinandre.androidherosamples.R;
import com.gavinandre.androidherosamples.chapterseven.customanim.CustomAnimActivity;

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

    @OnClick({R.id.chapter_seven_text_view1})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.chapter_seven_text_view1:
                intent = new Intent(this, CustomAnimActivity.class);
                startActivity(intent);
                break;
        }
    }
}
