package com.gavinandre.androidherosamples.chaptersix.imageShape;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;

import com.gavinandre.androidherosamples.R;

public class ImageMatrixTest extends Activity {

    private GridLayout mGridGroup;
    private ImageMatrixView mMyView;
    private Bitmap mBitmap;
    private int mEtWidth = 0;
    private int mEtHeight = 0;
    private float[] mImageMatrix = new float[9];
    private EditText[] mETs = new EditText[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape_color_matrix);
        mGridGroup = (GridLayout) findViewById(R.id.grid_group);
        mMyView = (ImageMatrixView) findViewById(R.id.view);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        mGridGroup.post(new Runnable() {
            @Override
            public void run() {
                mEtWidth = mGridGroup.getWidth() / 3;
                mEtHeight = mGridGroup.getHeight() / 3;
                addEts();
                initImageMatrix();
            }
        });
    }

    private void addEts() {
        for (int i = 0; i < 9; i++) {
            EditText et = new EditText(ImageMatrixTest.this);
            et.setGravity(Gravity.CENTER);
            mETs[i] = et;
            mGridGroup.addView(et, mEtWidth, mEtHeight);
        }
    }

    private void getImageMatrix() {
        for (int i = 0; i < 9; i++) {
            EditText et = mETs[i];
            mImageMatrix[i] = Float.valueOf(et.getText().toString());
        }
    }

    private void initImageMatrix() {
        for (int i = 0; i < 9; i++) {
            if (i % 4 == 0) {
                mETs[i].setText(String.valueOf(1));
            } else {
                mETs[i].setText(String.valueOf(0));
            }
        }
    }

    public void change(View view) {
        getImageMatrix();
        Matrix matrix = new Matrix();
        //matrix.setValues(mImageMatrix);

        /*set会重置矩阵中的所有值，post和pre方法用来实现矩阵的会和作用*/

        //matrix.setRotate(45);
        //matrix.postTranslate(200, 200);

        //matrix.setTranslate(200, 200);
        //matrix.preRotate(45);

        //matrix.setScale(2, 2);
        //matrix.postRotate(45);
        //matrix.postTranslate(200, 200);

        matrix.setSkew(0.9f, 0);
        matrix.postTranslate(200, 200);


        mMyView.setImageAndMatrix(mBitmap, matrix);
        mMyView.invalidate();
    }

    public void reset(View view) {
        initImageMatrix();
        getImageMatrix();
        Matrix matrix = new Matrix();
        matrix.setValues(mImageMatrix);
        mMyView.setImageAndMatrix(mBitmap, matrix);
        mMyView.invalidate();
    }
}
