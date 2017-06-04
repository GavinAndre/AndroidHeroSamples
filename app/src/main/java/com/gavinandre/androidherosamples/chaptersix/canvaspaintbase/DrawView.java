package com.gavinandre.androidherosamples.chaptersix.canvaspaintbase;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.gavinandre.androidherosamples.R;
import com.gavinandre.androidherosamples.UIHelper;

/**
 * Created by gavinandre on 17-5-6.
 */

public class DrawView extends View {

    private int dp;
    private int sp;
    private Paint mPaint;
    private RectF oval1;
    private RectF oval2;
    private RectF oval3;
    private Path path;
    private Path path1;
    private Bitmap bitmap;
    private Shader mShader;

    public DrawView(Context context) {
        this(context, null);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        dp = UIHelper.dipToPx(getContext(), 1);
        sp = UIHelper.sp2px(getContext(), 1);
        mPaint = new Paint();
        oval1 = new RectF();
        oval2 = new RectF();
        oval3 = new RectF();
        path = new Path();
        path1 = new Path();
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        mShader = new LinearGradient(0, 0, 100 * dp, 100 * dp,
                new int[]{Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW,
                        Color.LTGRAY}, null, Shader.TileMode.REPEAT); // 一个材质,打造出一个线性梯度沿著一条线。
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 文字介绍
        mPaint.reset();
        mPaint.setColor(Color.RED);// 设置红色
        mPaint.setTextSize(15 * sp);
        mPaint.setAntiAlias(true);
        canvas.drawText("画矩形：", 10 * dp, 25 * dp, mPaint);
        // 画矩形
        mPaint.setColor(Color.GRAY);// 设置灰色
        mPaint.setStrokeWidth(4);//设置点大小
        mPaint.setStyle(Paint.Style.STROKE);//设置空心
        canvas.drawRect(80 * dp, 10 * dp, 120 * dp, 50 * dp, mPaint);// 正方形
        mPaint.setStyle(Paint.Style.FILL);//设置填满
        canvas.drawRect(140 * dp, 10 * dp, 180 * dp, 50 * dp, mPaint);// 正方形
        canvas.drawRect(200 * dp, 10 * dp, 280 * dp, 50 * dp, mPaint);// 长方形

        //文字介绍
        mPaint.reset();
        mPaint.setColor(Color.RED);// 设置红色
        mPaint.setTextSize(15 * sp);
        mPaint.setAntiAlias(true);
        canvas.drawText("画点：", 10 * dp, 80 * dp, mPaint);
        //画点
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.GRAY);// 设置灰色
        mPaint.setStrokeWidth(5);//设置点大小
        canvas.drawPoint(80 * dp, 70 * dp, mPaint);//画一个点
        canvas.drawPoints(new float[]{80 * dp, 80 * dp, 90 * dp, 80 * dp, 100 * dp, 80 * dp}, mPaint);//画多个点

