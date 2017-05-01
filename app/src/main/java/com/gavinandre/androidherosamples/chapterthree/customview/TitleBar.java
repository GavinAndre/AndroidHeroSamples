package com.gavinandre.androidherosamples.chapterthree.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gavinandre.androidherosamples.R;

/**
 * Created by Administrator on 2016/10/27.
 */

public class TitleBar extends RelativeLayout {

    // 包含TitleBar上的元素：左按钮、右按钮、标题
    private ImageButton mLeftButton, mRightButton;
    private TextView mTitleView;
    // 布局属性，用来控制组件元素在ViewGroup中的位置
    private LayoutParams mLeftParams, mTitleParams, mRightParams;
    // 左按钮的属性值，即我们在attrs.xml文件中定义的属性
    private int mLeftTextColor;
    private Drawable mLeftImageDrawable;
    private Drawable mRightImageDrawable;
    private String mLeftText;
    // 右按钮的属性值，即我们在atts.xml文件中定义的属性
    private int mRightTextColor;
    private Drawable mRightBackground;
    private String mRightText;
    // 标题的属性值，即我们在atts.xml文件中定义的属性
    private float mTitleTextSize;
    private int mTitleTextColor;
    private String mTitle;

    // 映射传入的接口对象
    private titleBarLeftClickListener mLeftClickListener;
    private titleBarRightClickListener mRightClickListener;

    public TitleBar(Context context) {
        this(context, null);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs);
        initView(context);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        //        通过这个方法,将你在attrs.xml中定义的declare-styleable的所有属性的值存储到TypedArray中
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TitleBar);
        //        从TypedArray中取出对应的值来为要设置的属性赋值
        mLeftTextColor = ta.getColor(R.styleable.TitleBar_leftTextColor, 0);
        mLeftImageDrawable = ta.getDrawable(R.styleable.TitleBar_leftImageDrawable);
        mLeftText = ta.getString(R.styleable.TitleBar_leftText);
        mRightTextColor = ta.getColor(R.styleable.TitleBar_rightTextColor, 0);
        mRightImageDrawable = ta.getDrawable(R.styleable.TitleBar_rightImageDrawable);
        mRightText = ta.getString(R.styleable.TitleBar_rightText);
        mTitleTextSize = ta.getDimension(R.styleable.TitleBar_titleTextSize, 10);
        mTitleTextColor = ta.getColor(R.styleable.TitleBar_titleTextColor, 0);
        mTitle = ta.getString(R.styleable.TitleBar_title);
        //        获取完TypedArray的值后,一般要调用recycle方法用来避免重新创建的时候的错误
        ta.recycle();
    }

    private void initView(Context context) {
        mLeftButton = new ImageButton(context);
        mRightButton = new ImageButton(context);
        mTitleView = new TextView(context);

        //为创建的组件元素赋值
        //值就来源于我们在引用的xml文件中给对应属性的赋值

        //        mLeftButton.setTextColor(mLeftTextColor);
        mLeftButton.setImageDrawable(mLeftImageDrawable);
        mLeftButton.setBackgroundResource(android.R.color.transparent);
        //        mLeftButton.setText(mLeftText);

        //        mRightButton.setTextColor(mRightTextColor);
        mRightButton.setImageDrawable(mRightImageDrawable);
        mRightButton.setBackgroundResource(android.R.color.transparent);
        //        mRightButton.setText(mRightText);

        mTitleView.setText(mTitle);
        mTitleView.setTextColor(mTitleTextColor);
        mTitleView.setTextSize(mTitleTextSize);
        mTitleView.setGravity(Gravity.CENTER);

        //为组件元素设置相应的布局元素
        mLeftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_START, TRUE);
        } else {
            mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        }
        //添加到ViewGroup
        addView(mLeftButton, mLeftParams);

        mRightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            mRightParams.addRule(RelativeLayout.ALIGN_PARENT_END, TRUE);
        } else {
            mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        }
        addView(mRightButton, mRightParams);

        mTitleParams = new LayoutParams(LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mTitleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(mTitleView, mTitleParams);

        // 按钮的点击事件，不需要具体的实现，
        // 只需调用接口的方法，回调的时候，会有具体的实现
        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLeftClickListener != null) {
                    mLeftClickListener.leftClick();
                }
            }
        });

        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRightClickListener != null) {
                    mRightClickListener.rightClick();
                }
            }
        });
    }

    public void setTitle(String mTitle) {
        if (mTitleView != null) {
            this.mTitle = mTitle;
            mTitleView.setText(mTitle);
        }
    }

    public void setLeftButtonVisible(boolean flag) {
        if (mLeftButton != null) {
            if (flag) {
                mLeftButton.setVisibility(View.VISIBLE);
            } else {
                mLeftButton.setVisibility(View.GONE);
            }
        }
    }

    public void setRightButtonVisible(boolean flag) {
        if (mRightButton != null) {
            if (flag) {
                mRightButton.setVisibility(View.VISIBLE);
            } else {
                mRightButton.setVisibility(View.GONE);
            }
        }
    }

    public void setOnTitleBarLeftClickListener(titleBarLeftClickListener mLeftClickListener) {
        this.mLeftClickListener = mLeftClickListener;
    }

    public void setOnTitleBarRightClickListener(titleBarRightClickListener mRightClickListener) {
        this.mRightClickListener = mRightClickListener;
    }

    // 接口对象，实现回调机制，在回调方法中
    // 通过映射的接口对象调用接口中的方法
    // 而不用去考虑如何实现，具体的实现由调用者去创建
    public interface titleBarLeftClickListener {
        //左按钮点击事件
        void leftClick();
    }

    public interface titleBarRightClickListener {
        //右按钮点击事件
        void rightClick();
    }
}