package com.gavinandre.androidherosamples.chaptertwelve.palette;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.graphics.Palette;
import android.view.Window;

import com.gavinandre.androidherosamples.R;

public class PaletteActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.mipmap.palette);
        // 创建Palette对象
        Palette.Builder builder = Palette.from(bitmap);

        builder.generate(new Palette.PaletteAsyncListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onGenerated(Palette palette) {
                // 通过Palette来获取对应的色调
                Palette.Swatch vibrant = palette.getVibrantSwatch();
                if (vibrant == null) {
                    //api23后需要加判断
                    for (Palette.Swatch swatch : palette.getSwatches()) {
                        vibrant = swatch;
                        break;
                    }
                }
                // 这样获取的颜色可以进行改变。
                int rbg = vibrant.getRgb();
                int color = changeColor(rbg);
                // 将颜色设置给相应的组件
                getActionBar().setBackgroundDrawable(
                        new ColorDrawable(rbg));
                Window window = getWindow();
                window.setStatusBarColor(color);
            }
        });
    }

    // 对获取到的RGB颜色进行修改。
    private int changeColor(int rgb) {
        int red = rgb >> 16 & 0xFF;
        int green = rgb >> 8 & 0xFF;
        int blue = rgb & 0xFF;
        red = (int) Math.floor(red * (1 - 0.2));
        green = (int) Math.floor(green * (1 - 0.2));
        blue = (int) Math.floor(blue * (1 - 0.2));
        return Color.rgb(red, green, blue);
    }

}
