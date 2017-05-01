package com.gavinandre.androidherosamples.chapterthree;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.gavinandre.androidherosamples.R;
import com.gavinandre.androidherosamples.chapterthree.customview.CustomViewActivity;
import com.gavinandre.androidherosamples.chapterthree.customviewgroup.CustomViewGroupActivity;
import com.gavinandre.androidherosamples.chapterthree.customviewlayout.CustomViewLayoutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gavinandre on 17-4-12.
 */

public class ChapterThreeActivity extends AppCompatActivity {

    @BindView(R.id.chapter_three_text_view1)
    TextView mChapterThreeTextView1;
    @BindView(R.id.chapter_three_text_view2)
    TextView mChapterThreeTextView2;
    @BindView(R.id.chapter_three_text_view3)
    TextView mChapterThreeTextView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_three);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.chapter_three_text_view1, R.id.chapter_three_text_view2, R.id.chapter_three_text_view3})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.chapter_three_text_view1:
                intent = new Intent(this, CustomViewActivity.class);
                startActivity(intent);
                break;
            case R.id.chapter_three_text_view2:
                intent = new Intent(this, CustomViewGroupActivity.class);
                startActivity(intent);
                break;
            case R.id.chapter_three_text_view3:
                intent = new Intent(this, CustomViewLayoutActivity.class);
                startActivity(intent);
                break;
        }
    }
}
