package com.example.week12;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.week12.fragments.FragmentAdd;
import com.example.week12.fragments.FragmentList;

public class TabPagerAdapter extends FragmentStateAdapter {


    public TabPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new FragmentList();
        }
        else {
            return new FragmentAdd();
        }
    }


    @Override
    public int getItemCount() {
        return 2;
    }
}
