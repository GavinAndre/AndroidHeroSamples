package com.gavinandre.androidherosamples.chapterfive;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.gavinandre.androidherosamples.R;
import com.gavinandre.androidherosamples.chapterfive.draggroup.DragViewGroupTest;
import com.gavinandre.androidherosamples.chapterfive.dragview.DragViewTest;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gavinandre on 17-4-12.
 */

public class ChapterFiveActivity extends AppCompatActivity {

    @BindView(R.id.chapter_four_text_view1)
    TextView mChapterFourTextView1;
    @BindView(R.id.chapter_four_text_view2)
    TextView mChapterFourTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_five);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.chapter_four_text_view1, R.id.chapter_four_text_view2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.chapter_four_text_view1:
                startActivity(new Intent(this, DragViewTest.class));
                break;
            case R.id.chapter_four_text_view2:
                startActivity(new Intent(this, DragViewGroupTest.class));
                break;
        }
    }
}
