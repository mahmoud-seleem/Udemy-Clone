package com.example.platform;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingParent;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerView extends RecyclerView implements NestedScrollingParent {

    private View nestedScrollTarget = null;
    private boolean nestedScrollTargetIsBeingDragged = false;
    private boolean nestedScrollTargetWasUnableToScroll = false;
    private boolean skipsTouchInterception = false;

    public MyRecyclerView(@NonNull Context context) {
        super(context);
    }

    public MyRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return (nestedScrollAxes != 0 && View.SCROLL_AXIS_HORIZONTAL != 0);
    }

    @Override
    public void onStopNestedScroll(View child) {
        nestedScrollTarget = null;
        nestedScrollTargetIsBeingDragged = false;
        nestedScrollTargetWasUnableToScroll = false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View temporarilySkipsInterception = nestedScrollTarget;
        if (temporarilySkipsInterception!=null){
            skipsTouchInterception = true;
        }
        boolean handled =  super.dispatchTouchEvent(ev);
        if (temporarilySkipsInterception != null){
            skipsTouchInterception = false;
            if (!handled || nestedScrollTargetWasUnableToScroll) {
                handled = super.dispatchTouchEvent(ev);
            }
        }
        return handled;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        return (!skipsTouchInterception && super.onInterceptTouchEvent(e));
    }

    @Override
    public void onNestedScrollAccepted(View child, View target, int axes) {
        if (axes != 0 && View.SCROLL_AXIS_HORIZONTAL != 0) {
            // A descendent started scrolling, so we'll observe it.
            nestedScrollTarget = target;
            nestedScrollTargetIsBeingDragged = false;
            nestedScrollTargetWasUnableToScroll = false;
        }
        super.onNestedScrollAccepted(child, target, axes);

    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        if (target == nestedScrollTarget && !nestedScrollTargetIsBeingDragged) {
            if (dyConsumed != 0) {
                nestedScrollTargetIsBeingDragged = true;
                nestedScrollTargetWasUnableToScroll = false;
            } else if (dyConsumed == 0 && dyUnconsumed != 0) {
                // The descendent tried scrolling in response to touch movements but was not able to do so.
                // We remember that in order to allow RecyclerView to take over scrolling.
                nestedScrollTargetWasUnableToScroll = true;
                target.getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
    }
}
