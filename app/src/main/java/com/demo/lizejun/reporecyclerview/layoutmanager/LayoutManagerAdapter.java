package com.demo.lizejun.reporecyclerview.layoutmanager;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.demo.lizejun.reporecyclerview.R;
import java.util.List;

public class LayoutManagerAdapter extends RecyclerView.Adapter<LayoutManagerAdapter.LayoutManagerViewHolder> {

    private List<String> mTitles;
    private static final int[] COLOR = new int[] {
            android.R.color.holo_red_light,
            android.R.color.holo_green_light,
            android.R.color.holo_blue_light,
            android.R.color.holo_orange_light,
            android.R.color.darker_gray };

    public LayoutManagerAdapter(List<String> title) {
        mTitles = title;
    }

    @Override
    public LayoutManagerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_manager_item, parent, false);
        LayoutManagerViewHolder viewHolder =  new LayoutManagerViewHolder(itemView);
        Log.d("LayoutManagerAdapter", "onCreateViewHolder, address=" + viewHolder.toString());
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(LayoutManagerViewHolder holder, int position) {
        holder.setTitle(mTitles.get(position));
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        layoutParams.height = 200 + (position % 4) * 200;
        holder.itemView.setBackgroundColor(holder.itemView.getResources().getColor(COLOR[position % 5]));
        holder.itemView.setLayoutParams(layoutParams);
    }

    @Override
    public int getItemCount() {
        return mTitles.size();
    }

    class LayoutManagerViewHolder extends RecyclerView.ViewHolder {

        private TextView mTv;

        LayoutManagerViewHolder(View itemView) {
            super(itemView);
            mTv = (TextView) itemView.findViewById(R.id.tv_title);
        }

        void setTitle(String title) {
            mTv.setText(title);
        }

    }
}
