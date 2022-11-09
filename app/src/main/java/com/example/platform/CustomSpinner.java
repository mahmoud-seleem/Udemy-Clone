package com.example.platform;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputLayout;

public class CustomSpinner extends androidx.appcompat.widget.AppCompatSpinner {
//    int[] prev ;

    public CustomSpinner(@NonNull Context context) {
        super(context);
    }

    public CustomSpinner(@NonNull Context context, int mode) {
        super(context, mode);
    }

    public CustomSpinner(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomSpinner(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomSpinner(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int mode) {
        super(context, attrs, defStyleAttr, mode);
    }

    public CustomSpinner(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int mode, Resources.Theme popupTheme) {
        super(context, attrs, defStyleAttr, mode, popupTheme);
    }
//    int[] current;


    @Override
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] states = getDrawableState();
        System.out.println("----------------------------------");
        for (int i = 0; i < states.length; i++) {
            switch (states[i]){
                case android.R.attr.state_above_anchor:
                    System.out.printf("state %d %s%n", i,"anchor");
                    break;
                case android.R.attr.state_accelerated:
                    System.out.printf("state %d %s%n", i,"accelerate");
                    break;
                case android.R.attr.stackFromBottom:
                    System.out.printf("state %d %s%n", i,"stack");
                    break;
                case android.R.attr.state_activated:
                    System.out.printf("state %d %s%n", i,"activated");
                    break;
                case android.R.attr.state_active:
                    System.out.printf("state %d %s%n", i,"active");
                    break;
                case android.R.attr.state_checkable:
                    System.out.printf("state %d %s%n", i,"checkable");
                    break;
                case android.R.attr.state_checked:
                    System.out.printf("state %d %s%n", i,"checked");
                    break;
                case android.R.attr.state_drag_can_accept:
                    System.out.printf("state %d %s%n", i,"drag accept");
                    break;
                case android.R.attr.state_drag_hovered:
                    System.out.printf("state %d %s%n", i,"drag hovered");
                    break;
                case android.R.attr.state_empty:
                    System.out.printf("state %d %s%n", i,"empty");
                    break;
                case android.R.attr.state_enabled:
                    System.out.printf("state %d %s%n", i,"enabled");
                    break;
                case android.R.attr.state_expanded:
                    System.out.printf("state %d %s%n", i,"expanded");
                    break;
                case android.R.attr.state_first:
                    System.out.printf("state %d %s%n", i,"first");
                    break;
                case android.R.attr.state_focused:
                    System.out.printf("state %d %s%n", i,"focused");
                    break;
                case android.R.attr.state_hovered:
                    System.out.printf("state %d %s%n", i,"hovered");
                    break;
                case android.R.attr.state_last:
                    System.out.printf("state %d %s%n", i,"last");
                    break;
                case android.R.attr.state_middle:
                    System.out.printf("state %d %s%n", i,"middle");
                    break;
                case android.R.attr.state_multiline:
                    System.out.printf("state %d %s%n", i,"multiline");
                    break;
                case android.R.attr.state_pressed:
                    System.out.printf("state %d %s%n", i,"pressed");
                    break;
                case android.R.attr.state_selected:
                    System.out.printf("state %d %s%n", i,"selected");
                    break;
                case android.R.attr.state_single:
                    System.out.printf("state %d %s%n", i,"single");
                    break;
                case android.R.attr.state_window_focused:
                    System.out.printf("state %d %s%n", i,"window focused");
                    break;
                case android.R.attr.stateNotNeeded:
                    System.out.printf("state %d %s%n", i,"not needed");
                    break;
                case android.R.attr.stateListAnimator:
                    System.out.printf("state %d %s%n", i,"list animator");
                    break;
                case android.R.attr.state_long_pressable:
                    System.out.printf("state %d %s%n", i,"long pressable");
                    break;
                case android.R.attr.alwaysRetainTaskState:
                    System.out.printf("state %d %s%n", i,"tetain task state");
                    break;
                case android.R.attr.cantSaveState:
                    System.out.printf("state %d %s%n", i,"cant save state ");
                    break;
                case android.R.attr.disableDependentsState:
                    System.out.printf("state %d %s%n", i,"disable dependent state");
                    break;
                case android.R.attr.duplicateParentState:
                    System.out.printf("state %d %s%n", i,"duplicate parent state");
                    break;
                case android.R.attr.addStatesFromChildren:
                    System.out.printf("state %d %s%n", i,"children");
                    break;
            }
        }
        System.out.println("----------------------------------");
        System.out.println("-------------" + states.length + "------------");
        System.out.println("--------------states finished-------------");
    }

//    public void copy(int[] array1, int[] array2) {
//
//    }
//
//    public void findDiff(int[] array1, int[] array2) {
//        for (int i = 0; i < array1.length; i++) {
//            for(int j = 0 ;j<array2.length;j++){
//                if(array1[i] == array2[j]){
//                    System.out.println(array1[i]+"is exist in both ");
//                    break;
//                }
//            }
//        }
//    }
}