        //文字介绍
        mPaint.reset();
        mPaint.setColor(Color.RED);// 设置红色
        mPaint.setTextSize(15 * sp);
        mPaint.setAntiAlias(true);
        canvas.drawText("画线：", 10 * dp, 110 * dp, mPaint);
        //画线
        mPaint.setStrokeWidth(4);//设置点大小
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.GRAY);// 设置灰色
        canvas.drawLine(80 * dp, 100 * dp, 120 * dp, 100 * dp, mPaint);// 直线
        canvas.drawLine(140 * dp, 100 * dp, 180 * dp, 140 * dp, mPaint);// 斜线
        canvas.drawLines(new float[]{200 * dp, 100 * dp, 240 * dp, 100 * dp,
                240 * dp, 100 * dp, 200 * dp, 140 * dp,
                200 * dp, 140 * dp, 240 * dp, 140 * dp}, mPaint);

        // 文字介绍
        mPaint.reset();
        mPaint.setColor(Color.RED);// 设置红色
        mPaint.setTextSize(15 * sp);
        mPaint.setAntiAlias(true);
        canvas.drawText("画圆角矩形：", 10 * dp, 180 * dp, mPaint);
        // 画圆角矩形
        mPaint.setColor(Color.GRAY);// 设置灰色
        mPaint.setStrokeWidth(4);//设置点大小
        mPaint.setStyle(Paint.Style.STROKE);//设置空心
        oval1.set(120 * dp, 160 * dp, 180 * dp, 200 * dp);// 设置个新的长方形
        canvas.drawRoundRect(oval1, 5 * dp, 5 * dp, mPaint);

        // 文字介绍
        mPaint.reset();
        mPaint.setColor(Color.RED);// 设置红色
        mPaint.setTextSize(15 * sp);
        mPaint.setAntiAlias(true);
        canvas.drawText("画圆：", 10 * dp, 230 * dp, mPaint);
        // 画圆
        mPaint.setColor(Color.GRAY);// 设置灰色
        mPaint.setStrokeWidth(4);//设置点大小
        mPaint.setStyle(Paint.Style.STROKE);//设置空心
        canvas.drawCircle(80 * dp, 230 * dp, 15 * dp, mPaint);

        // 文字介绍
        mPaint.reset();
        mPaint.setColor(Color.RED);// 设置红色
        mPaint.setTextSize(15 * sp);
        mPaint.setAntiAlias(true);
        canvas.drawText("画扇形：", 10 * dp, 280 * dp, mPaint);
        // 画扇形
        mPaint.setColor(Color.GRAY);// 设置灰色
        mPaint.setStrokeWidth(4);//设置点大小
        mPaint.setStyle(Paint.Style.STROKE);//设置空心
        /* 设置渐变色 这个正方形的颜色是改变的 */
        oval2.set(100 * dp, 260 * dp, 160 * dp, 320 * dp);// 设置个新的长方形，扫描测量
        canvas.drawArc(oval2, 200, 140, true, mPaint);
        // 实心效果
        mPaint.setStyle(Paint.Style.FILL);//设置空心
        /* 设置渐变色 这个正方形的颜色是改变的 */
        mPaint.setShader(mShader);
        oval3.set(180 * dp, 260 * dp, 240 * dp, 320 * dp);// 设置个新的长方形，扫描测量
        canvas.drawArc(oval3, 200, 140, true, mPaint);
        // 画弧，第一个参数是RectF：该类是第二个参数是角度的开始，第三个参数是多少度，第四个参数是真的时候画扇形，是假的时候画弧线

        // 文字介绍
        mPaint.reset();
        mPaint.setColor(Color.RED);// 设置红色
        mPaint.setTextSize(15 * sp);
        mPaint.setAntiAlias(true);
        canvas.drawText("画弧形：", 10 * dp, 330 * dp, mPaint);
        // 画弧形
        mPaint.setColor(Color.GRAY);// 设置灰色
        mPaint.setStrokeWidth(4);//设置点大小
        mPaint.setStyle(Paint.Style.STROKE);//设置空心
        /* 设置渐变色 这个正方形的颜色是改变的 */
        oval2.set(100 * dp, 310 * dp, 160 * dp, 370 * dp);// 设置个新的长方形，扫描测量
        canvas.drawArc(oval2, 200, 140, false, mPaint);
        // 实心效果
        mPaint.setStyle(Paint.Style.FILL);//设置空心
        /* 设置渐变色 这个正方形的颜色是改变的 */
        mPaint.setShader(mShader);
        oval3.set(180 * dp, 310 * dp, 240 * dp, 370 * dp);// 设置个新的长方形，扫描测量
        canvas.drawArc(oval3, 200, 140, false, mPaint);

        // 文字介绍
        mPaint.reset();
        mPaint.setColor(Color.RED);// 设置红色
        mPaint.setTextSize(15 * sp);
        mPaint.setAntiAlias(true);
        canvas.drawText("画椭圆：", 10 * dp, 370 * dp, mPaint);
        // 画椭圆
        mPaint.setColor(Color.GRAY);// 设置灰色
        mPaint.setStrokeWidth(4);//设置点大小
        mPaint.setStyle(Paint.Style.STROKE);//设置空心
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawOval(100 * dp, 350 * dp, 160 * dp, 390 * dp, mPaint);
        }

        // 文字介绍
        mPaint.reset();
        mPaint.setColor(Color.RED);// 设置红色
        mPaint.setTextSize(15 * sp);
        mPaint.setAntiAlias(true);
        canvas.drawText("画文字：", 10 * dp, 420 * dp, mPaint);
        // 画文字
        mPaint.setColor(Color.GRAY);// 设置灰色
        mPaint.setStyle(Paint.Style.STROKE);//设置空心
        canvas.drawText("Android", 80 * dp, 420 * dp, mPaint);

        // 文字介绍
        mPaint.reset();
        mPaint.setColor(Color.RED);// 设置红色
        mPaint.setTextSize(15 * sp);
        mPaint.setAntiAlias(true);
        canvas.drawText("画路径：", 10 * dp, 460 * dp, mPaint);
        // 画路径
        mPaint.setColor(Color.GRAY);// 设置灰色
        mPaint.setStyle(Paint.Style.STROKE);//设置空心
        mPaint.setStrokeWidth(4);//设置点大小
        path.moveTo(100 * dp, 440 * dp);
        path.lineTo(140 * dp, 440 * dp);
        path.lineTo(150 * dp, 450 * dp);
        path.lineTo(140 * dp, 460 * dp);
        path.lineTo(100 * dp, 460 * dp);
        path.lineTo(90 * dp, 450 * dp);
        path.close();//封闭
        canvas.drawPath(path, mPaint);

        // 文字介绍
        mPaint.reset();
        mPaint.setColor(Color.RED);// 设置红色
        mPaint.setTextSize(15 * sp);
        mPaint.setAntiAlias(true);
        canvas.drawText("画贝塞尔曲线:", 180 * dp, 370 * dp, mPaint);
        //画贝塞尔曲线
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.GRAY);
        path1.moveTo(180 * dp, 390 * dp);//设置Path的起点
        path1.quadTo(280 * dp, 390 * dp, 250 * dp, 500 * dp); //设置贝塞尔曲线的控制点坐标和终点坐标
        canvas.drawPath(path1, mPaint);//画出贝塞尔曲线

        // 文字介绍
        mPaint.reset();
        mPaint.setColor(Color.RED);// 设置红色
        mPaint.setTextSize(15 * sp);
        mPaint.setAntiAlias(true);
        canvas.drawText("画图片:", 10 * dp, 500 * dp, mPaint);
        //画图片，就是贴图
        canvas.drawBitmap(bitmap, 100 * dp, 470 * dp, mPaint);
    }
}
