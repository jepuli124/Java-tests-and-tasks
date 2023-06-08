package com.example.week12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.example.week12.fragments.FragmentStar;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private static MainActivity mainActivity = null;
    public static MainActivity getInstance(){
        if(mainActivity == null){
            mainActivity = new MainActivity();
        }
        return  mainActivity;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mainactivity);

        TabLayout tabLayout = findViewById(R.id.tabArea);
        ViewPager2 fragmentArea = findViewById(R.id.fragmentArea);
        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(this);
        fragmentArea.setAdapter(tabPagerAdapter);
        FragmentStar starFragment = new FragmentStar();
        getSupportFragmentManager().beginTransaction().add(R.id.starArea, starFragment).commit();



        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                fragmentArea.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        fragmentArea.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });

    }
    public void addProduct(View view){
        Storage.getInstance().addProduct(new Product("Empty", 0, false));
        refresher.onRefresh();
        refresher2.onRefresh2();
    }

    public void addStarProduct(View view){
        Storage.getInstance().addProduct(new Product("Empty", 0, true));
        refresher.onRefresh();
        refresher2.onRefresh2();
    }
    private Refresher refresher;
    private Refresher2 refresher2;

    public Refresher getRefresher() {
        return refresher;
    }
    public Refresher2 getRefresher2() {
        return refresher2;
    }
    public void setRefresher(Refresher refresher) {
        this.refresher = refresher;
    }
    public void setRefresher2(Refresher2 refresher2) {
        this.refresher2 = refresher2;
    }

    public interface Refresher{
        void onRefresh();
    }

    public interface Refresher2{
        void onRefresh2();
    }

}
