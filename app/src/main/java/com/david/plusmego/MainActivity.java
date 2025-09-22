package com.david.plusmego;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.david.plusmego.Adapter.AdapterForHome;
import com.david.plusmego.Adapter.Adater2ForHome;
import com.david.plusmego.Fragments.HomeFragment;
import com.david.plusmego.Fragments.NewListFragment;
import com.david.plusmego.Fragments.NewsDetailFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NewListFragment.OnNewsSelectedListener{
    private TabLayout tabLayout;
    private ViewPager viewPagerTab;
    private ViewPager2 viewPagerTab2;
    private Adater2ForHome adapter;
    private ArrayList<Fragment> fragmentList;
    private ArrayList<String> tabTitleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
         tabLayout = findViewById(R.id.tl_title);
//         viewPagerTab = findViewById(R.id.viewPagerTab); //viewPager
        viewPagerTab2 = findViewById(R.id.viewPagerTab2);//viewPager2

        fragmentList = new ArrayList<>();
        tabTitleList = new ArrayList<>();
        fragmentList.add(HomeFragment.newInstance("首页"));
        fragmentList.add(HomeFragment.newInstance("消息"));
        fragmentList.add(HomeFragment.newInstance("我的"));
        tabTitleList.add("首页");
        tabTitleList.add("消息");
        tabTitleList.add("我的");
        //viewPager
//        AdapterForHome adapter = new AdapterForHome(getSupportFragmentManager(), fragmentList, tabTitleList);
//        viewPagerTab.setAdapter(adapter);
//        tabLayout.setupWithViewPager(viewPagerTab);
//        viewPagerTab.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                Log.d("david", "选择: "+tabTitleList.get(position)+"选项");
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
        //viewPager2
        adapter = new Adater2ForHome(this, fragmentList, tabTitleList);
        viewPagerTab2.setAdapter(adapter);
        new TabLayoutMediator(tabLayout, viewPagerTab2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int i) {
                tab.setText(adapter.getTabTile(i));// 设置每个 Tab 的标题（从 Adapter 中获取）
            }
        }).attach();// 必须调用 attach() 完成绑定
        viewPagerTab2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Log.d("david", "选择: "+ tabTitleList.get(position));

            }
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        if(fragmentManager.findFragmentById(R.id.fragment_container) == null){
            NewListFragment listFragment = new NewListFragment();
            fragmentManager.beginTransaction().add(R.id.fragment_container,listFragment).commit();

        }

    }

    @Override
    public void onNewsSelected(String newTitles) {
        // 处理新闻选中事件
        NewsDetailFragment detailFragment = NewsDetailFragment.newInstance(newTitles);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container,detailFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void addNewTab(Fragment fragment, String title) {
        fragmentList.add(fragment);
        tabTitleList.add(title);
        // 调用 notifyDataSetChanged() 自动刷新
        adapter.notifyDataSetChanged();
        // 可选：切换到新添加的页面
        viewPagerTab2.setCurrentItem(fragmentList.size() - 1);
    }

    // 示例：动态删除最后一个 Tab
    public void removeLastTab() {
        if (fragmentList.size() > 0) {
            fragmentList.remove(fragmentList.size() - 1);
            tabTitleList.remove(tabTitleList.size() - 1);
            adapter.notifyDataSetChanged();
        }
    }

}