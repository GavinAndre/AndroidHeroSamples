package com.gavinandre.androidherosamples.chapterthree.customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.gavinandre.androidherosamples.R;

/**
 * Created by gavinandre on 17-4-12.
 */

public class CustomViewActivity extends AppCompatActivity {
    private TitleBar mTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);

        mTitleBar = (TitleBar) findViewById(R.id.title_bar);
        mTitleBar.setOnTitleBarLeftClickListener(new TitleBar.titleBarLeftClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(CustomViewActivity.this, "left", Toast.LENGTH_SHORT).show();
            }
        });
        mTitleBar.setOnTitleBarRightClickListener(new TitleBar.titleBarRightClickListener() {
            @Override
            public void rightClick() {
                Toast.makeText(CustomViewActivity.this, "right", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
