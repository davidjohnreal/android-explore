package com.david.plusmego.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class AdapterForHome extends FragmentPagerAdapter {
    private final List<Fragment> fragmentList;
    private final List<String> tabTitleList;

    public AdapterForHome(@NonNull FragmentManager fm, List<Fragment> fragmentList, List<String> tabTitleList) {
        super(fm);
        this.fragmentList = fragmentList;
        this.tabTitleList = tabTitleList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
    public CharSequence getPageTitle(int position) {
        return tabTitleList.get(position);
    }
}
