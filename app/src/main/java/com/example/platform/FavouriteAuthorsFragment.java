package com.example.platform;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class FavouriteAuthorsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourite_authors, container, false).findViewById(R.id.favourite_authors_recycler_view);

        ArrayList<Author> favouriteAuthors = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            favouriteAuthors.add(new Author("Author", R.drawable.ic_launcher_background, "bioooo"));
        }

        AuthorsAdapter authorsListAdapter = new AuthorsAdapter(getContext(), favouriteAuthors, this);
        RecyclerView recyclerView = view.findViewById(R.id.favourite_authors_recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(authorsListAdapter);

        // Inflate the layout for this fragment
        return view;
    }
}