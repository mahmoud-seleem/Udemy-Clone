package com.example.platform;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AuthorsAdapter extends RecyclerView.Adapter<AuthorsAdapter.AuthorViewHolder> {
    private Context context;
    private ArrayList<Author> authorsList;
    private Fragment fragment;

    public AuthorsAdapter(Context context, ArrayList<Author> authorsList, Fragment fragment) {
        this.context = context;
        this.authorsList = authorsList;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public AuthorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourite_author_card,null,false);
        AuthorViewHolder authorViewHolder = new AuthorViewHolder(view);
        return authorViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AuthorViewHolder holder, int position) {
        Author favouriteAuthor = authorsList.get(position);
        holder.authorBio.setText(favouriteAuthor.getBio());
        holder.authorName.setText(favouriteAuthor.getName());
        holder.authorImage.setImageResource(favouriteAuthor.getImg());

    }

    @Override
    public int getItemCount() {
        return authorsList.size();
    }

    public class AuthorViewHolder extends RecyclerView.ViewHolder {

        ImageView authorImage;
        TextView authorName;
        TextView authorBio;

        public AuthorViewHolder(@NonNull View itemView) {
            super(itemView);
            this.authorImage = itemView.findViewById(R.id.favourite_author_image);
            this.authorName = itemView.findViewById(R.id.favourite_author_name);
            this.authorBio = itemView.findViewById(R.id.favourite_author_bio);
        }
    }


}
