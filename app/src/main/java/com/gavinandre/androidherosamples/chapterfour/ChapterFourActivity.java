package com.gavinandre.androidherosamples.chapterfour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gavinandre.androidherosamples.R;

/**
 * Created by gavinandre on 17-4-12.
 */

public class ChapterFourActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_four);
    }

    public void btnView(View view) {
        startActivity(new Intent(this, DragViewTest.class));
    }

    public void btnViewGroup(View view) {
        startActivity(new Intent(this, DragViewGroupTest.class));
    }
}
