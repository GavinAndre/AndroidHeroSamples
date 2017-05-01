package com.gavinandre.androidherosamples.chapterthree.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by GavinAndre on 2016/10/26.
 */


public class ShineTextView extends TextView {
    private static final String TAG = ShineTextView.class.getSimpleName();
    //线性渐变渲染
    private LinearGradient mLinearGradient;
    //渲染矩阵
    private Matrix mGradientMatrix;
    //画笔
    private Paint mPaint;
    private int mViewWidth = 0;
    // 亮度位移距离
    private int mTranslate = 0;

    public ShineTextView(Context context) {
        super(context);
    }

    public ShineTextView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public ShineTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mViewWidth == 0) {
            mViewWidth = getMeasuredWidth();
            if (mViewWidth > 0) {
                //获取当前绘制TextView的Paint对象
                mPaint = getPaint();
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
                mLinearGradient = new LinearGradient(-mViewWidth, 0, 0, 0, new int[]{
                        Color.BLUE, 0xffffffff, Color.BLUE}, null, Shader.TileMode.CLAMP);
                //设置原生TextView没有的LinearGradient属性
                mPaint.setShader(mLinearGradient);
                mGradientMatrix = new Matrix();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mGradientMatrix != null) {
            //在该方法中，通过矩阵的方式不断平移渐变效果，从而在绘制文字时，产生动态的闪动效果
            mTranslate += mViewWidth / 10;
            if (mTranslate > 2 * mViewWidth) {
                mTranslate = 0;
            }
            mGradientMatrix.setTranslate(mTranslate, 0);
            mLinearGradient.setLocalMatrix(mGradientMatrix);
            //100毫秒重绘一次
            postInvalidateDelayed(100);
        }
    }
}