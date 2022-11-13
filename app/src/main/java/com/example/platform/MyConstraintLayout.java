package com.example.platform;

import static android.content.Context.INPUT_METHOD_SERVICE;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class MyConstraintLayout extends ConstraintLayout {
    ArrayList<EditText> editTexts = new ArrayList<>();
    Context context;

    public MyConstraintLayout(@NonNull Context context) {
        super(context);
        this.context = context;

    }

    public MyConstraintLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public MyConstraintLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    public MyConstraintLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
    }

    public void getaAllEditTexts(ViewGroup parent) {
        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);
            if (child instanceof ViewGroup) {
                if (child instanceof ViewPager2) {
                    Fragment fragment = ((SettingsActivity) context).getSupportFragmentManager()
                            .findFragmentByTag("f" + ((ViewPager2) child).getCurrentItem());
                    if (fragment != null) {
                        getaAllEditTexts((ViewGroup) fragment.getView());
                    }
                } else {
                    getaAllEditTexts((ViewGroup) child);
                }
            } else if (child instanceof EditText) {
                editTexts.add((EditText) child);
            }
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int x = Math.round(ev.getX());
        int y = Math.round(ev.getY());
        clearEditTextFocus(this, x, y);
        return false;
    }

    public void clearEditTextFocus(ViewGroup parent, int x, int y) {
        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);
            if (child instanceof ViewGroup) {
                if (child instanceof ViewPager2) {
                    Fragment fragment = ((SettingsActivity) context).getSupportFragmentManager().findFragmentByTag("f" + ((ViewPager2) child).getCurrentItem());
                    if (fragment != null) {
                        clearEditTextFocus((ViewGroup) fragment.getView(), x, y);
                    }
                } else {
                    clearEditTextFocus((ViewGroup) child, x, y);
                }
            } else if ((!(child instanceof EditText))
                    && x > child.getLeft() && x < child.getRight()
                    && y > child.getTop() && y < child.getBottom()) {
                for (EditText editText : editTexts) {
                    InputMethodManager inputMethodManager = (InputMethodManager) (context).getSystemService(INPUT_METHOD_SERVICE);
                    View view = ((SettingsActivity) context).getCurrentFocus();
                    if (view != null){
                        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    }
                    editText.clearFocus();
                }
                break;
            }
        }
    }
}

