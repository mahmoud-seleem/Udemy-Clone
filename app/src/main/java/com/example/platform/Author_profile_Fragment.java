package com.example.platform;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Author_profile_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Author_profile_Fragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private boolean isstop;
    private MyConstraintLayout constraintLayout;
    public Author_profile_Fragment() {
        // Required empty public constructor
    }

    public Author_profile_Fragment(ConstraintLayout constraintLayout){
    this.constraintLayout = (MyConstraintLayout) constraintLayout;
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Author_profile_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Author_profile_Fragment newInstance(String param1, String param2) {
        Author_profile_Fragment fragment = new Author_profile_Fragment();
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
        View view = inflater.inflate(R.layout.fragment_author_profile_, container, false);
        MyConstraintLayout constraintLayout = view.findViewById(R.id.parent_constraint1);
        constraintLayout.getaAllEditTexts(this.constraintLayout);
        RecyclerView recyclerView = view.findViewById(R.id.articles_recycler_view);
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
        cards.add(new ArticleCard());
        ArticleCardAdapter adapter = new ArticleCardAdapter(getContext(),this, cards, R.layout.main_article_card_layout_with_fixed_size,recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new SpaceItemDecoration(0, 30));
        recyclerView.setHasFixedSize(true);
//        DisplayMetrics displayMetrics = new DisplayMetrics();
//        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//        int height = displayMetrics.heightPixels;
//        int width = displayMetrics.widthPixels;
//        float density = displayMetrics.density;
//        System.out.println("____________________________");
//        System.out.println((float) width / density);
//        System.out.println("____________________________");
        return view;
    }
//
//    public void stopRecyclerHorizontalScrolling(boolean stop) {
//        isstop = !stop;
//    }
}