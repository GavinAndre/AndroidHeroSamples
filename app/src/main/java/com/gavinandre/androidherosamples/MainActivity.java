package com.gavinandre.androidherosamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.gavinandre.androidherosamples.chapterfour.ChapterFourActivity;
import com.gavinandre.androidherosamples.chapterthree.ChapterThreeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.text_view1)
    TextView mTextView1;
    @BindView(R.id.text_view2)
    TextView mTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.text_view1, R.id.text_view2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text_view1:
                Intent intent1 = new Intent(this, ChapterThreeActivity.class);
                startActivity(intent1);
                break;
            case R.id.text_view2:
                Intent intent2 = new Intent(this, ChapterFourActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
