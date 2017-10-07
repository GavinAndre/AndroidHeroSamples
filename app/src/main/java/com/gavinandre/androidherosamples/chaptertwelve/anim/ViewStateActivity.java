package com.gavinandre.androidherosamples.chaptertwelve.anim;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.gavinandre.androidherosamples.R;

public class ViewStateActivity extends AppCompatActivity {

    private boolean mIsCheck;
    private ImageView mImageView;
    private static final int[] STATE_CHECKED = new int[]{android.R.attr.state_checked};
    private static final int[] STATE_UNCHECKED = new int[]{};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_state);
        //view state changes animation
        Button button = (Button) findViewById(R.id.button);
        StateListAnimator animator = AnimatorInflater.loadStateListAnimator(this, R.drawable.anim_change);
        button.setStateListAnimator(animator);

        //animated-selector
        mImageView = (ImageView) findViewById(R.id.image);
    }

    public void anim(View view) {
        if(mIsCheck){
            mImageView.setImageState(STATE_UNCHECKED, true);
            mIsCheck = false;
        }else{
            mImageView.setImageState(STATE_CHECKED, true);
            mIsCheck = true;
        }
    }

}
