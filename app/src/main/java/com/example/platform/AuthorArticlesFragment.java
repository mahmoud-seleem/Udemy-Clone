package com.example.platform;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AuthorArticlesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AuthorArticlesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AuthorArticlesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AuthorArticlesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AuthorArticlesFragment newInstance(String param1, String param2) {
        AuthorArticlesFragment fragment = new AuthorArticlesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_author_articles, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.card_recycler_view);
        ArrayList<ArticleCard> cards = new ArrayList<ArticleCard>();
        cards.add(new ArticleCard());
        cards.add(new ArticleCard());
        cards.add(new ArticleCard());
        cards.add(new ArticleCard());
        cards.add(new ArticleCard());
        cards.add(new ArticleCard());
        cards.add(new ArticleCard());
        cards.add(new ArticleCard());
        cards.add(new ArticleCard());
        cards.add(new ArticleCard());
        ArticleCardAdapter adapter = new ArticleCardAdapter(getContext(),this, cards,R.layout.main_article_card_layout,recyclerView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new SpaceItemDecoration(30,30));
        recyclerView.setHasFixedSize(true);
        return view;
    }
}