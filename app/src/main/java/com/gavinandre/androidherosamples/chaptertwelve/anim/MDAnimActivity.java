package com.gavinandre.androidherosamples.chaptertwelve.anim;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gavinandre.androidherosamples.R;

public class MDAnimActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_md_anim);
    }

    public void ripple(View view) {
        Intent intent = new Intent(this, RippleActivity.class);
        startActivity(intent);
    }

    public void circular(View view) {
        Intent intent = new Intent(this, CircularActivity.class);
        startActivity(intent);
    }

    public void viewState(View view) {
        Intent intent = new Intent(this, ViewStateActivity.class);
        startActivity(intent);
    }

}
