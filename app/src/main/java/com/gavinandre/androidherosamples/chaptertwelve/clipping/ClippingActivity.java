package com.gavinandre.androidherosamples.chaptertwelve.clipping;

import android.app.Activity;
import android.graphics.Outline;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewOutlineProvider;

import com.gavinandre.androidherosamples.R;

/**
 * Created by gavinandre on 17-9-19.
 */

public class ClippingActivity extends Activity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clipping);

        View view1 = findViewById(R.id.tv_rect);
        View view2 = findViewById(R.id.tv_cicle);

        //获取Outline
        ViewOutlineProvider viewOutlineProvider1 = new ViewOutlineProvider() {

            @Override
            public void getOutline(View view, Outline outline) {
                //修改outline为特定的形状
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 30);
            }
        };
        //获取Outline
        ViewOutlineProvider viewOutlineProvider2 = new ViewOutlineProvider() {

            @Override
            public void getOutline(View view, Outline outline) {
                //修改outline为特定的形状
                outline.setOval(0, 0, view.getWidth(), view.getHeight());
            }
        };

        //重新设置形状
        view1.setOutlineProvider(viewOutlineProvider1);
        view2.setOutlineProvider(viewOutlineProvider2);
    }

}
