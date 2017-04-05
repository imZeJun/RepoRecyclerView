package com.demo.lizejun.reporecyclerview.itemtouchhelper;


import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class AdvancedItemTouchHelper extends ItemTouchHelper.Callback {

    private ItemTouchAdapter mAdapter;

    public AdvancedItemTouchHelper(ItemTouchAdapter itemTouchAdapter) {
        mAdapter = itemTouchAdapter;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return makeMovementFlags(0, ItemTouchHelper.LEFT);
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        mAdapter.onItemSwiped(viewHolder.getAdapterPosition());
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        ((NormalAdapter.NormalViewHolder) viewHolder).mTv.setTranslationX(0);
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        NormalAdapter.NormalViewHolder mViewHolder = (NormalAdapter.NormalViewHolder) viewHolder;
        int deleteWidth = mViewHolder.mDeleteLayout.getWidth();
        float fraction = deleteWidth / (float) mViewHolder.itemView.getWidth();
        mViewHolder.mTv.setTranslationX(dX * fraction);
    }
}
