package com.gavinandre.androidherosamples.chapterthree.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2016/10/24.
 */

public class MyView extends View {
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 在super.onMeasure(widthMeasureSpec, heightMeasureSpec);方法中，系统最终会调用setMeasuredDimension
     * (int measuredWidth, int measuredHeight)方法将测量后的宽高值设置进去，从而完成测量工作。所以在重写
     * onMeasure()后，最终就是把测量后的宽高值作为参数设置给setMeasuredDimension()方法。
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(measureWidth(widthMeasureSpec),
                measureWidth(heightMeasureSpec));
    }
    /**
     * 测量控件的高度
     */
    public int measureWidth(int measureSpec) {
        int result = 0;
        //从MeasureSpec对象中提取出具体的测量模式和大小
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        //判断测量的模式
        if (specMode == MeasureSpec.EXACTLY) {
            //当specMode为EXACTLY时直接赋值,比如设置400px或者match_parent
            result = specSize;
        } else {
            //需要设置一个最小值,设定为wrap_content模式时需要取出
            //result与specSize中最小的一个来作为最后的测量值
            result = 200;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(specSize, result);
            }
        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GREEN);
    }

}
