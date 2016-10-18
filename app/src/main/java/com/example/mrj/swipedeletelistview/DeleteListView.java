package com.example.mrj.swipedeletelistview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

/**
 * @author zhaoyapeng
 * @version create time:16/10/1715:40
 * @Email zyp@jusfoun.com
 * @Description ${TODO}
 */
public class DeleteListView extends ListView {
    public DeleteListView(Context context) {
        super(context);
    }

    public DeleteListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DeleteListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    float downX = 0;
    float downY = 0;
    float moveX = 0;
    float moveY = 0;
    int mTpuchPostion = -1;
    int mPrePosition = -1;

    private View mTouchView = null;

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        return super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        if (mTouchView != null) {
            mPrePosition = mTpuchPostion;
        }
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            downX = ev.getX();
            downY = ev.getY();
            mTpuchPostion = pointToPosition((int) downX, (int) downY);
            View view = getChildAt(mTpuchPostion - getFirstVisiblePosition());

            if (mPrePosition != mTpuchPostion && mTouchView != null) {
                // 触摸的是已打开的
                ((DeleteItemView) mTouchView).close();
                mTouchView = null;
                return true;
            } else {
                // 触摸的是未开的,此时需要进行判断 是否有被打开的
            }
            mTouchView = view;
        } else if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            moveX = ev.getX();
            moveY = ev.getY();

            if (Math.abs(moveX - downX) > Math.abs(moveY - downY) - 10) {
                Log.e("tag","onInterceptTouchEvent1");
                return false;
            } else {
                Log.e("tag","onInterceptTouchEvent2");
                return true;
            }
        } else if (ev.getAction() == MotionEvent.ACTION_UP) {
            moveY = 0;
            moveX = 0;
            downX = 0;
            downY = 0;
        }


        return super.onInterceptTouchEvent(ev);
    }
}
