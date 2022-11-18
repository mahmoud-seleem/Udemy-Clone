package com.example.platform;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;

public class ArticleCardAdapter extends RecyclerView.Adapter<ArticleCardAdapter.CardViewHolder> {
    ArrayList<ArticleCard> cards;
    Context context;
    int cardLayoutResourceID;
    public ArticleCardAdapter(Context context, ArrayList<ArticleCard> cards,int cardLayoutResourceID) {
        this.cards = cards;
        this.context = context;
        this.cardLayoutResourceID = cardLayoutResourceID;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(cardLayoutResourceID, null, false);
        CardViewHolder cardViewHolder = new CardViewHolder(view);
        return cardViewHolder;
    }

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
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            cardImageView = itemView.findViewById(R.id.card_image_view);
            cardTitle = itemView.findViewById(R.id.title_text_view);
            cardDuration = itemView.findViewById(R.id.duration_text_view);
            cardChipGroup = itemView.findViewById(R.id.chip_group);
        }
    }
}
