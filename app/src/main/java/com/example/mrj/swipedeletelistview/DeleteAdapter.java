package com.example.mrj.swipedeletelistview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * @author zhaoyapeng
 * @version create time:16/10/1715:41
 * @Email zyp@jusfoun.com
 * @Description ${删除dapate}
 */
public class DeleteAdapter extends BaseAdapter {

    private Context mContext;

    public DeleteAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DeleteItemView view = new DeleteItemView(mContext);


        return view;
    }
}
