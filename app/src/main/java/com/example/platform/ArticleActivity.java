package com.example.platform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        ChipGroup group = findViewById(R.id.chips);
        Chip chip = makeChip("Platform",R.drawable.main_authors_icon);
        group.addView(chip);
    }
    private Chip makeChip(String name, int iconId) {
        Chip chip = new Chip(this);
        chip.setText(name);
        chip.setChipCornerRadius(30);
        chip.setChipBackgroundColor(ColorStateList.
                valueOf(Color.parseColor("#C9CACD")));
        chip.setChipIcon(ContextCompat.getDrawable(this, iconId));
        return chip;
    }
}