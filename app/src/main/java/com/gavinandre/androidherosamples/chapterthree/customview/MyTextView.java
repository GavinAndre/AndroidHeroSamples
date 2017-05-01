package com.gavinandre.androidherosamples.chapterthree.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/10/26.
 */

public class MyTextView extends TextView {
    private Paint mPaint1;
    private Paint mPaint2;

    public MyTextView(Context context) {
        super(context);
        initView(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        initView(context);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        mPaint1 = new Paint();
//        mPaint1.setColor(getResources().getColor(android.R.color.holo_blue_light)); //getColor已过时
        mPaint1.setColor(ContextCompat.getColor(context, android.R.color.holo_blue_light));
        mPaint1.setStyle(Paint.Style.FILL);
        mPaint2 = new Paint();
        mPaint2.setColor(Color.YELLOW);
        mPaint2.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //在回调父类方法前,实现自己的逻辑,对TextView来说即是在绘制文本内容前
        //绘制外层矩形
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint1);
        //绘制内层矩形
        canvas.drawRect(10, 10, getMeasuredWidth() - 10, getMeasuredHeight() - 10, mPaint2);
        canvas.save();
        //绘制文字前平移10像素
        canvas.translate(10, 0);
        //父类完成的方法,即绘制文本
        super.onDraw(canvas);
        canvas.restore();
        //在回调父类方法后,实现自己的逻辑,对TextView来说即是在绘制文本内容后
    }
/*
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(measuredWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    private int measuredWidth(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = 0;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    private int measureHeight(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = 0;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }*/
}
