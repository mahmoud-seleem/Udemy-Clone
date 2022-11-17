package com.example.platform;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsAccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsAccountFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SettingsAccountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingsAccountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingsAccountFragment newInstance(String param1, String param2) {
        SettingsAccountFragment fragment = new SettingsAccountFragment();
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

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View  view =  inflater.inflate(R.layout.fragment_settings_account, container, false);
        AutoCompleteTextView spinner = view.findViewById(R.id.auto);
        String[] items = {"mahmoud","mohamed","seleem"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,items);
        spinner.setAdapter(adapter);
        MyConstraintLayout constraintLayout = view.findViewById(R.id.parent);
        constraintLayout.getaAllEditTexts(constraintLayout);
        //View view2 = view.findViewById(R.id.view2);
        //ConstraintLayout constraintLayout = view.findViewById(R.id.parent);
        //EditText editText = view.findViewById(R.id.editTextTextPersonName);
//        view2.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                View currentFocus = getActivity().getCurrentFocus();
//                if (!(currentFocus instanceof EditText)) {
//                    if(currentFocus != null){
//                    System.out.println(currentFocus.getClass().getName());
////                        editText.setCursorVisible(false);
//                }else {
//                        System.out.println("nullllllllllllllllllllllllllllllllll");
//                    }
//                    editText.setBackgroundColor(Color.parseColor("#000000"));
//                    editText.clearFocus();
//                }else {
//                    System.out.println("editttttttttttttttttttttttttttttttttttt");
//                }
//                return true;
//            }
//        });
        return view;
    }
}