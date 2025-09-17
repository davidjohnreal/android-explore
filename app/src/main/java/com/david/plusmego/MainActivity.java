package com.david.plusmego;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.david.plusmego.Fragments.NewListFragment;
import com.david.plusmego.Fragments.NewsDetailFragment;

public class MainActivity extends AppCompatActivity implements NewListFragment.OnNewsSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
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

}