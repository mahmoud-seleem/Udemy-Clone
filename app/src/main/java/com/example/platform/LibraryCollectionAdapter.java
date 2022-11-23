package com.example.platform;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;

public class LibraryCollectionAdapter extends RecyclerView.Adapter<LibraryCollectionAdapter.LibraryCollectionViewHolder> {
    ArrayList<LibraryCollectionCard> cards;
    Context context;
    RecyclerView parent;

    public LibraryCollectionAdapter(ArrayList<LibraryCollectionCard> cards, Context context, RecyclerView parent) {
        this.cards = cards;
        this.context = context;
        this.parent = parent;
    }

    @NonNull
    @Override
    public LibraryCollectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.library_collections_card, null, false);
        LibraryCollectionViewHolder libraryCollectionViewHolder = new LibraryCollectionViewHolder(view);
        return libraryCollectionViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LibraryCollectionViewHolder holder, int position) {
        LibraryCollectionCard libraryCollectionCard = cards.get(position);
        holder.cardImageView.setImageResource(libraryCollectionCard.getImageResourceId());
        holder.cardTitle.setText(libraryCollectionCard.getTitle());
        holder.cardDescription.setText(libraryCollectionCard.getDescription());
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    class LibraryCollectionViewHolder extends RecyclerView.ViewHolder {
        ImageView cardImageView;
        TextView cardTitle;
        TextView cardDescription;

        public LibraryCollectionViewHolder(@NonNull View itemView) {
            super(itemView);
//            if (cardLayoutResourceID == R.layout.main_article_card_layout_with_fixed_size) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((MainActivity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                int width = parent.getWidth();
                int height = displayMetrics.heightPixels;
                itemView.setLayoutParams(new RecyclerView.LayoutParams(width,height/8));
//            }
            cardImageView = itemView.findViewById(R.id.collection_ImageView);
            cardTitle = itemView.findViewById(R.id.collection_name);
            cardDescription = itemView.findViewById(R.id.articles_number);
        }
    }
}
