package com.example.platform;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CoursePlayerLessonsAdapter extends RecyclerView.Adapter<CoursePlayerLessonsAdapter.CardViewHolder> {

    Activity activity;
    ArrayList<Lesson> lessons;

    public CoursePlayerLessonsAdapter(Activity activity, ArrayList<Lesson> lessons) {
        this.activity = activity;
        this.lessons = lessons;
    }

    @NonNull
    @Override
    public CoursePlayerLessonsAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.course_player_lesson_card, parent, false);
        CardViewHolder cardViewHolder = new CardViewHolder(view);
        return cardViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Lesson lesson = lessons.get(position);
        holder.lessonIcon.setImageResource(lesson.getLessonIcon());
        holder.lessonTitle.setText(lesson.getLessonTitle());

    }

    @Override
    public int getItemCount() {
        return lessons.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        private ImageView lessonIcon;
        private TextView lessonTitle;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            lessonIcon = itemView.findViewById(R.id.lesson_checked_icon);
            lessonTitle = itemView.findViewById(R.id.lesson_title);
        }
    }
}
