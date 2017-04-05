package com.demo.lizejun.reporecyclerview.itemtouchhelper;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

public class SimpleItemTouchHelper extends ItemTouchHelper.Callback {


    private ItemTouchAdapter mAdapter;

    public SimpleItemTouchHelper(ItemTouchAdapter adapter) {
        mAdapter = adapter;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return super.isLongPressDragEnabled();
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return super.isItemViewSwipeEnabled();
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        Log.d("SimpleItemTouchHelper", "onSwiped, onMove, source=" + viewHolder.getAdapterPosition() + ",target=" + target.getAdapterPosition());
        mAdapter.onItemDragged(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        Log.d("SimpleItemTouchHelper", "onSwiped, direction=" + direction);
        mAdapter.onItemSwiped(viewHolder.getAdapterPosition());
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return makeMovementFlags(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
        Log.d("SimpleItemTouchHelper", "onSelectedChanged, state=" + actionState);
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        Log.d("SimpleItemTouchHelper", "clearView");
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        Log.d("SimpleItemTouchHelper", "onChildDraw, dx=" + dX + ",dy=" + dY + ",actionState=" + actionState);
    }
}
