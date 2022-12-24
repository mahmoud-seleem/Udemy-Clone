package com.example.platform;


import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;

public class AuthorCollectionAdapter extends RecyclerView.Adapter<AuthorCollectionAdapter.CardViewHolder> {

    ArrayList<AuthorCollection> cards;
    Context context;
    int cardLayoutId;
    Fragment fragment;

    public AuthorCollectionAdapter(ArrayList<AuthorCollection> cards, Context context, int cardLayoutId, Fragment fragment) {
        this.cards = cards;
        this.context = context;
        this.cardLayoutId = cardLayoutId;
        this.fragment = fragment;
    }


    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(cardLayoutId, null, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        AuthorCollection collection = cards.get(position);
        holder.collectionImg.setImageResource(collection.getImg());
        holder.collectionTitle.setText(collection.getTitle());
        holder.articlesNumber.setText(collection.getArticlesNumber());
        holder.cardChipGroup.removeAllViews();
        for (Tag tag : collection.getTags()) {
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

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView collectionImg;
        TextView collectionTitle;
        TextView articlesNumber;
        ChipGroup cardChipGroup;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            if (fragment instanceof Author_profile_Fragment) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((MainActivity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                int width = displayMetrics.widthPixels;
                itemView.setLayoutParams(new RecyclerView.LayoutParams(width / 3, RecyclerView.LayoutParams.MATCH_PARENT));
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((MainActivity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int width = displayMetrics.widthPixels;
            itemView.setLayoutParams(new RecyclerView.LayoutParams(width / 3, RecyclerView.LayoutParams.MATCH_PARENT));
            this.collectionImg = itemView.findViewById(R.id.author_collection_imageView);
            this.collectionTitle = itemView.findViewById(R.id.title_text_view);
            this.articlesNumber = itemView.findViewById(R.id.articles_in_collection_number);
            this.cardChipGroup = itemView.findViewById(R.id.chip_group_collections);
        }


    }
}
