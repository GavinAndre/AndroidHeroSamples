package com.gavinandre.androidherosamples.chaptersix.clock;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import static android.content.ContentValues.TAG;

/**
 * Created by GavinAndre on 2016/11/15.
 */

public class Clock extends View {

    private int mHeight, mWidth;
    Paint paintCircle, paintDegree, paintPointer, paintHour, paintMinute;

    public Clock(Context context) {
        this(context, null);
    }

    public Clock(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Clock(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        paintCircle = new Paint();
        paintDegree = new Paint();
        paintPointer = new Paint();
        paintHour = new Paint();
        paintMinute = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //获取宽高参数
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
        Log.i(TAG, "onDraw: mWidth " + mWidth);
        Log.i(TAG, "onDraw: mHeight " + mHeight);
        //画外圆
        //FILL填充 FILL_AND_STROKE填充加描边 STROKE描边
        paintCircle.setStyle(Paint.Style.STROKE);
        //设置抗锯齿
        paintCircle.setAntiAlias(true);
        //设置画笔宽度
        paintCircle.setStrokeWidth(5);
        //params 圆心,半径  -5f为了抵消画笔宽度
        canvas.drawCircle(mWidth / 2, mHeight / 2, mWidth / 2 - 5f, paintCircle);
        //画刻度
        paintCircle.setStrokeWidth(3);
        //从0开始画直线
        for (int i = 0; i < 24; i++) {
            if (i == 0 || i == 6 || i == 12 || i == 18) {
                //区分整点与非整点
                paintDegree.setStrokeWidth(5);
                paintDegree.setTextSize(30);
                paintCircle.setAntiAlias(true);
                //直线起点坐标为mHeight/2减去圆半径长度  +5f为抵消画笔宽度
                canvas.drawLine(mWidth / 2, mHeight / 2 - mWidth / 2 + 5f,
                        mWidth / 2, mHeight / 2 - mWidth / 2 + 60, paintDegree);
                String degree = String.valueOf(i);
                canvas.drawText(degree,
                        mWidth / 2 - paintDegree.measureText(degree) / 2,
                        mHeight / 2 - mWidth / 2 + 90, paintDegree);
            } else {
                paintDegree.setStrokeWidth(3);
                paintDegree.setTextSize(15);
                paintCircle.setAntiAlias(true);
                canvas.drawLine(mWidth / 2, mHeight / 2 - mWidth / 2 + 5f,
                        mWidth / 2, mHeight / 2 - mWidth / 2 + 30, paintDegree);
                String degree = String.valueOf(i);
                canvas.drawText(degree,
                        mWidth / 2 - paintDegree.measureText(degree) / 2,
                        mHeight / 2 - mWidth / 2 + 60, paintDegree);
            }
            //通过旋转画布简化坐标运算
            canvas.rotate(15, mWidth / 2, mHeight / 2);
        }
        //画圆心
        paintPointer.setStrokeWidth(30);
        canvas.drawPoint(mWidth / 2, mHeight / 2, paintPointer);
        //画指针
        paintHour.setStrokeWidth(20);
        paintMinute.setStrokeWidth(10);
        canvas.save();
        //平移坐标到圆心
        canvas.translate(mWidth / 2, mHeight / 2);
        canvas.drawLine(0, 0, 100, 100, paintHour);
        canvas.drawLine(0, 0, 100, 200, paintMinute);
        canvas.restore();
    }
}
