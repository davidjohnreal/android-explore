package com.david.plusmego.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.david.plusmego.R;

public class HomeFragment extends Fragment {
    public static HomeFragment newInstance(String title){
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString("title",title);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        TextView tvTitle = view.findViewById(R.id.tvTitle);
        if(getArguments() != null){
            tvTitle.setText(getArguments().getString("title"));
        }
        return view;
    }
}
