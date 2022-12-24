package com.example.platform;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.widget.ScrollView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import java.util.ArrayList;
public class CoursePlayerActivity extends AppCompatActivity {

    private View lessonsLayout;

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

        lessonsLayout = findViewById(R.id.lessons_layout);


        Button hideLessonsBtn = findViewById(R.id.lessons);
        Button showLessonsBtn = findViewById(R.id.show_lessons_btn);
        hideLessonsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.FadeOutLeft)
                        .duration(800)
                        .repeat(0)
                        .playOn(lessonsLayout)
                ;
                Handler delayHandler = new Handler();
                delayHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        showLessonsBtn.setVisibility(View.VISIBLE);
                    }
                }, 500);


            }
        })
        ;

        showLessonsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLessonsBtn.setVisibility(View.GONE);
                YoYo.with(Techniques.BounceInLeft)
                        .duration(800)
                        .repeat(0)
                        .playOn(lessonsLayout);
            }
        });


        ArrayList<Lesson> lessons = new ArrayList<>();
        setupLessons(lessons);
        RecyclerView lessonsRecyclerView = findViewById(R.id.lessons_recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        lessonsRecyclerView.setLayoutManager(manager);
        Adapter lessonsAdapter = new Adapter(this.getBaseContext(), lessons, R.layout.course_player_lesson_card);
//        CoursePlayerLessonsAdapter lessonsAdapter = new CoursePlayerLessonsAdapter(this, lessons);
        lessonsRecyclerView.setAdapter(lessonsAdapter);
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

    private void setupLessons(ArrayList<Lesson> lessons) {
        for (int i = 0; i < 20; i++) {
            lessons.add(new Lesson("lesson", R.drawable.ic_baseline_radio_button_unchecked_24));
        }
    }
}