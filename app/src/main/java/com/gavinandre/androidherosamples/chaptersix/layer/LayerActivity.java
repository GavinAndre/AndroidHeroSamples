package com.gavinandre.androidherosamples.chaptersix.layer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class LayerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyLayer(this));
    }

    public class MyLayer extends View {

        private Paint mPaint;

        public MyLayer(Context context) {
            super(context);
            mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.WHITE);
            mPaint.setColor(Color.BLUE);
            canvas.drawCircle(150, 150, 100, mPaint);
            //alpha 255不透明，127半透明，0全透明
            canvas.saveLayerAlpha(0, 0, 400, 400, 255);
            mPaint.setColor(Color.RED);
            canvas.drawCircle(200, 200, 100, mPaint);
            canvas.restore();
        }
    }
}
