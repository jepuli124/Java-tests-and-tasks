package com.example.week12.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.week12.MainActivity;
import com.example.week12.ProductAdapter;
import com.example.week12.R;
import com.example.week12.Storage;

public class FragmentList extends Fragment {

    public FragmentList() {
        // Required empty public constructor
    }
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = view.findViewById(R.id.listOfProducts);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new ProductAdapter(view.getContext(), Storage.getInstance().getProducts()));

        ((MainActivity)getActivity()).setRefresher(new MainActivity.Refresher() {
            @Override
            public void onRefresh() {
                recyclerView = view.findViewById(R.id.listOfProducts);
                recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                recyclerView.setAdapter(new ProductAdapter(view.getContext(), Storage.getInstance().getProducts()));
            }
        });
        return view;
    }
}