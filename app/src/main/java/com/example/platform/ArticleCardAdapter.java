package com.example.platform;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;

public class ArticleCardAdapter extends RecyclerView.Adapter<ArticleCardAdapter.CardViewHolder> {
    ArrayList<ArticleCard> cards;
    Context context;
    int cardLayoutResourceID;
    Fragment fragment;
    RecyclerView parent;
    public ArticleCardAdapter(Context context, Fragment fragment, ArrayList<ArticleCard> cards, int cardLayoutResourceID,RecyclerView parent) {
        this.cards = cards;
        this.context = context;
        this.cardLayoutResourceID = cardLayoutResourceID;
        this.fragment = fragment;
        this.parent = parent;
    }

    @SuppressLint("ClickableViewAccessibility")
    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(cardLayoutResourceID, null, false);
        CardViewHolder cardViewHolder = new CardViewHolder(view);
        return cardViewHolder;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        ArticleCard card = cards.get(position);
        holder.cardImageView.setImageResource(card.getImageResourceId());
        holder.cardTitle.setText(card.getArticleTitle());
        String duration = card.getMinimumReadingTime() + "-" + card.getMaxReadingTime() + " min";
        holder.cardDuration.setText(duration);
        for (Tag tag : card.getTags()) {
            Chip chip = makeChip(tag.getTagName(), tag.getTagIconResourceId());
            holder.cardChipGroup.addView(chip);
        }
//        if (fragment instanceof Author_profile_Fragment) {
//            holder.scrollView.setOnTouchListener(new View.OnTouchListener() {
//                @Override
//                public boolean onTouch(View view, MotionEvent motionEvent) {
//                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
//                        ((Author_profile_Fragment) fragment).
//                                stopRecyclerHorizontalScrolling(true);
//                        return true;
//                    } else if (motionEvent.getAction() == MotionEvent.ACTION_CANCEL
//                            || motionEvent.getAction() == MotionEvent.ACTION_UP) {
//                        ((Author_profile_Fragment) fragment).
//                                stopRecyclerHorizontalScrolling(false);
//                        return true;
//                    }
//                    return false;
//
//                }
//            });
        }
    @Override
    public int getItemCount() {
        return cards.size();
    }

    private Chip makeChip(String name, int iconId) {
        Chip chip = new Chip(context);
        chip.setText(name);
        chip.setChipCornerRadius(30);
        chip.setChipBackgroundColor(ColorStateList.
                valueOf(Color.parseColor("#FFE0E0E0")));
        chip.setChipIcon(ContextCompat.getDrawable(context, iconId));
        chip.setScaleY(0.7f);
        chip.setScaleX(0.7f);
        chip.ensureAccessibleTouchTarget(0);
//        chip.setScaleX(0.7f);
//        chip.setScaleY(0.7f);
        return chip;
    }

    class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView cardImageView;
        TextView cardTitle;
        TextView cardDuration;
        ChipGroup cardChipGroup;
        HorizontalScrollView scrollView;

        @SuppressLint("ClickableViewAccessibility")
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            if (cardLayoutResourceID == R.layout.main_article_card_layout_with_fixed_size) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((MainActivity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                int width = displayMetrics.widthPixels;
                itemView.setLayoutParams(new RecyclerView.LayoutParams(width / 3, RecyclerView.LayoutParams.MATCH_PARENT));
            }

            scrollView = itemView.findViewById(R.id.horizontalScrollView);
            cardImageView = itemView.findViewById(R.id.card_image_view);
            cardTitle = itemView.findViewById(R.id.title_text_view);
            cardDuration = itemView.findViewById(R.id.duration_text_view);
            cardChipGroup = itemView.findViewById(R.id.chip_group);
        }
    }
}
