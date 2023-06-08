package com.example.week11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;

import com.example.week11.fragments.FragmentAdd;
import com.example.week11.fragments.FragmentList;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private Storage storage;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tabLayout = findViewById(R.id.tabArea);

        storage = Storage.getInstance();
        /*recyclerView = findViewById(R.id.listOfThings);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ProductAdapter(getApplicationContext(), storage.getStarredProducts()));
        Button btnFragmentAdd = findViewById(R.id.btnAddFragment);
        Button btnFragmentList = findViewById(R.id.btnProducts);

        btnFragmentAdd.setOnClickListener(listener);
        btnFragmentList.setOnClickListener(listener);*/


    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerView.setAdapter(new ProductAdapter(getApplicationContext(), storage.getStarredProducts()));
    }
    /*
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment;
            switch (view.getId()){
                case(R.id.btnAddFragment):
                    fragment = new FragmentAdd();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment).commit();

                    break;
                case(R.id.btnProducts):
                    fragment = new FragmentList();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment).commit();
                    break;
                default:
                    break;
            }
        }
    };
    */

    /*public void sort(View view){
        Button button = view.findViewById(R.id.btnSortId);
        if (button.getText().toString().equals("Sort by time")){
            button.setText("Sort by Alphabet");
            sortId(view);
        }
        else{
            button.setText("Sort by time");
            sortAlpha(view);
        }
    }*/

    public void sortId(View view){
        storage.sortId();
        onResume();
    }
    public void sortAlpha(View view){
        storage.sortAlpha();
        onResume();
    }



}












