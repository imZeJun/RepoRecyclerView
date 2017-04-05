package com.demo.lizejun.reporecyclerview.itemtouchhelper;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.lizejun.reporecyclerview.R;

import java.util.Collections;
import java.util.List;

public class NormalAdapter extends RecyclerView.Adapter<NormalAdapter.NormalViewHolder> implements ItemTouchAdapter {

    private List<String> mTitles;

    public NormalAdapter(List<String> titles) {
        mTitles = titles;
    }

    @Override
    public NormalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_normal_item, parent, false);
        return new NormalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NormalViewHolder holder, int position) {
        holder.mTv.setText(mTitles.get(position));
    }

    @Override
    public int getItemCount() {
        return mTitles.size();
    }

    class NormalViewHolder extends RecyclerView.ViewHolder {

        TextView mTv;
        LinearLayout mDeleteLayout;

        NormalViewHolder(View itemView) {
            super(itemView);
            mTv = (TextView) itemView.findViewById(R.id.tv_title);
            mDeleteLayout = (LinearLayout) itemView.findViewById(R.id.ll_delete);
        }
    }

    @Override
    public void onItemDragged(int from, int to) {
        Collections.swap(mTitles, from, to);
        notifyItemMoved(from, to);
    }

    @Override
    public void onItemSwiped(int position) {
        mTitles.remove(position);
        notifyItemRemoved(position);
    }
}
