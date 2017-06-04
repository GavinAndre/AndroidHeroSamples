package com.gavinandre.androidherosamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.gavinandre.androidherosamples.chapterfive.ChapterFiveActivity;
import com.gavinandre.androidherosamples.chaptersix.ChapterSixActivity;
import com.gavinandre.androidherosamples.chapterthree.ChapterThreeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.text_view1)
    TextView mTextView1;
    @BindView(R.id.text_view2)
    TextView mTextView2;
    @BindView(R.id.text_view3)
    TextView mTextView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.text_view1, R.id.text_view2, R.id.text_view3})
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
        }
    }
}
