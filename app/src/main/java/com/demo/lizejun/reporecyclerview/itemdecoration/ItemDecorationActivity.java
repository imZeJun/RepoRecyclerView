package com.demo.lizejun.reporecyclerview.itemdecoration;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.demo.lizejun.reporecyclerview.BaseAdapter;
import com.demo.lizejun.reporecyclerview.R;
import java.util.ArrayList;
import java.util.List;

public class ItemDecorationActivity extends Activity {

    private List<String> mTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_decoration);
        init();
    }

    private void init() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_content);
        mTitles = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mTitles.add(String.valueOf(i));
        }
        BaseAdapter baseAdapter = new BaseAdapter(mTitles);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        GridDividerItemDecoration dividerItemDecoration = new GridDividerItemDecoration(this);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(baseAdapter);
    }
}
