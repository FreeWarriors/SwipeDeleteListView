package com.example.mrj.swipedeletelistview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;

/**
 * @author zhaoyapeng
 * @version create time:16/10/1715:38
 * @Email zyp@jusfoun.com
 * @Description ${滑动删除activiy}
 */
public class ListViewDeleteActivity extends ActionBarActivity {

    private DeleteAdapter adapter;
    private DeleteListView deleteListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_delete);
        deleteListView = (DeleteListView) findViewById(R.id.listview);
        adapter = new DeleteAdapter(this);
        deleteListView.setAdapter(adapter);
    }
}
