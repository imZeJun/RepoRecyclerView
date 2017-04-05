package com.demo.lizejun.reporecyclerview.itemdecoration;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class GridDividerItemDecoration extends RecyclerView.ItemDecoration {

    private static final int[] ATTRS = new int[] { android.R.attr.listDivider };
    private Drawable mDivider;
    private final Rect mBounds = new Rect();

    public GridDividerItemDecoration(Context context) {
        final TypedArray a = context.obtainStyledAttributes(ATTRS);
        mDivider = a.getDrawable(0);
        a.recycle();
    }

    public void setDrawable(@NonNull Drawable drawable) {
        mDivider = drawable;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        drawDivider(c, parent);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(0, 0, mDivider.getIntrinsicWidth(), mDivider.getIntrinsicHeight());
    }

    private void drawDivider(Canvas canvas, RecyclerView parent) {
        canvas.save();
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View view = parent.getChildAt(i);
            parent.getDecoratedBoundsWithMargins(view, mBounds);
            mDivider.setBounds(mBounds.right - mDivider.getIntrinsicWidth(), mBounds.top, mBounds.right, mBounds.bottom);
            mDivider.draw(canvas);
            mDivider.setBounds(mBounds.left, mBounds.bottom - mDivider.getIntrinsicHeight(), mBounds.right , mBounds.bottom);
            mDivider.draw(canvas);
        }
        canvas.restore();
    }

}
