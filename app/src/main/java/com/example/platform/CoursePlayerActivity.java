package com.example.platform;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

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

    }
}