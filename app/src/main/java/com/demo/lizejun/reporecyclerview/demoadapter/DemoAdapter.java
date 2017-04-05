package com.demo.lizejun.reporecyclerview.demoadapter;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.demo.lizejun.reporecyclerview.R;
import java.util.ArrayList;
import java.util.List;

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.NormalViewHolder> {

    private List<String> mTitles = new ArrayList<>();

    public DemoAdapter(List<String> titles) {
        mTitles = titles;
    }

    @Override
    public NormalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        switch (viewType) {
            case 0:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_normal_item_1, parent, false);
                break;
            case 1:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_normal_item_2, parent, false);
                break;
            case 2:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_normal_item_3, parent, false);
                break;

        }
        NormalViewHolder viewHolder = new NormalViewHolder(itemView);
        Log.d("DemoAdapter", "onCreateViewHolder, address=" + viewHolder.toString() + ",viewType=" + viewType);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NormalViewHolder holder, int position) {
        Log.d("DemoAdapter", "onBindViewHolder, address=" + holder.toString() + ",position=" + position + ",viewType" + getItemViewType(position));
        int viewType = getItemViewType(position);
        String title = mTitles.get(position);
        holder.setTitle1("title=" + title + ",viewType=" + viewType);

    }

    @Override
    public int getItemCount() {
        return mTitles.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position % 3;
    }


    @Override
    public void onViewRecycled(NormalViewHolder holder) {
        Log.d("DemoAdapter", "onViewRecycled=" + holder);
        super.onViewRecycled(holder);
    }

    @Override
    public void onViewDetachedFromWindow(NormalViewHolder holder) {
        Log.d("DemoAdapter", "onViewDetachedFromWindow=" + holder);
        super.onViewDetachedFromWindow(holder);
    }

    @Override
    public void onViewAttachedToWindow(NormalViewHolder holder) {
        Log.d("DemoAdapter", "onViewAttachedToWindow=" + holder);
        super.onViewAttachedToWindow(holder);
    }


    class NormalViewHolder extends RecyclerView.ViewHolder {

        private TextView mTv1;


        NormalViewHolder(View itemView) {
            super(itemView);
            mTv1 = (TextView) itemView.findViewById(R.id.tv_title_1);
        }

        void setTitle1(String title) {
            mTv1.setText(title);
        }

    }
}
