package com.demo.lizejun.reporecyclerview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.demo.lizejun.reporecyclerview.demoadapter.DemoActivity;
import com.demo.lizejun.reporecyclerview.itemdecoration.ItemDecorationActivity;
import com.demo.lizejun.reporecyclerview.itemtouchhelper.ItemTouchHelperActivity;
import com.demo.lizejun.reporecyclerview.layoutmanager.LayoutManagerActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void normalActivity(View view) {
        Intent intent = new Intent(this, DemoActivity.class);
        startActivity(intent);
    }

    public void layoutManagerActivity(View view) {
        Intent intent = new Intent(this, LayoutManagerActivity.class);
        startActivity(intent);
    }

    public void itemDecorationActivity(View view) {
        Intent intent = new Intent(this, ItemDecorationActivity.class);
        startActivity(intent);
    }

    public void itemTouchHelperActivity(View view) {
        Intent intent = new Intent(this, ItemTouchHelperActivity.class);
        startActivity(intent);
    }
}
