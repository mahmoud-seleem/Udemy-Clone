package com.example.platform;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FollowingAuthorsAdapter extends RecyclerView.Adapter<FollowingAuthorsAdapter.AuthorViewHolder> {
    ArrayList<AuthorCard> cards;
    Context context;
    int cardLayoutResourceId;
    RecyclerView parent;

    public FollowingAuthorsAdapter(ArrayList<AuthorCard> cards, Context context,int cardLayoutResourceId,RecyclerView parent) {
        this.cards = cards;
        this.context = context;
        this.cardLayoutResourceId = cardLayoutResourceId;
        this.parent = parent;
    }

    @NonNull
    @Override
    public AuthorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(cardLayoutResourceId,null,false);
        AuthorViewHolder authorViewHolder = new AuthorViewHolder(view);
        return authorViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AuthorViewHolder holder, int position) {
        AuthorCard card = cards.get(position);
        holder.authorImageView.setImageResource(card.getAuthorImageResourceId());
        holder.authorNameTextView.setText(card.getAuthorName());
        holder.authorBioTextView.setText(card.getAuthorBio());

    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    class AuthorViewHolder extends RecyclerView.ViewHolder{

        ImageView authorImageView;
        TextView authorNameTextView;
        TextView authorBioTextView;

        public AuthorViewHolder(@NonNull View itemView) {
            super(itemView);
            authorImageView = itemView.findViewById(R.id.author_profile_image_view);
            authorNameTextView = itemView.findViewById(R.id.author_name);
            authorBioTextView = itemView.findViewById(R.id.author_bio);
            itemView.setLayoutParams(new RecyclerView.LayoutParams(parent.getWidth(),parent.getHeight()/5));

        }

    }
}
