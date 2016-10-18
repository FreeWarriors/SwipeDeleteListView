package com.example.mrj.swipedeletelistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.swipe.SwipeLayout;

/**
 * @author zhaoyapeng
 * @version create time:16/10/1715:43
 * @Email zyp@jusfoun.com
 * @Description ${TODO}
 */
public class DeleteItemView extends RelativeLayout {
    private Context mContext;
    SwipeLayout swipeLayout;
    private TextView topText,bottomText;

    public DeleteItemView(Context context) {
        super(context);
        mContext = context;
        initViews();
        initActions();
    }

    public DeleteItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initViews();
        initActions();
    }

    public DeleteItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initViews();
        initActions();
    }

    private void initViews() {
        LayoutInflater.from(mContext).inflate(R.layout.ietm_delete, this, true);
        swipeLayout = (SwipeLayout) findViewById(R.id.layout);
        topText = (TextView)findViewById(R.id.text_top);
        bottomText = (TextView)findViewById(R.id.text_bottom);
    }

    private void initActions() {





//set show mode.
        swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);

//set drag edge.
        swipeLayout.setDragEdge(SwipeLayout.DragEdge.Right);
        swipeLayout.addSwipeListener(new SwipeLayout.SwipeListener() {
            @Override
            public void onClose(SwipeLayout layout) {
                //when the SurfaceView totally cover the BottomView.
            }

            @Override
            public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {
                //you are swiping.
            }

            @Override
            public void onStartOpen(SwipeLayout layout) {

            }

            @Override
            public void onOpen(SwipeLayout layout) {
                //when the BottomView totally show.
            }

            @Override
            public void onStartClose(SwipeLayout layout) {

            }

            @Override
            public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {
                //when user's hand released.
            }
        });

        topText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"topText",Toast.LENGTH_SHORT).show();
            }
        });

        bottomText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"bottomText",Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void close() {
        swipeLayout.close();
    }

    public boolean isOpen() {

        if (swipeLayout.getOpenStatus() == SwipeLayout.Status.Open) {
            return true;
        }
        return false;

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }
}
