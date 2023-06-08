package com.example.week11.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.week11.Product;
import com.example.week11.R;
import com.example.week11.Storage;


public class FragmentAdd extends Fragment {

    public FragmentAdd() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false);
    }



    public void addProduct(View view){
        Storage.getInstance().addProduct(new Product("Empty", 0, false));
    }

    public void addStarProduct(View view){
        Storage.getInstance().addProduct(new Product("Empty", 0, true));
    }
}