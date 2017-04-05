package com.demo.lizejun.reporecyclerview.layoutmanager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.demo.lizejun.reporecyclerview.R;
import java.util.ArrayList;
import java.util.List;

public class LayoutManagerActivity extends Activity {

    private List<String> mTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_manager);
        init();
    }

    private void init() {
        mTitles = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            mTitles.add(String.valueOf(i));
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_content);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        LayoutManagerAdapter adapter = new LayoutManagerAdapter(mTitles);
        recyclerView.setAdapter(adapter);
    }
}
