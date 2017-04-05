package com.demo.lizejun.reporecyclerview;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class BaseAdapter extends RecyclerView.Adapter<BaseAdapter.BaseViewHolder> {

    private List<String> mTitles;

    public BaseAdapter(List<String> titles) {
        mTitles = titles;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_base_item, parent, false);
        return new BaseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.setTitle(mTitles.get(position));
    }


    @Override
    public int getItemCount() {
        return mTitles.size();
    }

    class BaseViewHolder extends RecyclerView.ViewHolder {

        private TextView mTv;

        BaseViewHolder(View itemView) {
            super(itemView);
            mTv = (TextView) itemView.findViewById(R.id.tv_title_1);
        }

        void setTitle(String title) {
            mTv.setText(title);
        }

    }
}
