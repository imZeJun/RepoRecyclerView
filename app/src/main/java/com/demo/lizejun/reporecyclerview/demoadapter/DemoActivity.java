package com.demo.lizejun.reporecyclerview.demoadapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.demo.lizejun.reporecyclerview.R;
import com.demo.lizejun.reporecyclerview.demoadapter.DemoAdapter;

import java.util.ArrayList;
import java.util.List;

public class DemoActivity extends Activity {

    private List<String> mTitles;
    private DemoAdapter mDemoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        init();
    }

    private void init() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_content);
        mTitles = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mTitles.add(String.valueOf(i));
        }
        mDemoAdapter = new DemoAdapter(mTitles);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mDemoAdapter);
    }
}
