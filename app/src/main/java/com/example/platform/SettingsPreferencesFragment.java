package com.example.platform;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.card.MaterialCardView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsPreferencesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsPreferencesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SettingsPreferencesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingsPreferencesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingsPreferencesFragment newInstance(String param1, String param2) {
        SettingsPreferencesFragment fragment = new SettingsPreferencesFragment();
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
        View view = inflater.inflate(R.layout.fragment_settings_preferences, container, false);
        MaterialCardView card1 = view.findViewById(R.id.card1);
        MaterialCardView card2 = view.findViewById(R.id.card2);
        MaterialCardView card3 = view.findViewById(R.id.card3);
        MyConstraintLayout constraintLayout3 = view.findViewById(R.id.parent3);
        MyConstraintLayout parentConstraintLayout = view.findViewById(R.id.parentx);
        MyConstraintLayout constraintLayout1 = view.findViewById(R.id.parent1);
        MyConstraintLayout constraintLayout2 = view.findViewById(R.id.parent2);
        MyConstraintLayout constraintLayout4 = view.findViewById(R.id.parent4);
        constraintLayout3.getaAllEditTexts(parentConstraintLayout);
        constraintLayout1.getaAllEditTexts(parentConstraintLayout);
        constraintLayout2.getaAllEditTexts(parentConstraintLayout);
        constraintLayout4.getaAllEditTexts(parentConstraintLayout);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                card1.setChecked(!card1.isChecked());
                if (card1.isChecked()) {
                    card1.setStrokeColor(ContextCompat.getColor(getContext(), R.color.blue));
                    card2.setChecked(false);
                    card2.setStrokeColor(ContextCompat.getColor(getContext(), R.color.gray_blue));
                    card3.setChecked(false);
                    card3.setStrokeColor(ContextCompat.getColor(getContext(), R.color.gray_blue));
                } else {
                    card1.setStrokeColor(ContextCompat.getColor(getContext(), R.color.gray_blue));
                }
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                card2.setChecked(!card2.isChecked());
                if (card2.isChecked()) {
                    card2.setStrokeColor(ContextCompat.getColor(getContext(), R.color.blue));
                    card1.setChecked(false);
                    card1.setStrokeColor(ContextCompat.getColor(getContext(), R.color.gray_blue));
                    card3.setChecked(false);
                    card3.setStrokeColor(ContextCompat.getColor(getContext(), R.color.gray_blue));
                } else {
                    card2.setStrokeColor(ContextCompat.getColor(getContext(), R.color.gray_blue));
                }
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                card3.setChecked(!card3.isChecked());
                if (card3.isChecked()) {
                    card3.setStrokeColor(ContextCompat.getColor(getContext(), R.color.blue));
                    card2.setChecked(false);
                    card2.setStrokeColor(ContextCompat.getColor(getContext(), R.color.gray_blue));
                    card1.setChecked(false);
                    card1.setStrokeColor(ContextCompat.getColor(getContext(), R.color.gray_blue));
                }
                else {
                    card3.setStrokeColor(ContextCompat.getColor(getContext(),R.color.gray_blue));
                }
            }
        });
        return view;
    }
}