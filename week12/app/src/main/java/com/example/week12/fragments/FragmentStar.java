package com.example.week12.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week12.MainActivity;
import com.example.week12.ProductAdapter;
import com.example.week12.R;
import com.example.week12.StarProductAdapter;
import com.example.week12.Storage;

public class FragmentStar extends Fragment {
    public FragmentStar() {
        // Required empty public constructor
    }
    private RecyclerView recyclerView;
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_star, container, false);
        recyclerView = view.findViewById(R.id.listOfStarProducts);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new StarProductAdapter(view.getContext(), Storage.getInstance().getStarredProducts()));

        ((MainActivity)getActivity()).setRefresher2(new MainActivity.Refresher2() {
            @Override
            public void onRefresh2() {
                recyclerView = view.findViewById(R.id.listOfStarProducts);
                recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                recyclerView.setAdapter(new StarProductAdapter(view.getContext(), Storage.getInstance().getStarredProducts()));
                }
        });

        return view;
    }
}
