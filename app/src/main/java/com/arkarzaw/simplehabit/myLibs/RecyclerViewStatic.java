package com.arkarzaw.simplehabit.myLibs;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class RecyclerViewStatic extends RecyclerView {
    public RecyclerViewStatic(Context context) {
        super(context);
    }

    public RecyclerViewStatic(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RecyclerViewStatic(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        int heightMeasureSpec_custom = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthSpec, heightMeasureSpec_custom);
        ViewGroup.LayoutParams params = getLayoutParams();
        params.height = getMeasuredHeight();
    }
}
