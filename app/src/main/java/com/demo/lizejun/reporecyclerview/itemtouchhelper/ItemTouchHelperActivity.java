package com.demo.lizejun.reporecyclerview.itemtouchhelper;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import com.demo.lizejun.reporecyclerview.R;
import java.util.ArrayList;
import java.util.List;

public class ItemTouchHelperActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_touch_helper);
        init();
    }

    private void init() {
        List<String> titles = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            titles.add("Item " + String.valueOf(i));
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_content);
        recyclerView.setLayoutManager(layoutManager);
        NormalAdapter adapter = new NormalAdapter(titles);
        AdvancedItemTouchHelper advancedItemTouchHelper = new AdvancedItemTouchHelper(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(advancedItemTouchHelper);
        itemTouchHelper.attachToRecyclerView(recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
    }
}
