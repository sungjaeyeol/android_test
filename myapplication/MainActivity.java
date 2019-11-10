package com.example.myapplication;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;
    TabLayout tabLayout;
    MyPagerAdapter adapter;
    ArrayList<Fragment> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tabs);
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
    }

    class MyPagerAdapter extends FragmentPagerAdapter {
        String[] titles = new String[]{"사진", "앨범", "스토리", "공유"};
        public MyPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
            list = new ArrayList<Fragment>();
            list.add(new Fragment1());
            list.add(new Fragment2());
            list.add(new Fragment3());
            list.add(new Fragment4());
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            //화면(Fragment 4개) 중에서 현재 position에 해당하는 fragment 리턴
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

    }
}
