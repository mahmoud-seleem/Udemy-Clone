package com.example.platform;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
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
        Adapter lessonsAdapter = new Adapter(this, lessons, R.layout.course_player_lesson_card);
        lessonsRecyclerView.setAdapter(lessonsAdapter);
    }

    private void setupLessons(ArrayList<Lesson> lessons) {
        for (int i = 0; i < 20; i++) {
            lessons.add(new Lesson("lesson", R.drawable.ic_baseline_radio_button_unchecked_24));
        }
    }
}