package com.aosama.it.utiles;

import android.view.View;

import androidx.viewpager.widget.ViewPager;

public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.65f;
    private static final float MIN_ALPHA = 0.3f;

    @Override
    public void transformPage(View view, float position) {
        view.setTranslationX(view.getWidth() * -position);

        if (position <= -1.0F || position >= 1.0F) {
            view.setAlpha(0.0F);
        } else if (position == 0.0F) {
            view.setAlpha(1.0F);
        } else {
            // position is between -1.0F & 0.0F OR 0.0F & 1.0F
            view.setAlpha(1.0F - Math.abs(position));
        }
    }
}