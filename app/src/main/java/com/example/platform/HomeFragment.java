package com.example.platform;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.card_recycler_view);
        ChipGroup chipGroup = view.findViewById(R.id.chip_group);
        initializeChipGroup(chipGroup);
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
        ArticleCardAdapter adapter = new ArticleCardAdapter(getContext(),this, cards,R.layout.main_article_card_layout,recyclerView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new SpaceItemDecoration(30,30));
        recyclerView.setHasFixedSize(true);
        return view;
    }
    private Chip makeChip(String name, int iconId) {
        Chip chip = new Chip(getContext());
        chip.setText(name);
        chip.setChipCornerRadius(30);
        chip.setChipBackgroundColor(ColorStateList.
                valueOf(Color.parseColor("#FFE0E0E0")));
        chip.setChipIcon(ContextCompat.getDrawable(getContext(), iconId));
//        chip.setScaleY(0.7f);
//        chip.setScaleX(0.7f);
        chip.ensureAccessibleTouchTarget(0);
        chip.setCheckable(true);
//        chip.setScaleX(0.7f);
//        chip.setScaleY(0.7f);
        return chip;
    }
    private void initializeChipGroup(ChipGroup chipGroup){
        chipGroup.removeAllViews();
        for(int i=0;i<20;i++){
            Chip chip = makeChip("Home",R.drawable.main_home_icon);
            chip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b){
                        chip.setChipStrokeColor(ColorStateList.valueOf(Color.parseColor("#4E60FE")));
                        chip.setTextColor(Color.parseColor("#4E60FE"));
                        chip.setChipIconTint(ColorStateList.valueOf(Color.parseColor("#4E60FE")));
                    }else{
                        chip.setChipStrokeColor(ColorStateList.valueOf(Color.parseColor("#2B2B43")));
                        chip.setTextColor(Color.parseColor("#FF000000"));
                        chip.setChipIconTint(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));

                    }
                }
            });
            chipGroup.addView(chip);
        }
    }
}