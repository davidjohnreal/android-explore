package com.david.plusmego.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class Adater2ForHome extends FragmentStateAdapter {
    // 数据源：Fragment 列表和 Tab 标题列表
    private final List<Fragment> fragmentList;
    private final List<String> tabTitleList;
    public Adater2ForHome(@NonNull FragmentActivity fragmentactivity, @NonNull List<Fragment> fragmentList, @NonNull List<String> tabTitleList) {
        super(fragmentactivity);
        this.fragmentList = fragmentList;
        this.tabTitleList = tabTitleList;
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }
    public String getTabTile(int position){
        return tabTitleList.get(position);
    }

}
