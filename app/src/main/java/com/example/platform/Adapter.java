package com.example.platform;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.CardViewHolder> {
    Context context;
    ArrayList<Lesson> lessons;
    int itemLayoutId;

    public Adapter(Context context, ArrayList<Lesson> lessons, int itemLayoutId) {
        this.itemLayoutId = itemLayoutId;
        this.context = context;
        if (itemLayoutId == R.layout.course_player_lesson_card) {
            this.lessons = lessons;
        }
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayoutId, null, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        if (itemLayoutId == R.layout.course_player_lesson_card) {
            Lesson lesson = lessons.get(position);
            holder.title.setText(lesson.getLessonTitle());
            holder.img.setImageResource(lesson.getLessonIcon());
            holder.img.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  holder.img.setImageResource(R.drawable.ic_baseline_check_circle_24);
                                              }
                                          }
            );
        }
    }

    @Override
    public int getItemCount() {
        int itemsSize = 0;
        if (itemLayoutId == R.layout.course_player_lesson_card) {
            itemsSize = lessons.size();
        }
        return itemsSize;
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            if (itemLayoutId == R.layout.course_player_lesson_card) {
                this.img = itemView.findViewById(R.id.lesson_checked_icon);
                this.title = itemView.findViewById(R.id.lesson_title);
            }

        }
    }
}
