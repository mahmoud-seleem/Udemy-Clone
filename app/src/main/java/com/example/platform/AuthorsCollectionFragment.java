package com.example.platform;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AuthorsCollectionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AuthorsCollectionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AuthorsCollectionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment authorsCollectionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AuthorsCollectionFragment newInstance(String param1, String param2) {
        AuthorsCollectionFragment fragment = new AuthorsCollectionFragment();
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
        View view = inflater.inflate(R.layout.fragment_authors_collection, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.authors_collection_recyclerView);
        ArrayList<AuthorCollection> collections = new ArrayList<AuthorCollection>();
        for (int i = 0; i < 20; i++) {
            collections.add(new AuthorCollection(R.drawable.ic_launcher_background, "platform", "6"));
        }
        AuthorCollectionAdapter adapter = new AuthorCollectionAdapter(collections, getContext(), R.layout.authors_collection_card, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new SpaceItemDecoration(30,30));
        recyclerView.setHasFixedSize(true);
        return view;
    }
}