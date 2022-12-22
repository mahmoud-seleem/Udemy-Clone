package com.example.platform;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class CoursePlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_player);
        Button features_button = findViewById(R.id.features_button);
        ScrollView container = findViewById(R.id.features_container);
        ChipGroup chipGroup = findViewById(R.id.features_chip_group);
        final boolean[] containerIsOpen = {false};
        featuresContainerAnimation(container,features_button,containerIsOpen);
        for(int i =0 ; i<10;i++){
            chipGroup.addView(makeChip("",R.drawable.main_home_icon));
        }
    }

    private Chip makeChip(String name, int iconId) {
        Chip chip = new Chip(this);
        chip.setText(name);
        chip.setChipCornerRadius(90);
        chip.setChipBackgroundColor(ColorStateList.
                valueOf(Color.parseColor("#FFFFFF")));
        chip.setChipIcon(ContextCompat.getDrawable(this, iconId));
        chip.setChipIconTint(ColorStateList.valueOf(Color.parseColor("#4E60FE")));
//        chip.setScaleY(0.7f);
//        chip.setScaleX(0.7f);

        chip.ensureAccessibleTouchTarget(0);
        chip.setCheckable(true);
        chip.setIconStartPadding(8.0f);
        chip.setChipIconSize(60.0f);
//        chip.setScaleX(0.7f);
//        chip.setScaleY(0.7f);
//        chip.setMaxWidth(80);
        chip.setMinHeight(100);
        return chip;
    }
    private void featuresContainerAnimation(ScrollView container,Button features_button, final boolean[] containerIsOpen) {
        features_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (containerIsOpen[0] == true) {
                    container.animate()
                            // .translationYBy((float)(container.getBottom() - container.getTop())/4)
                            .scaleY(0.0f)
                            .setDuration(100)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    container.setVisibility(View.GONE);
                                }
                            });
                    containerIsOpen[0] = false;
                } else {
                    container.animate()
                            //.translationYBy(-(float)(container.getBottom() - container.getTop())/4)
                            .scaleY(1.0f)
                            .setDuration(100)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationStart(Animator animation) {
                                    container.setVisibility(View.VISIBLE);
                                }
                            });
                    containerIsOpen[0] = true;
                }
            }
        });
    }
}