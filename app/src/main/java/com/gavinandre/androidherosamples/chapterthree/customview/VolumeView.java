package com.gavinandre.androidherosamples.chapterthree.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by GavinAndre on 2016/11/3.
 */

public class VolumeView extends View {

    private int mWidth;
    private int mRectWidth;
    private int mRectHeight;
    private Paint mPaint;
    //音频条数量
    private int mRectCount;
    private int offset = 5;
    private double mRandom;
    private LinearGradient mLinearGradient;

    public VolumeView(Context context) {
        this(context, null);
    }

    public VolumeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VolumeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mRectCount = 15;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //总控件长度
        mWidth = getWidth();
        //总控件高度
        mRectHeight = getHeight();
        //音频条长度:总控件长度的60%除以音频条个数
        mRectWidth = (int) (mWidth * 0.6 / mRectCount);
        // 创建LinearGradient对象
        // 起始点坐标（-mViewWidth, 0） 终点坐标（0，0）
        // 第一个,第二个参数表示渐变起点 可以设置起点终点在对角等任意位置
        // 第三个,第四个参数表示渐变终点
        // 第五个参数表示渐变颜色
        // 第六个参数可以为空,表示坐标,值为0-1
        // 如果这是空的，颜色均匀分布，沿梯度线。
        // 第七个表示平铺方式
        // CLAMP重复最后一个颜色至最后
        // MIRROR重复着色的图像水平或垂直方向已镜像方式填充会有翻转效果
        // REPEAT重复着色的图像水平或垂直方向
        mLinearGradient = new LinearGradient(0, 0, mRectWidth, mRectHeight, Color.YELLOW,
                Color.BLUE, Shader.TileMode.CLAMP);
        mPaint.setShader(mLinearGradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < mRectCount; i++) {
            //随机变化每个小矩形的高度
            mRandom = Math.random();
            float currentHeight = (float) (mRectHeight * mRandom);
            canvas.drawRect(
                    //左坐标:总控件长度的40%/2加上音频条长度+5px的偏移量
                    (float) (mWidth * 0.4 / 2 + mRectWidth * i + offset),
                    currentHeight,
                    (float) (mWidth * 0.4 / 2 + mRectWidth * (i + 1)),
                    mRectHeight,
                    mPaint);
        }
        postInvalidateDelayed(300);
    }
}
