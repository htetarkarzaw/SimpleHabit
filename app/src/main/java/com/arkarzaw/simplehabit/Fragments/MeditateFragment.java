package com.arkarzaw.simplehabit.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arkarzaw.simplehabit.R;

import java.util.ArrayList;
import java.util.List;

public class MeditateFragment extends Fragment {
    ViewPager vPager;
    TabLayout tLayout;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meditate, container, false);
        vPager=view.findViewById(R.id.vPager);
        tLayout=view.findViewById(R.id.tab);
        return view;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupViewPager(vPager);
        tLayout.setupWithViewPager(vPager);
        tLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }


    private void setupViewPager(ViewPager vPager) {
        MyPagerAdapter viewPagerAdapter = new MyPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragment(new OnthegoFragment(), "ON THE GO");
        viewPagerAdapter.addFragment(new NewSeriesFragment(), "SERIES");
        viewPagerAdapter.addFragment(new TeachersFragment(), "TEACHERS");
        vPager.setAdapter(viewPagerAdapter);
        vPager.setCurrentItem(1);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        List<Fragment> fragmentList = new ArrayList<>();
        List<String> fragmentTitles = new ArrayList<>();

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitles.get(position);
        }

        public void addFragment(Fragment fragment, String name) {
            fragmentList.add(fragment);
            fragmentTitles.add(name);
        }
    }
}
